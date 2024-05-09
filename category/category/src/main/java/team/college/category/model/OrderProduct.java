package team.college.category.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderProduct {
        private Integer id;
        private Order order;
        private Product product;
        private Integer amount;
}