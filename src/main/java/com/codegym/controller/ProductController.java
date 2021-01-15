package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();
    @GetMapping(value = "/product")
    public  String index(Model model)
    {
        List<Product> productList = productService.findAll();
        model.addAttribute("product",productList);
        return "product";
    }
    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/Product/create";
    }
    @PostMapping("/product/save")
    public String save(Product product,RedirectAttributes redirect) {
        product.setId((int)(Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success","Added product success");
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/Product/edit";
    }
    @PostMapping("/product/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/Product/delete";
    }
    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/Product/view";
    }

    @PostMapping("product/search")
    public String search(@RequestParam String search,Model model){
        List<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        for (int i =0; i<products.size(); i++) {
            if(products.get(i).getName().toLowerCase().contains(search.toLowerCase())) {
                productList.add(products.get(i));
            }
        }
        model.addAttribute("product",productList);
        return "product";
    }

}
