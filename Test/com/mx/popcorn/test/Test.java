package com.mx.popcorn.test;

import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;
import com.mx.popcorn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2014-10-30.
 */
public class Test {

    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    @org.junit.Test
    public void test1(){
        try {
            UserService service = (UserService) context.getBean("userServiceImp");
            User user = new User();
            user.setEmail("821322652@qq.com");
            user.setPassword("123");
            service.register(user);
        } catch (UserExitException e) {
            System.out.println("hehe");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("--------------------滴滴滴--------------");
            e.printStackTrace();
        }
    }

}
