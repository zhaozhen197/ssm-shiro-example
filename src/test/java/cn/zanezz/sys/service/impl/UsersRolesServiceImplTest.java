package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.entity.Roles;
import cn.zanezz.sys.mapper.BaseTest;
import cn.zanezz.sys.service.IUsersRolesService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;

import java.util.List;

import static org.junit.Assert.*;

public class UsersRolesServiceImplTest extends BaseTest {
    @Autowired
    private IUsersRolesService usersRolesService;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRolesByUsername() {
        List<Roles> rolesList=  usersRolesService.getRolesByUsername("admin");
        System.out.println(rolesList);
    }
}