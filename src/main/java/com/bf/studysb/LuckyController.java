package com.bf.studysb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class LuckyController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {

        User u = new User();

        u.setName(name);
        u.setEmail(email);

        userRepository.save(u);

        return "saved";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
