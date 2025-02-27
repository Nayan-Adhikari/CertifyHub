package com.certifyhub.auth.service;

import com.certifyhub.auth.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService{

    @Autowired
    private  UserRepo repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<com.certifyhub.auth.model.User> user = repository.findByUsername(username);

        if(user.isPresent()){

            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }else{
            throw  new UsernameNotFoundException(username);
        }
        //throw  new UnsupportedOperationException("Unimplemented method 'loadUserByUsername' ");
    }
}