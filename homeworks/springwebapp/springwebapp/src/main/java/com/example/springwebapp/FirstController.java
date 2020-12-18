package com.example.springwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class FirstController {
    @GetMapping()
    public String index(HttpServletRequest servletRequest) {
        String name = servletRequest.getParameter("name");
        System.out.println(name);

        return "index";
    }

    @GetMapping("/sec")
    public String second(HttpServletRequest request) {
        String lname = request.getParameter("lname");
        String age = request.getParameter("age");
        System.out.println(lname + " " + age);
        return "second";
    }

    @GetMapping("/three")
    public String three(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lname", required = false) String lname) {
        System.out.println(name + " " + lname);
        return "third";
    }

    @GetMapping("/four")
    public String four() {
        return "four";
    }

    @GetMapping("/fiv")
    public String five(@RequestParam(value = "name") String name, @RequestParam(value = "lname") String lname) {
        System.out.println(name + " " + lname);
        return "five";
    }

    @GetMapping("/six")
    public String sixpage(Model model) {
//        int randomNum = (int) (Math.random() * 100);
//        GregorianCalendar calendar = new GregorianCalendar();
//        model.addAttribute("myVariable", calendar.getTime());
        Student student = new Student("Eleonor","Harutyunyan",23,new int[]{20,20,8,1});
        model.addAttribute("student1",student);
        return "sixpage";
    }
}
