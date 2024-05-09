package team.college.database.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Table
@Entity
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Integer amount;
        private Double price;
        private String name;
        private String description;
        
        @ManyToOne
        private Category category;
}
