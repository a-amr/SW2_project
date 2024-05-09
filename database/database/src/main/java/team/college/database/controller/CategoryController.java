package team.college.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.college.database.model.entity.*;
import team.college.database.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

        @Autowired
        private CategoryService categoryService;

        @PostMapping("add")
        public void add(@RequestBody Category category) {
                categoryService.add(category);
        }

        @PostMapping("update")
        public void update(@RequestBody Category category) {
                categoryService.update(category);
        }

        @GetMapping("remove")
        public Boolean remove(@RequestParam Integer category_id) {
                return categoryService.remove(category_id);
        }

        @GetMapping("get")
        public Category get(@RequestParam Integer category_id) {
                return categoryService.get(category_id);
        }

        @GetMapping("all")
        public List<Category> all() {
                return categoryService.all();
        }
}
