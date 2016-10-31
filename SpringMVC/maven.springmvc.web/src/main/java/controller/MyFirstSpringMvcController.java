package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstSpringMvcController {
    
    @RequestMapping("mvc")
    public String HelloSpringMvc() {
        return "home"; // 返回 jsp 文件名称
    }
}