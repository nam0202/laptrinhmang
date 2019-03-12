package com.example.laptrinhmang.Controller;

import com.example.laptrinhmang.Controller.VMData.Login;
import com.example.laptrinhmang.Data.Bill;
import com.example.laptrinhmang.Data.User;
import com.example.laptrinhmang.Model.BillData;
import com.example.laptrinhmang.Model.ProductData;
import com.example.laptrinhmang.Model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private BillData billData = new BillData();
    private ProductData productData = new ProductData();
    private UserData userData = new UserData();
    @GetMapping("/admin")
    public String loginAdmin(){
        return "Login.html";
    }
    @GetMapping("/muahang/{productName}")
    public String muHang(@PathVariable("productName") String productName){
        System.out.println(productName);
        return "MuaHang.html";
    }
    @PostMapping("/muahang/{productName}")
    public String muHang(Bill bill,@PathVariable("productName") String productName){
        System.out.println(productName);
        System.out.println(bill.toString());
        return "MuaHang.html";
    }
    @PostMapping("/admin")
    public String loginAdmin(User user){
        if(userData.LoginUser(user)){
            return "redirect:/admin/home";
        }
        return "Login.html";
    }
    @GetMapping("/admin/home")
    public String homeAdmin(){
        return "Menu_admin.html";
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("listProduct",productData.getAllProducts());

        return "Menu.html";
    }
}
