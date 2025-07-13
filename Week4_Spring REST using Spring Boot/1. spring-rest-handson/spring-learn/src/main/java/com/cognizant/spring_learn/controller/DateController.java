package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DateController {

    @GetMapping("/date")
    public String showFormattedDate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat dateFormat = (SimpleDateFormat) context.getBean("dateFormat");
        String formattedDate = dateFormat.format(new Date());
        return "Formatted Date: " + formattedDate;
    }
}
