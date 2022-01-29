package com.bf.studysb.Controller;

import com.bf.studysb.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

@RestController
@RequestMapping("prop")
public class PropertiesController {

    @Autowired
    private TestProperties testProperties;

    @GetMapping("/getProp")
    public @ResponseBody
    HashMap<String, String> getProperties() {

        HashMap res = new HashMap();

        res.put("name", testProperties.getName());
        res.put("random-string", testProperties.getRandomString());

        return res;
    }
}
