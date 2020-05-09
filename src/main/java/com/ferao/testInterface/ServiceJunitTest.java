package com.ferao.testInterface;

import com.ferao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceJunitTest {

    public static void main (String[] args)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/bean.xml");
        UserService user = (UserService) ac.getBean("userServiceimpl");
        user.findAll();
    }
}
