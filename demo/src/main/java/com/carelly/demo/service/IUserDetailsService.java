package com.carelly.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.carelly.demo.model.Rol;
import com.carelly.demo.repository.IUserJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IUserDetailsService implements UserDetailsService{

    @Autowired
    private IUserJpaRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.carelly.demo.model.User us = userRepo.findByName(username);

        List<GrantedAuthority> roles = new ArrayList<>();

        for (Rol rol : us.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        }
        
        UserDetails userDet = new User(us.getName(), us.getPassword(), roles);

        return userDet;
    }
    
}
