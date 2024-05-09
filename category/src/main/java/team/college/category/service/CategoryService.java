package team.college.category.service;


import team.college.category.model.Category;

public interface CategoryService {

    public void addCategory(Category category);
    public void updateCategory(Category category);
    public void removeCategory(Integer category_id);
    public Category getCategory(Integer category_id);
}
