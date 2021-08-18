package xyz.bikea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.bikea.mapper.UserMapper;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/newold.html")
    public String userInfo(Model model){
        int numMale = userMapper.queryNumMale();
        int numFemale = userMapper.queryNumFemale();
        ArrayList numAge = new ArrayList();
        ArrayList numRide = new ArrayList();
        ArrayList numDist = new ArrayList();
        ArrayList numTime = new ArrayList();
        numAge.add(userMapper.queryAge(0,17));
        numAge.add(userMapper.queryAge(18,24));
        numAge.add(userMapper.queryAge(25,29));
        numAge.add(userMapper.queryAge(30,34));
        numAge.add(userMapper.queryAge(35,39));
        numAge.add(userMapper.queryAge(40,80));
        numRide.add(userMapper.queryNumRide(0,2));
        numRide.add(userMapper.queryNumRide(3,5));
        numRide.add(userMapper.queryNumRide(6,10));
        numRide.add(userMapper.queryNumRide(11,15));
        numRide.add(userMapper.queryNumRide(16,20));
        numRide.add(userMapper.queryNumRide(21,25));
        numRide.add(userMapper.queryNumRide(26,100));
        numDist.add(userMapper.queryNumDist(0,1));
        numDist.add(userMapper.queryNumDist(1,2));
        numDist.add(userMapper.queryNumDist(2,3));
        numDist.add(userMapper.queryNumDist(3,4));
        numDist.add(userMapper.queryNumDist(4,5));
        numDist.add(userMapper.queryNumDist(5,100));
        numTime.add(userMapper.queryNumTime(0,5));
        numTime.add(userMapper.queryNumTime(5,10));
        numTime.add(userMapper.queryNumTime(10,15));
        numTime.add(userMapper.queryNumTime(15,20));
        numTime.add(userMapper.queryNumTime(20,30));
        numTime.add(userMapper.queryNumTime(30,40));
        numTime.add(userMapper.queryNumTime(40,100));
        model.addAttribute("numT",numTime);
        model.addAttribute("numD",numDist);
        model.addAttribute("numR",numRide);
        model.addAttribute("numA",numAge);
        model.addAttribute("numM",numMale);
        model.addAttribute("numF",numFemale);
        return "newold";

    }

    @RequestMapping("/personas.html")
    public String personas(){
        return "personas";
    }

}
