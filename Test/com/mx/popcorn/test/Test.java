package com.mx.popcorn.test;

import com.mx.popcorn.domain.MovieType;
import com.mx.popcorn.domain.MovieVersion;
import com.mx.popcorn.domain.User;
import com.mx.popcorn.exception.UserExitException;
import com.mx.popcorn.service.TypeService;
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

    @org.junit.Test
    public void test2(){
        System.out.println("移动".compareTo("啊"));
    }

    @org.junit.Test
    public void test3(){
        TypeService typeService = (TypeService) context.getBean("typeServiceImp");
        MovieType type = new MovieType();
        MovieType type2 = new MovieType();
        MovieType type3 = new MovieType();
        MovieType type4 = new MovieType();
        MovieType type5= new MovieType();
        MovieType type6 = new MovieType();
        type.setName("惊悚片");
        type2.setName("爱情片");
        type3.setName("科幻片");
        type4.setName("悬疑片");
        type5.setName("剧情片");
        type6.setName("动作片");
        typeService.addMovieType(type);
        typeService.addMovieType(type2);
        typeService.addMovieType(type3);
        typeService.addMovieType(type4);
        typeService.addMovieType(type5);
        typeService.addMovieType(type6);
    }

    @org.junit.Test
    public void test4(){
        TypeService typeService = (TypeService) context.getBean("typeServiceImp");
        MovieVersion type = new MovieVersion();
        MovieVersion type2 = new MovieVersion();
        type.setName("3D");
        type2.setName("IMAX 3D");
        typeService.addMovieVersion(type);
        typeService.addMovieVersion(type2);
    }

}
