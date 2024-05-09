package team.college.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.college.database.model.entity.*;
import team.college.database.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("product/")
public class ProductController {

        @Autowired
        private ProductService productService;
        

        @PostMapping("create")
        public Product create(@RequestBody Product product) {
                
                return productService.create(product);
        }

        @PostMapping("update")
        public Product update(@RequestBody Product product) {
                
                return productService.update(product);
        }

        @GetMapping("{product_id}/remove")
        public void remove(@PathVariable Integer product_id) {
                productService.removeProduct(product_id);
        }

        @GetMapping("buy")
        public Boolean buy(@RequestParam Integer product_id, @RequestParam Integer order_id, @RequestParam Integer amount) {
                return productService.buyProduct(product_id, order_id, amount);
        }

        @GetMapping("cancel")
        public Boolean buy(@RequestParam Integer product_id, @RequestParam Integer order_id) {
                return productService.cancelProduct(product_id, order_id);

        }

        @GetMapping("all")
        public List<Product> all() {
                return productService.all();
        }
}
