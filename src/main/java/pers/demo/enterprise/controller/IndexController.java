package pers.demo.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/14 12:06
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex(){
        return "/index";
    }
}
