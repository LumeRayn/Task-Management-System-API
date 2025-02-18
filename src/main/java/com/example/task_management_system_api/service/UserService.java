package com.example.task_management_system_api.service;

import com.example.task_management_system_api.model.User;
import com.example.task_management_system_api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return this.repository.getAll();
    }

    public User getByLogin(String login) {
        return this.repository.getByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(
                u.getLogin(),              // username
                u.getPassword(),           // password
                true,                      // enabled
                true,                      // accountNonExpired
                true,                      // credentialsNonExpired
                true,                      // accountNonLocked
                new HashSet<>()          // authorities
        );
    }
}
