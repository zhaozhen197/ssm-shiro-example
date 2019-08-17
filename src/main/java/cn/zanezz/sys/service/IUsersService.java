package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
