package com.example.laptrinhmang.Controller;

import com.example.laptrinhmang.Controller.VMData.Login;
import com.example.laptrinhmang.Data.Bill;
import com.example.laptrinhmang.Data.Product;
import com.example.laptrinhmang.Data.User;
import com.example.laptrinhmang.Model.BillData;
import com.example.laptrinhmang.Model.ProductData;
import com.example.laptrinhmang.Model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String loginAdmin(){
        return "Login.html";
    }
    @GetMapping("/muahang/{indexProduct}")
    public String muHang(@PathVariable("indexProduct") int indexProduct,Model model){
        Product product = productData.getProductByIndex(indexProduct);
        if(product == null){
            return "redirect:/";
        }else {
            model.addAttribute("product",product);
            System.out.println(product);
            return "MuaHang.html";
        }
    }
    @PostMapping("/muahang/{indexProduct}")
    public String muHang(Bill bill,@PathVariable("indexProduct") Integer indexProduct){
//        System.out.println(bill.toString());
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
    public String homeAdmin(Model model){
        model.addAttribute("listProduct",productData.getAllProducts());

        return "Menu_admin.html";
    }
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("listProduct",productData.getAllProducts());

        return "Menu.html";
    }

    private final Path rootLocation = Paths.get("filestorage");
    @GetMapping("/admin/add")
    public String addPro(Model model){
        model.addAttribute("product", new Product());
        return "addPro";
    }

    @GetMapping("/admin/save")
    public String savePro(Model model, HttpServletRequest request, Product product){
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
    public String deletePro(@PathVariable int id){
        System.out.println(id);
        productData.deleteProduct(id);
        return "redirect:/admin/home";
    }

    @GetMapping("/admin/edit/{id}")
    public String editPro(@PathVariable int id, Product product, HttpServletRequest request, Model model){
        System.out.println(id);
        List<Product> list = productData.getAllProducts();
        model.addAttribute("product", list.get(id));

        return "editPro";
    }

    String urlfile;
    @GetMapping("/admin/edit/save")
    public String saveEditPro( Model model, HttpServletRequest request, Product product){

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
