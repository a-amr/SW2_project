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
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String name;
        private String email;
        private String password;

        @JsonIgnore
        @OneToMany(mappedBy = "user")
        public List<Order> orders;
        @JsonIgnore
        @OneToMany(mappedBy = "user")
        public List<Payment> payments;
}
