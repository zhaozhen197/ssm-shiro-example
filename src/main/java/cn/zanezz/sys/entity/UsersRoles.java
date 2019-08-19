package cn.zanezz.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-19
 */
@TableName("sys_users_roles")
public class UsersRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 角色编号
     */
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UsersRoles{" +
            "userId=" + userId +
            ", roleId=" + roleId +
        "}";
    }
}
