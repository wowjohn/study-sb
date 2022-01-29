package com.bf.studysb.Controller;

import com.bf.studysb.Entity.User;
import com.bf.studysb.Exception.ApiException;
import com.bf.studysb.Repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    public @ResponseBody
    String add(@RequestParam("name") String name, @RequestParam("email") String email) {

        if(name.length() == 0) {
            throw new ApiException("-1","name 不能为空");
        }

        if(email.length() == 0) {
            throw new ApiException("-1","email 不能为空");
        }

        userMapper.insert(name, email);

        return "Saved";
    }

    @GetMapping("/getUser")
    public @ResponseBody
    User getUser(@RequestParam("name") String name) {
        return userMapper.findByName(name);
    }
}
