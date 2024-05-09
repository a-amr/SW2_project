package team.college.category.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.college.category.model.*;
import team.college.category.service.CategoryServiceImp;

@RestController
@RequestMapping("/category")
public class CategoryController {


        @Autowired
        private CategoryServiceImp categoryServiceImp;

        @PostMapping("/add")
        public void addCategory(@RequestBody Category category) {
                categoryServiceImp.addCategory(category);
        }
        
        @PostMapping("/update")
        public void updateCategory(@RequestBody Category category) {
                categoryServiceImp.updateCategory(category);
        }

        @GetMapping("/remove")
        public void removeCategory(@RequestParam Integer category_id) {
                categoryServiceImp.removeCategory(category_id);
        }

        @GetMapping("/get")
        public Category getCategory(@RequestParam Integer category_id) {
                return categoryServiceImp.getCategory(category_id);
        }

        @GetMapping("all")
        public List<Category> all() {
                return categoryServiceImp.all();
        }
}
