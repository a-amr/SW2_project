package team.college.product.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
        private Integer id;
        private Double price;
        private String method;
        private User user;
}
