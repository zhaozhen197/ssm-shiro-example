package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.entity.Permissions;
import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.mapper.UsersMapper;
import cn.zanezz.sys.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-16
 */
@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {


    @Override
    public Users findUserByName(String username) {
        Users users = this.baseMapper.findUsersByName(username);
        return users;
    }

    /**
     * 根据用户名称来查询，该用户所拥有的角色
     *
     * @param username
     * @return
     */
    @Override
    public List<Roles> getRolesByUsername(String username) {
         List<Roles> rolesList =this.baseMapper.getRolesByUsername(username);

        return rolesList;
    }

    /**
     * 根据username获取权限
     *
     * @param username
     * @return
     */
    @Override
    public List<Permissions> getPermissionsByUsername(String username) {
        return this.baseMapper.getPermissionsByUsername(username);
    }
}
