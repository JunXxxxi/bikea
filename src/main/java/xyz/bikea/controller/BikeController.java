package xyz.bikea.controller;


import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.bikea.mapper.BikeMapper;
import xyz.bikea.pojo.Bike;
import xyz.bikea.service.RedisService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BikeController {
    @Autowired
    private BikeMapper bikeMapper;

    @Resource
    private RedisService redisService;

    @RequestMapping({"/","/ index.html"})
    public String query1(Model model){
        Integer numTotal = (Integer) redisService.get("bikeTotal");
        if (numTotal == null){
            numTotal = bikeMapper.queryTotal();
            redisService.set("bikeTotal",numTotal,600);
        }
        Integer numNormalNow = (Integer) redisService.get("bikeNormalNow");
        if (numNormalNow == null){
            numNormalNow = bikeMapper.queryNormalNow();
            redisService.set("bikeNormalNow",numNormalNow,600);
        }
        Integer numBrokenNow = (Integer) redisService.get("bikeBrokenNow");
        if (numBrokenNow == null){
            numBrokenNow = bikeMapper.queryBrokenNow();
            redisService.set("bikeBrokenNow",numBrokenNow,600);
        }
        Integer numMissNow = (Integer) redisService.get("bikeMissNow");
        if (numMissNow == null){
            numMissNow = bikeMapper.queryMissNow();
            redisService.set("bikeMissNow",numMissNow,600);
        }

        List<Integer> histNormal = (List<Integer>) redisService.get("bikeHistNormal");
        if (histNormal == null){
            histNormal = bikeMapper.queryHistNormal();
            redisService.set("bikeHistNormal",histNormal,600);
        }
        List<Integer> histBroken = (List<Integer>) redisService.get("bikeHistBroken");
        if (histBroken == null){
            histBroken = bikeMapper.queryHistBroken();
            redisService.set("bikeHistBroken",histBroken,600);
        }
        List<Integer> histMiss = (List<Integer>) redisService.get("bikeMissBroken");
        if (histMiss == null){
            histMiss = bikeMapper.queryHistBroken();
            redisService.set("bikeMissBroken",histMiss,600);
        }

        ArrayList numUse = new ArrayList();
        ArrayList numNoUse = new ArrayList();
        for(int i=0;i<=22;i=i+2){
            Integer n = (Integer) redisService.get("numUse"+i);
            if (n == null){
                n = bikeMapper.queryNumUse(i);
                redisService.set("numUse"+i,n,600);
            }

            int m = 4500-n;
            numUse.add(n);
            numNoUse.add(m);
        }
        int perNormal = (int) (numNormalNow*100.0/numTotal);
        String perNormal_ = perNormal+"%";
        int perBroken = (int) (numBrokenNow*100.0/numTotal);
        String perBroken_ = perBroken+"%";
        int perMiss = (int) (numMissNow*100.0/numTotal);
        String perMiss_ = perMiss+"%";

        String t1 = numNormalNow + "("+perNormal_ +")";
        String t2 = numBrokenNow +"("+perBroken_+")";
        String t3 = numMissNow +"("+perMiss_+")";

        model.addAttribute("t1",t1);
        model.addAttribute("t2",t2);
        model.addAttribute("t3",t3);
        model.addAttribute("perN",perNormal_);
        model.addAttribute("perB",perBroken_);
        model.addAttribute("perM",perMiss_);
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

    @RequestMapping("/index2.html")
    public String query2(Model model){
        Integer numTotal = (Integer) redisService.get("bikeTotal2");
        if (numTotal == null){
            numTotal = bikeMapper.queryTotal2();
            redisService.set("bikeTotal2",numTotal,600);
        }
        Integer numNormalNow = (Integer) redisService.get("bikeNormalNow2");
        if (numNormalNow == null){
            numNormalNow = bikeMapper.queryNormalNow2();
            redisService.set("bikeNormalNow2",numNormalNow,600);
        }
        Integer numBrokenNow = (Integer) redisService.get("bikeBrokenNow2");
        if (numBrokenNow == null){
            numBrokenNow = bikeMapper.queryBrokenNow2();
            redisService.set("bikeBrokenNow2",numBrokenNow,600);
        }
        Integer numMissNow = (Integer) redisService.get("bikeMissNow2");
        if (numMissNow == null){
            numMissNow = bikeMapper.queryMissNow2();
            redisService.set("bikeMissNow2",numMissNow,600);
        }

        List<Integer> histNormal = (List<Integer>) redisService.get("bikeHistNormal2");
        if (histNormal == null){
            histNormal = bikeMapper.queryHistNormal2();
            redisService.set("bikeHistNormal2",histNormal,600);
        }
        List<Integer> histBroken = (List<Integer>) redisService.get("bikeHistBroken2");
        if (histBroken == null){
            histBroken = bikeMapper.queryHistBroken2();
            redisService.set("bikeHistBroken2",histBroken,600);
        }
        List<Integer> histMiss = (List<Integer>) redisService.get("bikeMissBroken2");
        if (histMiss == null){
            histMiss = bikeMapper.queryHistBroken2();
            redisService.set("bikeMissBroken2",histMiss,600);
        }
        ArrayList numUse = new ArrayList();
        ArrayList numNoUse = new ArrayList();
        for(int i=0;i<=22;i=i+2){
            Integer n = (Integer) redisService.get("numUse2"+i);
            if (n == null){
                n = bikeMapper.queryNumUse2(i);
                redisService.set("numUse2"+i,n,600);
            }
            int m = 6000-n;
            numUse.add(n);
            numNoUse.add(m);
        }
        int perNormal = (int) (numNormalNow*100.0/numTotal);
        String perNormal_ = perNormal+"%";
        int perBroken = (int) (numBrokenNow*100.0/numTotal);
        String perBroken_ = perBroken+"%";
        int perMiss = (int) (numMissNow*100.0/numTotal);
        String perMiss_ = perMiss+"%";

        String t1 = numNormalNow + "("+perNormal_ +")";
        String t2 = numBrokenNow +"("+perBroken_+")";
        String t3 = numMissNow +"("+perMiss_+")";

        model.addAttribute("t12",t1);
        model.addAttribute("t22",t2);
        model.addAttribute("t32",t3);
        model.addAttribute("perN2",perNormal_);
        model.addAttribute("perB2",perBroken_);
        model.addAttribute("perM2",perMiss_);
        model.addAttribute("numU2",numUse);
        model.addAttribute("numNU2",numNoUse);
        model.addAttribute("hisB2",histBroken);
        model.addAttribute("hisM2",histMiss);
        model.addAttribute("hisN2",histNormal);
        model.addAttribute("total2",numTotal);
        model.addAttribute("normal2",numNormalNow);
        model.addAttribute("broken2",numBrokenNow);
        model.addAttribute("miss2",numMissNow);
        return "index2";
    }

    @RequestMapping("/table.html")
    public String table(Model model){
        List<Bike> bikeList = bikeMapper.queryBikeList();
        model.addAttribute("bikeList",bikeList);
        return "table";
    }

    @RequestMapping("/table2.html")
    public String table2(Model model){
        List<Bike> bikeList = bikeMapper.queryBikeList2();
        model.addAttribute("bikeList2",bikeList);
        return "table2";
    }

    @RequestMapping("/analyseB1.html")
    public String analyseB1(Model model){
        return "analyseB1";
    }

    @RequestMapping("/analyseB2.html")
    public String analyseB2(Model model){
        return "analyseB2";
    }

    @RequestMapping("/emptyB1_1.html")
    public String emptyB1_1(Model model){
        return "emptyB1_1";
    }

    @RequestMapping("/emptyB1_2.html")
    public String emptyB1_2(Model model){
        return "emptyB1_2";
    }

    @RequestMapping("/emptyB1_3.html")
    public String emptyB1_3(Model model){
        return "emptyB1_3";
    }

    @RequestMapping("/emptyB1_4.html")
    public String emptyB1_4(Model model){
        return "emptyB1_4";
    }

    @RequestMapping("/emptyB1_5.html")
    public String emptyB1_5(Model model){
        return "emptyB1_5";
    }

    @RequestMapping("/emptyB1_6.html")
    public String emptyB1_6(Model model){
        return "emptyB1_6";
    }

    @RequestMapping("/emptyB2_1.html")
    public String emptyB2_1(Model model){
        return "emptyB2_1";
    }

    @RequestMapping("/emptyB2_2.html")
    public String emptyB2_2(Model model){
        return "emptyB2_2";
    }

    @RequestMapping("/emptyB2_3.html")
    public String emptyB2_3(Model model){
        return "emptyB2_3";
    }

    @RequestMapping("/emptyB2_4.html")
    public String emptyB2_4(Model model){
        return "emptyB2_4";
    }

    @RequestMapping("/emptyB2_5.html")
    public String emptyB2_5(Model model){
        return "emptyB2_5";
    }

    @RequestMapping("/emptyB2_6.html")
    public String emptyB2_6(Model model){
        return "emptyB2_6";
    }

    @RequestMapping("/bike_detail.html")
    public String bike_detail(Model model){
        List<Bike> bikeList = bikeMapper.queryBikeList();
        model.addAttribute("bikeList",bikeList);
        return "bike_detail";
    }

    @RequestMapping("/bike_detail2.html")
    public String bike_detail2(Model model){
        List<Bike> bikeList = bikeMapper.queryBikeList2();
        model.addAttribute("bikeList",bikeList);
        return "bike_detail2";
    }

    @CrossOrigin
    @RequestMapping(value = "/bike_detail/click", method=RequestMethod.POST)
    @ResponseBody
    public JSONObject click(@RequestParam("info") int info){
        Map<String,Object> map = new HashMap<>();
        //通过ID查询单车是否被使用
        int isUsing = bikeMapper.queryUseByID(info);
        String isUsing_ = null;
        if(isUsing==0){
            isUsing_ = "Unused";
        }
        else if(isUsing==1){
            isUsing_ = "Using";
        }
        map.put("isUsing",isUsing_);

        //通过ID查询单车所在位置信息
        String location = bikeMapper.queryLocByID(info);
        String coordinate = bikeMapper.queryCoByID(info);
        map.put("location",location);
        map.put("coordinate",coordinate);

        //通过ID查询单车磨损程度
        int attritionRate = bikeMapper.queryAttByID(info);
        attritionRate = attritionRate*100/5;
        String attritionRate_ = attritionRate+ "%";
        map.put("attritionRate",attritionRate_);

        //通过ID查询单车累计使用情况
        int numUse = bikeMapper.queryNumUseByID(info);
        float runDist = bikeMapper.queryRunDisByID(info);
        float income = bikeMapper.queryIncomeByID(info);
        map.put("numUse",numUse);
        map.put("runDist",runDist);
        map.put("income",income);

        JSONObject json=JSONObject.fromObject(map);
//        System.out.println(json.toString());
        return json;
    }

    @CrossOrigin
    @RequestMapping(value = "/bike_detail/click2", method=RequestMethod.POST)
    @ResponseBody
    public JSONObject click2(@RequestParam("info") int info){
//        System.out.println(info);
        Map<String,Object> map = new HashMap<>();
        //通过ID查询单车是否被使用
        int isUsing = bikeMapper.queryUseByID2(info);
        String isUsing_ = null;
        if(isUsing==0){
            isUsing_ = "Unused";
        }
        else if(isUsing==1){
            isUsing_ = "Using";
        }
        map.put("isUsing",isUsing_);

        //通过ID查询单车所在位置信息
        String location = bikeMapper.queryLocByID2(info);
        String coordinate = bikeMapper.queryCoByID2(info);
        map.put("location",location);
        map.put("coordinate",coordinate);

        //通过ID查询单车磨损程度
        int attritionRate = bikeMapper.queryAttByID2(info);
        attritionRate = attritionRate*100/5;
        String attritionRate_ = attritionRate+ "%";
        map.put("attritionRate",attritionRate_);

        //通过ID查询单车累计使用情况
        int numUse = bikeMapper.queryNumUseByID2(info);
        float runDist = bikeMapper.queryRunDisByID2(info);
        float income = bikeMapper.queryIncomeByID2(info);
        map.put("numUse",numUse);
        map.put("runDist",runDist);
        map.put("income",income);

        JSONObject json=JSONObject.fromObject(map);
//        System.out.println(json.toString());
        return json;
    }

    @RequestMapping("/bike_dist.html")
    public String bike_dist(Model model){
        return "bike_dist";
    }

    @RequestMapping("/bike_dist2.html")
    public String bike_dist2(Model model){
        return "bike_dist2";
    }


//    @CrossOrigin
//    @RequestMapping(value = "/table/click", method=RequestMethod.POST)
//    @ResponseBody
//    public JSONObject tableClick(@RequestParam("info") String info) {
//
//        System.out.println(info);
//        int countNormal = bikeMapper.countNormalByCo(info);
//        int countBroken = bikeMapper.countBrokenByCo(info);
//        Map<String,Object> map = new HashMap<>();
//        map.put("normal",countNormal);
//        map.put("broken",countBroken);
//        System.out.println("normal:"+map.get("normal").toString()+"\n"+"broken:"+map.get("broken").toString());
//        JSONObject json=JSONObject.fromObject(map);
//        System.out.println(json.toString());
//        return json;
//
//    }

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
