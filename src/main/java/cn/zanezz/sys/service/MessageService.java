package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.ReturnMessage;

public interface MessageService {

    /**
     * 发送短信
     * @param mobeil
     * @return
     */
    public ReturnMessage sendMsg(String mobeil);

    /**
     * 根据电话号码查找验证码
     *
     * @param phone
     * @return
     */
    public ReturnMessage selectCodeByPhone(String phone, String code);

    public int updateUsableOfMessage(Integer messageId);

}
