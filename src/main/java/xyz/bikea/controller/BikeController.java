package xyz.bikea.controller;


import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.bikea.mapper.BikeMapper;
import xyz.bikea.pojo.Bike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BikeController {
    @Autowired
    private BikeMapper bikeMapper;

    @RequestMapping({"/","/index.html"})
    public String query1(Model model){
        int numTotal = bikeMapper.queryTotal();
        int numNormalNow = bikeMapper.queryNormalNow();
        int numBrokenNow = bikeMapper.queryBrokenNow();
        int numMissNow = bikeMapper.queryMissNow();

        List<Integer> histNormal = bikeMapper.queryHistNormal();
        List<Integer> histBroken = bikeMapper.queryHistBroken();
        List<Integer> histMiss = bikeMapper.queryHistMiss();
        ArrayList numUse = new ArrayList();
        ArrayList numNoUse = new ArrayList();
        for(int i=0;i<=22;i=i+2){
            int n = bikeMapper.queryNumUse(i);
            int m = 4500-n;
            numUse.add(n);
            numNoUse.add(m);
        }
        model.addAttribute("numU",numUse);
        model.addAttribute("numNU",numNoUse);
        model.addAttribute("hisB",histBroken);
        model.addAttribute("hisM",histMiss);
        model.addAttribute("hisN",histNormal);
        model.addAttribute("total",numTotal);
        model.addAttribute("normal",numNormalNow);
        model.addAttribute("broken",numBrokenNow);
        model.addAttribute("miss",numMissNow);
        return "index";
    }

    @RequestMapping("/table.html")
    public String table(Model model){
        List<Bike> bikeList = bikeMapper.queryBikeList();
        model.addAttribute("bikeList",bikeList);
        return "table";
    }

    @CrossOrigin
    @RequestMapping(value = "/table/click", method=RequestMethod.POST)
    @ResponseBody
    public JSONObject tableClick(@RequestParam("info") String info) {

        System.out.println(info);
        int countNormal = bikeMapper.countNormalByCo(info);
        int countBroken = bikeMapper.countBrokenByCo(info);
        Map<String,Object> map = new HashMap<>();
        map.put("normal",countNormal);
        map.put("broken",countBroken);
        System.out.println("normal:"+map.get("normal").toString()+"\n"+"broken:"+map.get("broken").toString());
        JSONObject json=JSONObject.fromObject(map);
        System.out.println(json.toString());
        return json;

    }

//    @GetMapping("/queryBikeList")
//    public List<Bike> queryBikeList(){
//        List<Bike> bikeList = bikeMapper.queryBikeList();
//        return bikeList;
//    }
//
//    @GetMapping("/queryNormalLocation")
//    public List<Map<String,Object>> queryNormalBikeLocation(){
//        List<Map<String,Object>> normalBikeLocationList = bikeMapper.queryNormalBikeLocation();
//        return normalBikeLocationList;
//    }
//
//    @GetMapping("/queryBrokenLocation")
//    public List<Map<String,Object>> queryBrokenBikeLocation(){
//        List<Map<String,Object>> brokenBikeLocationList = bikeMapper.queryBrokenBikeLocation();
//        return brokenBikeLocationList;
//    }
//
//    @GetMapping("/queryNormalNow")
//    public int queryNormalNow(){
//        int countNormal = bikeMapper.queryNormalNow();
//        return countNormal;
//    }
//
//    @GetMapping("/queryBrokenNow")
//    public int queryBrokenNow(){
//        int countBroken = bikeMapper.queryBrokenNow();
//        return countBroken;
//    }
//
//    @GetMapping("/queryMissNow")
//    public int queryMissNow(){
//        int countMiss = bikeMapper.queryMissNow();
//        return countMiss;
//    }
//
//    @GetMapping("/queryTotal")
//    public int queryTotal(){
//        int countTotal = bikeMapper.queryTotal();
//        return countTotal;
//    }
//
//    @GetMapping("/queryUsing")
//    public int queryUsing(){
//        int countUsing = bikeMapper.queryUsing();
//        return countUsing;
//    }

}
