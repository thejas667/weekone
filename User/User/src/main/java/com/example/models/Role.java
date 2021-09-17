package com.example.models;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Role implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;
        private String name;
        private String description;

        @ManyToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Set<User> users;

}
