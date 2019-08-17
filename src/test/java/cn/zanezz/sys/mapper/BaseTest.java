package cn.zanezz.sys.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: helloSSM->BaseTest
 * @description: spring单元测试的基类
 * @author: zhaozhen
 * @create: 2019-08-16 19:54
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-shiro.xml"})
public class BaseTest {
}
