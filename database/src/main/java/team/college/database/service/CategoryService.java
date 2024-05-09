package team.college.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.college.database.model.entity.*;
import team.college.database.model.repository.CategoryRepository;

@Service
public class CategoryService {

        @Autowired
        private CategoryRepository categoryRepository;


        public Boolean add(Category category) {
                if (category == null) return false;
                if (category.getId() != null) return false;
                if (category.getName() == null || category.getName().isEmpty()) return false;
                categoryRepository.save(category);
                return true;
        }

        public Boolean update(Category category) {
                if (category == null) return false;
                if (category.getName() == null || category.getName().isEmpty()) return false;
                if (category.getId() == null) return false;
                if (categoryRepository.findById(category.getId()).isEmpty()) return false;
                categoryRepository.save(category);
                return true;
        }

        public Boolean remove(Integer category_id) {

                if (categoryRepository.findById(category_id).isPresent())
                {
                        categoryRepository.deleteById(category_id);
                        return true;
                }
                return false;
        }

        public Category get(Integer category_id) {
                if (categoryRepository.findById(category_id).isEmpty()) return null;
                return categoryRepository.findById(category_id).get();
        }

        public List<Category> all() {
                return categoryRepository.findAll();
        }
}
