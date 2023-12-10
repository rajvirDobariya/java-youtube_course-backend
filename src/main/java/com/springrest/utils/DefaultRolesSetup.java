package com.springrest.utils;

import com.springrest.entity.Role;
import com.springrest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultRolesSetup implements ApplicationRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public DefaultRolesSetup(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Check if roles exist
        if (!roleRepository.existsByAuthority("USER")) {
            Role userRole = new Role("USER");
            roleRepository.save(userRole);
        }

        if (!roleRepository.existsByAuthority("ADMIN")) {
            Role adminRole = new Role("ADMIN");
            roleRepository.save(adminRole);
        }
    }
}