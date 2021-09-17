package com.example.service;

import com.example.dtos.UserDto;
import com.example.jpa.RoleRepo;
import com.example.jpa.UserRepo;
import com.example.models.Role;
import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service(value = "userService")
public class UserRoleService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    public User saveUser(UserDto user) {
        User savedUser = null;
        try {
            User nUser = user.getUserFromDto();
            Role role = roleRepo.findRoleByName("USER");
            //nUser.setRole(user.getRole());
            nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
            HashSet<Role> userRole = new HashSet<Role>();
            userRole.add(role);
            userRepo.save(nUser);
            nUser.setRole(userRole);
            savedUser = userRepo.save(nUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return savedUser;
    }
}
