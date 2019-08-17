package cn.zanezz.sys.mapper;

import cn.zanezz.sys.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-16
 */
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 根据username来查找用户登录信息。
     * @param username
     * @return
     */
    Users findUsersByName(String username);


}
