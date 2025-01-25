//package com.util;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public String handleAllExceptions(Exception ex, Model model) {
//        // 处理其他所有异常，返回默认错误页面
//        model.addAttribute("error","在跳转页面时出现错误");
//        model.addAttribute("address","../main.jsp");
//        return "tryAgain";
//    }
//}