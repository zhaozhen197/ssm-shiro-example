package cn.zanezz.sys.mapper;

import cn.zanezz.sys.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * 根据用户手机号查询用户
     * @param phone
     * @return
     */
    User selectUserByPhone(String phone);

    /**
     * 获取所有的用户列表
     * @return
     */
    List<User> selectAllUser();

}