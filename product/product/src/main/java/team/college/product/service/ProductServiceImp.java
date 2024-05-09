package team.college.product.service;


import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import team.college.product.model.Product;

@Service
@Repository
public class ProductServiceImp implements ProductService{

        private final String URL = "http://localhost:8080/product/";
        private final org.springframework.web.client.RestTemplate restTemplate;
        private final org.springframework.http.HttpHeaders httpHeaders;
    
        public ProductServiceImp(org.springframework.web.client.RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
                this.httpHeaders = new org.springframework.http.HttpHeaders();
        }

        public void createProduct(Product product) {
                if (product.getAmount() == null || product.getAmount() < 0 || product.getPrice() == null || product.getPrice() < 0)
                        return;
                httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
                org.springframework.http.HttpEntity<Product> request = new org.springframework.http.HttpEntity<>(product, httpHeaders);
                restTemplate.postForObject(URL + "create", request, Product.class);
        }

        public void updateProduct(Product product) {
                if (product.getId() == null)    return;
                httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
                org.springframework.http.HttpEntity<Product> request = new org.springframework.http.HttpEntity<>(product, httpHeaders);
                restTemplate.postForObject(URL + "update", request, Product.class);
        }

        public void removeProduct(Integer product_id) {
                restTemplate.getForObject(URL + product_id.toString() +"/remove", Void.class);
        }

        public void buyProduct(Integer product_id, Integer order_id, Integer amount) {
                if (amount < 1) return;
                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "buy")
                .queryParam("product_id", product_id)
                .queryParam("order_id", order_id)
                .queryParam("amount", amount);
                Boolean status = restTemplate.getForObject(builder.toUriString(), Boolean.class);
                if (!status) {
                        throw new RuntimeException("Status is false, operation cannot proceed.");
                }
        }

        public void cancelProduct(Integer product_id, Integer order_id) {
                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "cancel")
                .queryParam("product_id", product_id)
                .queryParam("order_id", order_id);
                Boolean status = restTemplate.getForObject(builder.toUriString(), Boolean.class);
                if (!status) {
                        throw new RuntimeException("Status is false, operation cannot proceed.");
                }

                    
        }


        public List<Product> all() {
                return restTemplate.exchange(
                        URL + "all",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Product>>() {}).getBody();
        }
}
