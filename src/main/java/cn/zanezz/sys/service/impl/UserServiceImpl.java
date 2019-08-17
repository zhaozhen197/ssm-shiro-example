package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.UserService;
import cn.zanezz.sys.mapper.UserMapper;
import cn.zanezz.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:17
 * desc
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 插入用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        return  userMapper.insert(user);

    }

    /**
     * 根据主键更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public int updateUserByPK(User user) {

        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User selectUserByPhone(String phone) {
        return userMapper.selectUserByPhone(phone);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 获取所有的用户列表
     *
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<User> formatPageList(List<User> userList, HashMap<String, String> dictionary) {
        for (User user : userList) {
            user.setType(dictionary.get(user.getType()));
            user.setIdentity(dictionary.get(user.getIdentity()));
            user.setFund(dictionary.get(user.getFund()));
            user.setSocialSecurity(dictionary.get(user.getSocialSecurity()));
            user.setHouse(dictionary.get(user.getHouse()));
            user.setCar(dictionary.get(user.getCar()));
            user.setInsurance(dictionary.get(user.getInsurance()));
            user.setCredit(dictionary.get(user.getCredit()));
        }
        return userList;
    }


}

