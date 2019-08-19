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
@TableName("sys_roles_permissions")
public class RolesPermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    private Long roleId;

    /**
     * 权限编号
     */
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolesPermissions{" +
            "roleId=" + roleId +
            ", permissionId=" + permissionId +
        "}";
    }
}
