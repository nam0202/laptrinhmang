package com.example.laptrinhmang.Controller;

import com.example.laptrinhmang.Controller.VMData.ChatMessage;
import com.example.laptrinhmang.Controller.VMData.Login;
import com.example.laptrinhmang.Data.Bill;
import com.example.laptrinhmang.Data.Product;
import com.example.laptrinhmang.Data.User;
import com.example.laptrinhmang.Model.BillData;
import com.example.laptrinhmang.Model.ProductData;
import com.example.laptrinhmang.Model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private BillData billData = new BillData();
    private ProductData productData = new ProductData();
    private UserData userData = new UserData();


    @GetMapping("/admin")
    public String loginAdmin() {
        return "Login.html";
    }

    @GetMapping("/muahang/{indexProduct}")
    public String muHang(@PathVariable("indexProduct") int indexProduct, Model model) {
        Product product = productData.getProductByIndex(indexProduct);
        if (product == null) {
            return "redirect:/";
        } else {
            model.addAttribute("product", product);
            Bill bill = new Bill();
            bill.setProducts(product);
            model.addAttribute("bill", bill);
            System.out.println(product);
            return "MuaHang.html";
        }
    }

    @PostMapping("/admin")
    public String loginAdmin(User user) {
        if (userData.LoginUser(user)) {
            return "redirect:/admin/home";
        }
        return "Login.html";
    }

    @GetMapping("/admin/home")
    public String homeAdmin(Model model) {
        model.addAttribute("listProduct", productData.getAllProducts());

        return "Menu_admin.html";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("listProduct", productData.getAllProducts());
        return "Menu.html";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @PostMapping("/muahang/{indexProduct}")
    public String muaHang(
            @ModelAttribute("bill") Bill bill,
            @PathVariable("indexProduct") Integer indexProduct,
            @Payload ChatMessage chatMessage
    ) {
        boolean result = this.billData.addBill(bill);
        System.out.println(chatMessage.getContent());
        return "redirect:/";
    }

    @GetMapping("/admin/hoadon")
    public String hoaDon(Model mode){
        mode.addAttribute("listBill",billData.getListBill());
        return "ListHoaDon";
    }
    @GetMapping("/admin/hoadon/{id}")
    public String hoaDon(@PathVariable("id") int id,Model model){
        Bill bill = billData.getBillById(id);
        System.out.println(bill);
        if(bill ==null){
            return "redirect:/admin/hoadon";
        }else {
            model.addAttribute("bill",bill);
            return "ChiTietBill";
        }
    }

    @MessageMapping("/chat.status")
    @SendTo("/topic/listener")
    public ChatMessage sendMStatus(@Payload ChatMessage chatMessage) {
        System.out.println(chatMessage.getContent());
        return chatMessage;
    }


    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
