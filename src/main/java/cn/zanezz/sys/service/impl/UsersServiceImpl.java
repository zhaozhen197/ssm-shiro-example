package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.entity.Users;
import cn.zanezz.sys.mapper.UsersMapper;
import cn.zanezz.sys.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
