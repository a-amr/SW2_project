package team.college.user.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import team.college.user.model.*;

@Service
public class UserServiceImp implements UserService{
        private final String URL = "http://localhost:8080/user/";
        private final org.springframework.http.HttpHeaders httpHeaders;
        private final org.springframework.web.client.RestTemplate restTemplate;
    
        public UserServiceImp(org.springframework.web.client.RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
                this.httpHeaders = new org.springframework.http.HttpHeaders();
        }

        public List<User> allUsers() {
                // get request that get all users
                ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
                return responseEntity.getBody();
        }


        public List<Order> userOrders(Integer user_id) {
                // get request that get all orders of user require user_id
                ResponseEntity<List<Order>> responseEntity = restTemplate.exchange(URL + user_id + "/orders", HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {});
                return responseEntity.getBody();
        }

        public List<Payment> userPayments(Integer user_id) {
                // get request that get all orders of user require user_id
                ResponseEntity<List<Payment>> responseEntity = restTemplate.exchange(URL + user_id + "/payments", HttpMethod.GET, null, new ParameterizedTypeReference<List<Payment>>() {});
                return responseEntity.getBody();
        }

        public void createUser(User user) {
                if (user.getEmail() == null || user.getPassword() == null || user.getName() == null)
                {
                        return;
                }
                List<User> users = allUsers();
                for (User u : users) {
                        if (u.getEmail().equals(user.getEmail()))
                        {
                                return;
                        }
                }
                // post request that create new user require email, password and name
                httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
                org.springframework.http.HttpEntity<User> request = new org.springframework.http.HttpEntity<>(user, httpHeaders);
                restTemplate.postForObject(URL + "register", request, Void.class);
        }

        public User loginUser(User user) {
                // post request that get user information require email & password
                if (user.getEmail() == null || user.getPassword() == null)
                {
                        throw new RuntimeErrorException(null);
                }
                List<User> users = allUsers();
                for (User u : users) {
                        if (u.getEmail().equalsIgnoreCase(user.getEmail()))
                        {
                                if (u.getPassword().equals(user.getPassword()))
                                {
                                        user.setId(u.getId());
                                        user.setName(u.getName());
                                        user.setOrders(u.getOrders());
                                        user.setPayments(u.getPayments());
                                        return u;
                                }
                                throw new RuntimeErrorException(null);
                        }
                }
                throw new RuntimeErrorException(null);
        }

        public User updateUser(User user) {
                if (user.getId() == null)
                {
                        return null;
                }
                // post request that update user require user_id
                List<User> users = allUsers();
                for (User u : users) {
                        if (u.getId() == user.getId())
                        {
                                httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
                                org.springframework.http.HttpEntity<User> request = new org.springframework.http.HttpEntity<>(user, httpHeaders);
                                return restTemplate.postForObject(URL + "update", request, User.class);
                        }
                }
                return null;
        }

        // public void logoutUser() {
        //         // User logs out
        // }

        // public void addOrder(Integer user_id, Integer order_id) {
        //         // post request that add order to user orders require user_id, order_id
        //         // add order_id to user order_id List
        //         // update database
        //         List<User> users = allUsers();
        //         for (User u : users) {
        //                 if (u.getId() == user_id)
        //                 {
        //                         UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "addOrder")
        //                                 .queryParam("user_id", user_id)
        //                                 .queryParam("order_id", order_id);
        //                         restTemplate.getForObject(builder.toUriString(), Void.class);
        //                 }
        //         }
        //         return;
        // }

        // public void removeOrder(Integer user_id, Integer order_id) {
        //         // post request that remove order from user orders require user_id, order_id
        //         // remove order_id from user order_id List if exist
        //         // update database
        //         List<User> users = allUsers();
        //         for (User u : users) {
        //                 if (u.getId() == user_id)
        //                 {
        //                         UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "removeOrder")
        //                                 .queryParam("user_id", user_id)
        //                                 .queryParam("order_id", order_id);
        //                         restTemplate.getForObject(builder.toUriString(), Void.class);
        //                 }
        //         }
        //         return;
        // }


        public User getUser(Integer user_id) {
                List<User> users = allUsers();
                for (User u : users) {
                        if (u.getId() == user_id)
                        {
                                return u;
                        }
                }
                throw new RuntimeErrorException(null);
        }
}
