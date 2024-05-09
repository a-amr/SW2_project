package team.college.payment.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import team.college.payment.model.*;

@Service
public class PaymentServiceImp implements PaymentService{

        private final String URL = "http://localhost:8080/payment/";
        private final org.springframework.web.client.RestTemplate restTemplate;
        private final org.springframework.http.HttpHeaders httpHeaders;
    
        public PaymentServiceImp(org.springframework.web.client.RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
                this.httpHeaders = new org.springframework.http.HttpHeaders();
        }

        public void addPayment(Payment payment) {
                if (payment.getPrice() == null || payment.getMethod() == null || payment.getPrice() < 0)
                        return;
                httpHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
                org.springframework.http.HttpEntity<Payment> request = new org.springframework.http.HttpEntity<>(payment, httpHeaders);
                restTemplate.postForObject(URL + "add", request, Payment.class);
        }

        public void removePayment(Integer payment_id) {
                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "remove")
                .queryParam("payment_id", payment_id);
                Boolean status = restTemplate.getForObject(builder.toUriString(), Boolean.class);
                if (!status)
                        throw new RuntimeErrorException(null);
        }
}
