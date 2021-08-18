package xyz.bikea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@Controller
public class BikeContribController {
    @RequestMapping("form.html")
    public String distribution(){
        return "form";
    }

    @RequestMapping("empty.html")
    public String empty(){
        return "empty";
    }


}
