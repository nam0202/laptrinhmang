package com.example.laptrinhmang.Controller;

import com.example.laptrinhmang.Controller.VMData.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/admin")
    public String loginAdmin(){
        return "Login.html";
    }
    @PostMapping("/admin")
    public String loginAdmin(Login login){
        if(login.getUsername().equals("admin") && login.getPassword().equals("admin") ){
            return "redirect:/admin/home";
        }
        return "Login.html";
    }
    @GetMapping("/admin/home")
    public String homeAdmin(){
        return "Menu_admin.html";
    }
    @GetMapping("/")
    public String home(){
        return "Menu.html";
    }
}
