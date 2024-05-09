package team.college.product.service;

import team.college.product.model.Product;

public interface ProductService {

    public void createProduct(Product product);

    public void updateProduct(Product product);

    public void removeProduct(Integer product_id);

    public void buyProduct(Integer product_id, Integer order_id, Integer amount);
    public void cancelProduct(Integer product_id, Integer order_id);
}
