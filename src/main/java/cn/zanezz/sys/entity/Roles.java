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
@TableName("sys_roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String role;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 父节点
     */
    private Long pid;

    /**
     * 是否锁定
     */
    private Boolean available;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Roles{" +
            "role=" + role +
            ", description=" + description +
            ", pid=" + pid +
            ", available=" + available +
        "}";
    }
}
