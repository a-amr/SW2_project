package team.college.category.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import team.college.category.model.Category;

@Service
public class CategoryServiceImp implements CategoryService{

    private final String URL = "http://localhost:8080/category/";
    private final org.springframework.web.client.RestTemplate restTemplate;
    private final org.springframework.http.HttpHeaders httpHeaders;

    public CategoryServiceImp(org.springframework.web.client.RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.httpHeaders = new org.springframework.http.HttpHeaders();
    }


    public void addCategory(Category category) {
        if (category.getName() == null) return;
        httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        org.springframework.http.HttpEntity<Category> request = new org.springframework.http.HttpEntity<>(category, httpHeaders);
        restTemplate.postForObject(URL + "add", request, Void.class);
    }

    public void updateCategory(Category category) {
        if (category.getId() == null) return;
        httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        org.springframework.http.HttpEntity<Category> request = new org.springframework.http.HttpEntity<>(category, httpHeaders);
        restTemplate.postForObject(URL + "update", request, Void.class);
    }

    public void removeCategory(Integer category_id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "remove")
                .queryParam("category_id", category_id);
        Boolean status = restTemplate.getForObject(builder.toUriString(), Boolean.class);
        if (!status) {
            throw new RuntimeErrorException(null);
        }
    }

    public Category getCategory(Integer category_id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "get")
                .queryParam("category_id", category_id);
        Category category = restTemplate.getForObject(builder.toUriString(), Category.class);
        if (category != null)
            return category;
        throw new RuntimeErrorException(null);
    }


    public List<Category> all() {
    return restTemplate.exchange(
                    URL + "all",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Category>>() {}).getBody();
    }
}
