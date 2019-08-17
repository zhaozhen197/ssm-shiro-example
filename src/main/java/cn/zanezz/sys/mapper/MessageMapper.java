package cn.zanezz.sys.mapper;

import cn.zanezz.sys.entity.Message;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectCodeByPhone(String phone);

    /**
     *
     *将验证码置为已使用
     * @param messageId
     * @return
     */
    int updateUsableOfMessage(Integer messageId);
}