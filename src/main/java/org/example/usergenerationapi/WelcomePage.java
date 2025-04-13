package org.example.usergenerationapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomePage {

    @GetMapping("/page")
    @ResponseBody
    public String greeting(){
        return "Hello World!";
    }
}
