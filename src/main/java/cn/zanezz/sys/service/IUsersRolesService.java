package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.UsersRoles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-19
 */
public interface IUsersRolesService extends IService<UsersRoles> {

    /**
     * 根据用户名称来查询，该用户所拥有的角色
     * @param username
     * @return
     */
    List<Roles> getRolesByUsername(String username);
}
