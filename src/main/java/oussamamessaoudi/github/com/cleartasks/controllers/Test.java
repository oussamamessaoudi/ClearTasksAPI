package oussamamessaoudi.github.com.cleartasks.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("/")
    public String testApi(){
        return "Hello World";
    }
}
