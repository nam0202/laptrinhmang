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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
            System.out.println(bill);
            model.addAttribute("bill", bill);
            return "MuaHang.html";
        }
    }
    @PostMapping("/muahang/{indexProduct}")
    public String muaHang(
            @ModelAttribute("bill") Bill bill,
            @PathVariable("indexProduct") int indexProduct
    ) {
        Product product = productData.getProductByIndex(indexProduct);
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setNumbers(bill.getNumber());
        product1.setPrice(product.getPrice());
        product1.setId(product.getId());
        if(product.getNumbers() - product1.getNumbers() > 0){
            product.setNumbers(product.getNumbers() - product1.getNumbers());
        }else {
            product.setNumbers(0);
        }
        bill.setProducts(product1);
        System.out.println(bill);
        boolean result = this.billData.addBill(bill);
        return "redirect:/";
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

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }


    @GetMapping("/admin/hoadon")
    public String hoaDon(Model mode) {
        mode.addAttribute("listBill", billData.getListBill());
        return "ListHoaDon";
    }

    @GetMapping("/admin/hoadon/{id}")
    public String hoaDon(@PathVariable("id") int id, Model model) {
        Bill bill = billData.getBillById(id);
        System.out.println(bill);
        if (bill == null) {
            return "redirect:/admin/hoadon";
        } else {
            model.addAttribute("bill", bill);
            return "ChiTietBill";
        }
    }

    @MessageMapping("/chat.status")
    @SendTo("/topic/listener")
    public ChatMessage sendMStatus(@Payload ChatMessage chatMessage, @SessionAttribute("sessionId") String sessionId) {
        System.out.println(sessionId);
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
    @MessageMapping("/chat.change")
    @SendTo("/topic/change")
    public ChatMessage deleteProduct(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    private final Path rootLocation = Paths.get("filestorage");

    @GetMapping("/admin/add")
    public String addPro(Model model) {
        model.addAttribute("product", new Product());
        return "addPro";
    }

    @GetMapping("/admin/save")
    public String savePro(Model model, HttpServletRequest request, Product product) {
        System.out.println(request.getParameter("img"));
        model.addAttribute("product", new Product());
        product.setName(request.getParameter("name"));
        product.setPrice(Float.parseFloat(request.getParameter("price")));
        product.setNumbers(Integer.parseInt(request.getParameter("numbers")));
        product.setImg(request.getParameter("img"));
        product.setProperties(request.getParameter("properties"));
        product.setUsed(request.getParameter("used"));
        productData.addProduct(product);
        return "redirect:/admin/home";
    }

    @GetMapping("/admin/delete/{id}")
    public String deletePro(@PathVariable int id) {
        System.out.println(id);
        productData.deleteProduct(id);
        return "redirect:/admin/home";
    }

    @GetMapping("/admin/edit/{id}")
    public String editPro(@PathVariable int id, Product product, HttpServletRequest request, Model model) {
        System.out.println(id);
        List<Product> list = productData.getAllProducts();
        model.addAttribute("product", list.get(id));

        return "editPro";
    }

    String urlfile;

    @GetMapping("/admin/edit/save")
    public String saveEditPro(Model model, HttpServletRequest request, Product product) {

        product.setName(request.getParameter("name"));
        product.setPrice(Float.parseFloat(request.getParameter("price")));
        product.setNumbers(Integer.parseInt(request.getParameter("numbers")));
        product.setImg(request.getParameter("img"));
        product.setProperties(request.getParameter("properties"));
        product.setUsed(request.getParameter("used"));
        productData.editProduct(Integer.parseInt(request.getParameter("id")), product);
        return "redirect:/admin/home";
    }
}
