package com.example.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class User implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String userName;

        private String password;

        private String email;

        public String name;

        private String phone;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "USER_ID",referencedColumnName = "id")},inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "id") })
        private Set<Role> role;
}
