package team.college.category.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Product {
        private Integer id;
        private Integer amount;
        private Double price;
        private String name;
        private String description;
        private Category category;
}
