package cn.zanezz.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhaozhen
 * @since 2019-08-16
 */
@TableName("sys_users")
public class Users implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 角色列表
     */
    private String roleId;

    /**
     * 是否锁定
     */
    private Boolean locked;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }


    public String getCredentialsSalt() {
        return username + salt;
    }
    @Override
    public String toString() {
        return "Users{" +
            "username=" + username +
            ", password=" + password +
            ", salt=" + salt +
            ", roleId=" + roleId +
            ", locked=" + locked +
        "}";
    }
}
