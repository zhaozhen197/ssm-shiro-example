package cn.zanezz.sys.mapper;

import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.entity.UsersRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-19
 */
public interface UsersRolesMapper extends BaseMapper<UsersRoles> {
    /**
     * 根据用户名称来查询，该用户所拥有的角色
     * @param username
     * @return
     */
    List<Roles> getRolesByUsername(String username);
}
