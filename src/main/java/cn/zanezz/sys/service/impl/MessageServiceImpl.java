package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.exception.AException;
import cn.zanezz.sys.service.MessageService;
import cn.zanezz.util.SendMessage;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.MessageMapper;
import cn.zanezz.sys.entity.Message;
import cn.zanezz.sys.entity.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zane
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 根据电话号码查找验证码,并验证
     *
     * @param phone
     * @return
     */
    @Override
    public ReturnMessage selectCodeByPhone(String phone, String code) {

        ReturnMessage returnMessage = new ReturnMessage("验证成功", "Success");
        List<Message> messageList = messageMapper.selectCodeByPhone(phone);
        if (code != null && code != "") {
            if (messageList == null) {
                returnMessage.setMsg("验证码错误");
                returnMessage.setStatusCode("ValidateCodeError1");
            }else {
                Message message = messageList.get(0);
                if (!String.valueOf(message.getValidateCode()).equals(code)) {
                    returnMessage.setMsg("验证码错误");
                    returnMessage.setStatusCode("ValidateCodeError");
                }else {
                    // 将验证码使用标志置为1
                    messageMapper.updateUsableOfMessage(message.getMessageId());
                }
            }
        }else {
            returnMessage.setMsg("验证码为空！");
            returnMessage.setStatusCode("ValidateCodeIsNull");
        }
        return returnMessage;
    }

    @Override
    public int updateUsableOfMessage(Integer messageId) {
        return messageMapper.updateUsableOfMessage(messageId);
    }


    /**
     * 发送验证码
     *
     * @param mobeil
     * @return
     */
    @Override
    @Transactional(rollbackFor = AException.class)
    public ReturnMessage sendMsg(String mobeil) {

        //对手机号进行校验,
        ReturnMessage message = new ReturnMessage("验证码已发送", "Correct");
        if (null == mobeil || "".equalsIgnoreCase(mobeil)) {
            message.setStatusCode("IsNull");
            message.setMsg("手机号不能为空");
        } else {
            if (mobeil.length() != 11) {
                message.setStatusCode("LenthError");
                message.setMsg("手机号长度不正确");
            }
            String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9])|(16[6]))\\d{8}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(mobeil);
            boolean isMatch = m.matches();
            if (!isMatch) {
                message.setStatusCode("FormError");
                message.setMsg("手机号格式不正确");
            }
        }
        if ("Correct".equals(message.getStatusCode())) {
            String validateCode = null;
            try {
                validateCode = SendMessage.send(mobeil);

            } catch (Exception e) {
                message.setStatusCode("SendError");
                message.setMsg("验证码发送失败！请稍后重试");
            }
            Message record = new Message();
            record.setPhone(mobeil);
            Byte sended = 1;
            Byte usable = 0;
            record.setSended(sended);
            record.setUsable(usable);
            record.setValidateCode(Integer.parseInt(validateCode));
            record.setCreationDatetime(Util.getNowDateTime());
            record.setUpdateDatetime(Util.getNowDateTime());
            record.setDeadLine((int) (System.currentTimeMillis() / 1000 + 10 * 60));
            messageMapper.insert(record);
        }
        return message;
    }
}
