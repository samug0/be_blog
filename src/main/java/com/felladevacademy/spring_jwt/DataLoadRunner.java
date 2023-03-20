package com.felladevacademy.spring_jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.felladevacademy.spring_jwt.model.ERole;
import com.felladevacademy.spring_jwt.model.Role;
import com.felladevacademy.spring_jwt.model.User;
import com.felladevacademy.spring_jwt.repository.RoleRepository;
import com.felladevacademy.spring_jwt.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DataLoadRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

        Role r_admin = new Role();
        r_admin.setName(ERole.ROLE_ADMIN);
        roleRepository.save(r_admin);

        Role r_user = new Role();
        r_user.setName(ERole.ROLE_USER);
        roleRepository.save(r_user);

        Role r_moderator = new Role();
        r_moderator.setName(ERole.ROLE_MODERATOR);
        roleRepository.save(r_moderator);

        User u_moderator = new User("user_moderator", "moderatorEmail@gmail.com", encoder.encode("mygoodpassword"), r_moderator);
        userRepository.save(u_moderator);

        User u_admin = new User("user_admin", "adminEmail@gmail.com", encoder.encode("mygoodpassword"), r_admin);
        userRepository.save(u_admin);

        User u_user = new User("user_user", "userEmail@gmail.com", encoder.encode("mygoodpassword"), r_user);
        userRepository.save(u_user);

    }
}   
