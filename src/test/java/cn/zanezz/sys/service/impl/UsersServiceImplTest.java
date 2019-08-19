package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.mapper.BaseTest;
import cn.zanezz.sys.service.IUsersService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UsersServiceImplTest extends BaseTest {

    @Autowired
    IUsersService usersService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserByName() {
    }

    @Test
    public void getRolesByUsername() {
    }

    @Test
    public void getPermissionsByUsername() {

        System.out.println(usersService.getPermissionsByUsername("admin"));
    }
}