package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Permissions;
import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-16
 */
public interface IUsersService extends IService<Users> {


    Users findUserByName(String username);
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
