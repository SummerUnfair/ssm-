package com.ferao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class itemController {

    /**
     * 通过springmvc ModelAndView 进行结果跳转
     * @return
     */
    @RequestMapping("/t2")
    public ModelAndView test2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","t1 success");
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping("/t3")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.getWriter().println("writer success");
    }

    @RequestMapping("/t4")
    public void test4(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect("test.jsp");
    }

    @RequestMapping("/t5")
    public void test5(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("msg","/t5");
        request.getRequestDispatcher("WEB-INF/pages/test.jsp").forward(request,response);
    }

}
