package com.example.endtermgmail;


import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String password,
                           @RequestParam String email) throws MessagingException {
        UserEntity user = userService.registerUser(name, password, email);
        emailService.SendMail(email,"Registr",name,user.getId(),"Congrats");
        return "redirect:/login";
    }
}
