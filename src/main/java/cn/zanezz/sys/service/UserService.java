package cn.zanezz.sys.service;


import cn.zanezz.sys.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * @author zane
 */
public interface UserService {

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据主键更新用户信息
     * @param user
     * @return
     */
    int updateUserByPK(User user);

    /**
     * 根据手机号查新用户
     * @param phone
     * @return
     */
    User selectUserByPhone(String phone);


    int updateByPrimaryKeySelective(User record);

    /**
     * 获取所有的用户列表
     * @return
     */
    List<User> selectAllUser();

    List<User> formatPageList(List<User> userList, HashMap<String, String> dictionary);

}
