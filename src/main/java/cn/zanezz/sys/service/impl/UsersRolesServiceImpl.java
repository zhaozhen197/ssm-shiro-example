package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.UsersRoles;
import cn.zanezz.sys.mapper.UsersRolesMapper;
import cn.zanezz.sys.service.IUsersRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-19
 */
@Service("usersRolesService")
public class UsersRolesServiceImpl extends ServiceImpl<UsersRolesMapper, UsersRoles> implements IUsersRolesService {


    /**
     * 根据用户名称来查询，该用户所拥有的角色
     *
     * @param username
     * @return
     */
    @Override
    public List<Roles> getRolesByUsername(String username) {
        List<Roles> rolesList = this.baseMapper.getRolesByUsername(username);
        return rolesList;
    }
}
