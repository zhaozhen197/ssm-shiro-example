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
@TableName("sys_permissions")
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限编号
     */
    private String permission;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 此权限关联角色的id
     */
    private Long rid;

    /**
     * 是否锁定
     */
    private Boolean available;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Permissions{" +
            "permission=" + permission +
            ", description=" + description +
            ", rid=" + rid +
            ", available=" + available +
        "}";
    }
}
