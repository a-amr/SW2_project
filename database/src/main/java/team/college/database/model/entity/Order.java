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
@Table(name = "Order_table")
@Entity
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @ManyToOne
        private User user;
        private String date;
        private String address;
        private Double totalCost;
        @JsonIgnore
        @OneToMany(mappedBy = "order")
        public List<OrderProduct> orderProducts;
}
