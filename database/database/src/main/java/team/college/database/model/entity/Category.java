package team.college.database.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Table
@Entity
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private String name;
        @JsonIgnore
        @OneToMany(mappedBy = "category")
        public List<Product> products;

}
