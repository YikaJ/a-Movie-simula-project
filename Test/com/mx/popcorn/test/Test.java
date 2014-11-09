package com.mx.popcorn.test;

import com.mx.popcorn.domain.*;
import com.mx.popcorn.exception.UserExitException;
import com.mx.popcorn.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @org.junit.Test
    public void test5(){
        TypeService typeService = (TypeService) context.getBean("typeServiceImp");
        MovieVersion type = new MovieVersion();
        type.setName("2D");
        typeService.addMovieVersion(type);
    }

    @org.junit.Test
    public void test6(){
        CinemaService cinemaService = (CinemaService) context.getBean("cinemaServiceImp");
        HallService hallService = (HallService) context.getBean("hallServiceImp");
        Cinema cinema  = cinemaService.getCinemaById(1L);
        Set<Hall> halls = new HashSet<Hall>();
        Hall hall1 = new Hall();
        hall1.setNumber(1);
        hall1.setCinema(cinema);
        Hall hall2 = new Hall();
        hall2.setNumber(2);
        hall2.setCinema(cinema);
        Hall hall3 = new Hall();
        hall3.setNumber(3);
        hall3.setCinema(cinema);
        Hall hall4 = new Hall();
        hall4.setNumber(4);
        hall4.setCinema(cinema);
        Hall hall5 = new Hall();
        hall5.setNumber(5);
        hall5.setCinema(cinema);
        halls.add(hall1);
        halls.add(hall2);
        halls.add(hall3);
        halls.add(hall4);
        halls.add(hall5);
        hallService.addHalls(halls);
    }

    @org.junit.Test
    public void test7() throws ParseException {
        /*SimpleDateFormat format = new SimpleDateFormat("EEEE");
        System.out.println(format.format(new Date()));*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(format.format(new Date()));
        System.out.println(date);
    }

    @org.junit.Test
    public void test8(){
        SpaceService spaceService = (SpaceService) context.getBean("spaceServiceImp");
        /*City city = new City();
        city.setName("韶关");
        spaceService.addCity(city);*/
        Province province = new Province();
        province.setName("河北省");
        spaceService.addProvince(province);
    }

}
