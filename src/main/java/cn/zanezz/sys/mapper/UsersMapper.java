package cn.zanezz.sys.mapper;

import cn.zanezz.sys.entity.Permissions;
import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

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
    /**
     * 根据用户名称来查询，该用户所拥有的角色
     * @param username
     * @return
     */
    List<Roles> getRolesByUsername(String username);

    /**
     * 根据username获取权限
     * @param username
     * @return
     */
    List<Permissions> getPermissionsByUsername(String username);

}
