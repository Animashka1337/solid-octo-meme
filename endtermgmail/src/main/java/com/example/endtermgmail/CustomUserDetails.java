package com.example.endtermgmail;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {
    private final UserRepo userRepo;
    public CustomUserDetails(UserRepo userRepo){
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByName(username);
        return User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }
}
