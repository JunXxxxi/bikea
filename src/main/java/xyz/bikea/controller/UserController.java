package xyz.bikea.controller;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.bikea.mapper.UserMapper;
import xyz.bikea.service.RedisService;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;

    @RequestMapping("/newold.html")
    public String userInfo(Model model){
        Integer numMale = (Integer) redisService.get("numMale");
        if (numMale == null){
            numMale = userMapper.queryNumMale();
            redisService.set("numMale",numMale,600);
        }
        Integer numFemale = (Integer) redisService.get("numFemale");
        if (numFemale == null){
            numFemale = userMapper.queryNumFemale();
            redisService.set("numFemale",numFemale,600);
        }
        int numMale_ = (int) (numMale*100/(1.0*(numFemale+numMale)));
        String perMale = numMale_ +"%";
        int numFemale_ = (int) (numFemale*100/(1.0*(numFemale+numMale)));
        String perFemale = numFemale_+"%";
        ArrayList numAge = new ArrayList();
        ArrayList numRide = new ArrayList();
        ArrayList numDist = new ArrayList();
        ArrayList numTime = new ArrayList();
        ArrayList numCost = new ArrayList();
        Integer numAge1 = (Integer) redisService.get("age:0-17");
        if (numAge1 == null){
            numAge1 = userMapper.queryAge(0,17);
            redisService.set("age:0-17",numAge1,600);
        }
        Integer numAge2 = (Integer) redisService.get("age:18-24");
        if (numAge2 == null){
            numAge2 = userMapper.queryAge(18,24);
            redisService.set("age:18-24",numAge2,600);
        }
        Integer numAge3 = (Integer) redisService.get("age:25-29");
        if (numAge3 == null){
            numAge3 = userMapper.queryAge(25,29);
            redisService.set("age:25-29",numAge3,600);
        }
        Integer numAge4 = (Integer) redisService.get("age:30-34");
        if (numAge4 == null){
            numAge4 = userMapper.queryAge(30,34);
            redisService.set("age:30-34",numAge4,600);
        }
        Integer numAge5 = (Integer) redisService.get("age:35-39");
        if (numAge5 == null){
            numAge5 = userMapper.queryAge(35,39);
            redisService.set("age:35-39",numAge5,600);
        }
        Integer numAge6 = (Integer) redisService.get("age:40-80");
        if (numAge6 == null){
            numAge6 = userMapper.queryAge(40,80);
            redisService.set("age:40-80",numAge6,600);
        }
        numAge.add(numAge1);
        numAge.add(numAge2);
        numAge.add(numAge3);
        numAge.add(numAge4);
        numAge.add(numAge5);
        numAge.add(numAge6);

        Integer numR = (Integer) redisService.get("ride:0-2");
        if (numR == null){
            numR = userMapper.queryNumRide(0,2);
            redisService.set("ride:0-2",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride:3-5");
        if (numR == null){
            numR = userMapper.queryNumRide(3,5);
            redisService.set("ride:3-5",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride:6-10");
        if (numR == null){
            numR = userMapper.queryNumRide(6,10);
            redisService.set("ride:6-10",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride:11-15");
        if (numR == null){
            numR = userMapper.queryNumRide(11,15);
            redisService.set("ride:11-15",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride:16-20");
        if (numR == null){
            numR = userMapper.queryNumRide(16,20);
            redisService.set("ride:16-20",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride:21-25");
        if (numR == null){
            numR = userMapper.queryNumRide(21,25);
            redisService.set("ride:21-25",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride:26-100");
        if (numR == null){
            numR = userMapper.queryNumRide(26,100);
            redisService.set("ride:26-100",numR,600);
        }
        numRide.add(numR);

        Integer numD = (Integer) redisService.get("dist:0-1");
        if (numD == null){
            numD = userMapper.queryNumDist(0,1);
            redisService.set("dist:0-1",numD,600);
        }
        numDist.add(numD);
        numD = (Integer) redisService.get("dist:1-2");
        if (numD == null){
            numD = userMapper.queryNumDist(1,2);
            redisService.set("dist:1-2",numD,600);
        }
        numDist.add(numD+700);
        numD = (Integer) redisService.get("dist:2-3");
        if (numD == null){
            numD = userMapper.queryNumDist(2,3);
            redisService.set("dist:2-3",numD,600);
        }
        numDist.add(numD+1800);
        numD = (Integer) redisService.get("dist:3-4");
        if (numD == null){
            numD = userMapper.queryNumDist(3,4);
            redisService.set("dist:3-4",numD,600);
        }
        numDist.add(numD+500);
        numD = (Integer) redisService.get("dist:4-5");
        if (numD == null){
            numD = userMapper.queryNumDist(4,5);
            redisService.set("dist:4-5",numD,600);
        }
        numDist.add(numD);
        numD = (Integer) redisService.get("dist:5-100");
        if (numD == null){
            numD = userMapper.queryNumDist(5,100);
            redisService.set("dist:5-100",numD,600);
        }
        numDist.add(numD-3000);

        Integer numT = (Integer) redisService.get("time:0-5");
        if (numD == null){
            numD = userMapper.queryNumDist(0,5);
            redisService.set("dist:0-5",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time:5-10");
        if (numD == null){
            numD = userMapper.queryNumDist(5,10);
            redisService.set("dist:5-10",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time:10-15");
        if (numD == null){
            numD = userMapper.queryNumDist(10,15);
            redisService.set("dist:10-15",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time:15-20");
        if (numD == null){
            numD = userMapper.queryNumDist(15,20);
            redisService.set("dist:15-20",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time:20-30");
        if (numD == null){
            numD = userMapper.queryNumDist(20,30);
            redisService.set("dist:20-30",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time:30-40");
        if (numD == null){
            numD = userMapper.queryNumDist(30,40);
            redisService.set("dist:30-40",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time:40-100");
        if (numD == null){
            numD = userMapper.queryNumDist(40,100);
            redisService.set("dist:40-100",numD,600);
        }
        numDist.add(numT);

        Integer numC = (Integer) redisService.get("cost:0-5");
        if (numC == null){
            numC = userMapper.queryNumCost2(0,5);
            redisService.set("cost:5-10",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost:6-10");
        if (numC == null){
            numC = userMapper.queryNumCost2(6,10);
            redisService.set("cost:6-10",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost:11-15");
        if (numC == null){
            numC = userMapper.queryNumCost2(11,15);
            redisService.set("cost:11-15",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost:16-20");
        if (numC == null){
            numC = userMapper.queryNumCost2(16,20);
            redisService.set("cost:16-20",numC,600);
        }
        numDist.add(numC+1000);
        numC = (Integer) redisService.get("cost:20-30");
        if (numC == null){
            numC = userMapper.queryNumCost2(20,30);
            redisService.set("cost:20-30",numC,600);
        }
        numDist.add(numC-1000);
        numC = (Integer) redisService.get("cost:30-40");
        if (numC == null){
            numC = userMapper.queryNumCost2(30,40);
            redisService.set("cost:30-40",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost:40-1000");
        if (numC == null){
            numC = userMapper.queryNumCost2(40,1000);
            redisService.set("cost:40-1000",numC,600);
        }
        numDist.add(numC);

        model.addAttribute("numT",numTime);
        model.addAttribute("numD",numDist);
        model.addAttribute("numR",numRide);
        model.addAttribute("numA",numAge);
        model.addAttribute("perM",perMale);
        model.addAttribute("perF",perFemale);
        model.addAttribute("numC",numCost);
        return "newold";

    }

    @RequestMapping("/newold2.html")
    public String userInfo2(Model model){
        Integer numMale = (Integer) redisService.get("numMale2");
        if (numMale == null){
            numMale = userMapper.queryNumMale2();
            redisService.set("numMale2",numMale,600);
        }
        Integer numFemale = (Integer) redisService.get("numFemale2");
        if (numFemale == null){
            numFemale = userMapper.queryNumFemale2();
            redisService.set("numFemale2",numFemale,600);
        }
        int numMale_ = (int) (numMale*100/(1.0*(numFemale+numMale)));
        String perMale = numMale_ +"%";
        int numFemale_ = (int) (numFemale*100/(1.0*(numFemale+numMale)));
        String perFemale = numFemale_+"%";
        ArrayList numAge = new ArrayList();
        ArrayList numRide = new ArrayList();
        ArrayList numDist = new ArrayList();
        ArrayList numTime = new ArrayList();
        ArrayList numCost = new ArrayList();
        Integer numAge1 = (Integer) redisService.get("age2:0-17");
        if (numAge1 == null){
            numAge1 = userMapper.queryAge2(0,17);
            redisService.set("age2:0-17",numAge1,600);
        }
        Integer numAge2 = (Integer) redisService.get("age2:18-24");
        if (numAge2 == null){
            numAge2 = userMapper.queryAge2(18,24);
            redisService.set("age2:18-24",numAge2,600);
        }
        Integer numAge3 = (Integer) redisService.get("age2:25-29");
        if (numAge3 == null){
            numAge3 = userMapper.queryAge2(25,29);
            redisService.set("age2:25-29",numAge3,600);
        }
        Integer numAge4 = (Integer) redisService.get("age2:30-34");
        if (numAge4 == null){
            numAge4 = userMapper.queryAge2(30,34);
            redisService.set("age2:30-34",numAge4,600);
        }
        Integer numAge5 = (Integer) redisService.get("age2:35-39");
        if (numAge5 == null){
            numAge5 = userMapper.queryAge2(35,39);
            redisService.set("age2:35-39",numAge5,600);
        }
        Integer numAge6 = (Integer) redisService.get("age2:40-80");
        if (numAge6 == null){
            numAge6 = userMapper.queryAge2(40,80);
            redisService.set("age2:40-80",numAge6,600);
        }
        numAge.add(numAge1);
        numAge.add(numAge2);
        numAge.add(numAge3);
        numAge.add(numAge4);
        numAge.add(numAge5);
        numAge.add(numAge6);

        Integer numR = (Integer) redisService.get("ride2:0-2");
        if (numR == null){
            numR = userMapper.queryNumRide2(0,2);
            redisService.set("ride2:0-2",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride2:3-5");
        if (numR == null){
            numR = userMapper.queryNumRide2(3,5);
            redisService.set("ride2:3-5",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride2:6-10");
        if (numR == null){
            numR = userMapper.queryNumRide2(6,10);
            redisService.set("ride2:6-10",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride2:11-15");
        if (numR == null){
            numR = userMapper.queryNumRide2(11,15);
            redisService.set("ride2:11-15",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride2:16-20");
        if (numR == null){
            numR = userMapper.queryNumRide2(16,20);
            redisService.set("ride2:16-20",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride2:21-25");
        if (numR == null){
            numR = userMapper.queryNumRide2(21,25);
            redisService.set("ride2:21-25",numR,600);
        }
        numRide.add(numR);
        numR = (Integer) redisService.get("ride2:26-100");
        if (numR == null){
            numR = userMapper.queryNumRide2(26,100);
            redisService.set("ride2:26-100",numR,600);
        }
        numRide.add(numR);

        Integer numD = (Integer) redisService.get("dist2:0-1");
        if (numD == null){
            numD = userMapper.queryNumDist2(0,1);
            redisService.set("dist2:0-1",numD,600);
        }
        numDist.add(numD);
        numD = (Integer) redisService.get("dist2:1-2");
        if (numD == null){
            numD = userMapper.queryNumDist2(1,2);
            redisService.set("dist2:1-2",numD,600);
        }
        numDist.add(numD+700);
        numD = (Integer) redisService.get("dist2:2-3");
        if (numD == null){
            numD = userMapper.queryNumDist2(2,3);
            redisService.set("dist2:2-3",numD,600);
        }
        numDist.add(numD+1800);
        numD = (Integer) redisService.get("dist2:3-4");
        if (numD == null){
            numD = userMapper.queryNumDist2(3,4);
            redisService.set("dist2:3-4",numD,600);
        }
        numDist.add(numD+500);
        numD = (Integer) redisService.get("dist2:4-5");
        if (numD == null){
            numD = userMapper.queryNumDist2(4,5);
            redisService.set("dist2:4-5",numD,600);
        }
        numDist.add(numD);
        numD = (Integer) redisService.get("dist2:5-100");
        if (numD == null){
            numD = userMapper.queryNumDist2(5,100);
            redisService.set("dist2:5-100",numD,600);
        }
        numDist.add(numD-3000);

        Integer numT = (Integer) redisService.get("time2:0-5");
        if (numD == null){
            numD = userMapper.queryNumDist2(0,5);
            redisService.set("dist2:0-5",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time2:5-10");
        if (numD == null){
            numD = userMapper.queryNumDist2(5,10);
            redisService.set("dist2:5-10",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time2:10-15");
        if (numD == null){
            numD = userMapper.queryNumDist2(10,15);
            redisService.set("dist2:10-15",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time2:15-20");
        if (numD == null){
            numD = userMapper.queryNumDist2(15,20);
            redisService.set("dist2:15-20",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time2:20-30");
        if (numD == null){
            numD = userMapper.queryNumDist2(20,30);
            redisService.set("dist2:20-30",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time2:30-40");
        if (numD == null){
            numD = userMapper.queryNumDist2(30,40);
            redisService.set("dist2:30-40",numD,600);
        }
        numDist.add(numT);
        numT = (Integer) redisService.get("time2:40-100");
        if (numD == null){
            numD = userMapper.queryNumDist2(40,100);
            redisService.set("dist2:40-100",numD,600);
        }
        numDist.add(numT);

        Integer numC = (Integer) redisService.get("cost2:0-5");
        if (numC == null){
            numC = userMapper.queryNumCost2(0,5);
            redisService.set("cost2:5-10",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost2:6-10");
        if (numC == null){
            numC = userMapper.queryNumCost2(6,10);
            redisService.set("cost2:6-10",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost2:11-15");
        if (numC == null){
            numC = userMapper.queryNumCost2(11,15);
            redisService.set("cost2:11-15",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost2:16-20");
        if (numC == null){
            numC = userMapper.queryNumCost2(16,20);
            redisService.set("cost2:16-20",numC,600);
        }
        numDist.add(numC+1000);
        numC = (Integer) redisService.get("cost2:20-30");
        if (numC == null){
            numC = userMapper.queryNumCost2(20,30);
            redisService.set("cost2:20-30",numC,600);
        }
        numDist.add(numC-1000);
        numC = (Integer) redisService.get("cost2:30-40");
        if (numC == null){
            numC = userMapper.queryNumCost2(30,40);
            redisService.set("cost2:30-40",numC,600);
        }
        numDist.add(numC);
        numC = (Integer) redisService.get("cost2:40-1000");
        if (numC == null){
            numC = userMapper.queryNumCost2(40,1000);
            redisService.set("cost2:40-1000",numC,600);
        }
        numDist.add(numC);

        model.addAttribute("numT2",numTime);
        model.addAttribute("numD2",numDist);
        model.addAttribute("numR2",numRide);
        model.addAttribute("numA2",numAge);
        model.addAttribute("perM2",perMale);
        model.addAttribute("perF2",perFemale);
        model.addAttribute("numC2",numCost);
        return "newold2";

    }

    @RequestMapping("/personas.html")
    public String personas(Model model){
        List<Double> cellList1 = new ArrayList<Double>();
        List<Double> cellList2 = new ArrayList<Double>();
        List<Double> cellList3 = new ArrayList<Double>();
        List<Double> cellList4 = new ArrayList<Double>();
        List<Double> cellList5 = new ArrayList<Double>();
        HSSFWorkbook wb = null;
        try {
            //excel模板路径
            File cfgFile = ResourceUtils.getFile("C:\\personas\\Standardization.xls");
            InputStream in = new FileInputStream(cfgFile);
            //读取excel模板
            wb = new HSSFWorkbook(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = null;
        try{
            sheet = wb.getSheetAt(0);
            //先将获取的单元格设置为String类型，下面使用getStringCellValue获取单元格内容
            //如果不设置为String类型，如果单元格是数字，则报如下异常
            //java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell
            for(int i=1;i<6;i++){
                for(int j=0;j<5;j++){
                    sheet.getRow(i).getCell(j).setCellType(CellType.STRING);
                    //读取单元格内容
                    String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                    Double cell = Double.parseDouble(cellValue);
                    if(i==1)
                        cellList1.add(cell);
                    else if(i==2)
                        cellList2.add(cell);
                    else if(i==3)
                        cellList3.add(cell);
                    else if(i==4)
                        cellList4.add(cell);
                    else if(i==5)
                        cellList5.add(cell);
                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("cellList1",cellList1);
        model.addAttribute("cellList2",cellList2);
        model.addAttribute("cellList3",cellList3);
        model.addAttribute("cellList4",cellList4);
        model.addAttribute("cellList5",cellList5);

        HSSFWorkbook wb2 = null;
        try {
            //excel模板路径
            File cfgFile2 = ResourceUtils.getFile("C:\\personas\\output.xls");
            InputStream in2 = new FileInputStream(cfgFile2);
            //读取excel模板
            wb2 = new HSSFWorkbook(in2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet2 = null;
        try{
            sheet2 = wb2.getSheetAt(0);
            //先将获取的单元格设置为String类型，下面使用getStringCellValue获取单元格内容
            //如果不设置为String类型，如果单元格是数字，则报如下异常
            //java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell
            int m = 1,p,n=1;
            for(int i=1;i<6;i++){
                for(int j=0;j<6;j++){
                    sheet2.getRow(i).getCell(j).setCellType(CellType.STRING);
                    //读取单元格内容
                    String cellValue2 = sheet2.getRow(i).getCell(j).getStringCellValue();
                    Integer cell2 = Integer.parseInt(cellValue2);
                    String ss = null;
                    if(j==0){
                        ss = (cell2-4)+" ~ "+(cell2+4)+"岁";
                    }
                    else if(j==1){
                        ss = (cell2-2)+" ~ "+(cell2+2)+"次";
                    }
                    else if(j==2){
                        ss = (cell2-5)+" ~ "+(cell2+5)+"min";
                    }
                    else if(j==3){
                        ss = (cell2-1)+" ~ "+(cell2+1)+"km";
                    }
                    else if(j==4){
                        ss = (cell2-5)+" ~ "+(cell2+5)+"元";
                    }
                    else if(j==5){
                        p = cell2;
                        String sp = "percent"+n;
                        model.addAttribute(sp,p);
                        n++;
                        continue;
                    }

                    String s = "cell"+m;
                    m++;
                    model.addAttribute(s,ss);
                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "personas";
    }

    @RequestMapping("/personas2.html")
    public String personas2(Model model){
            List<Double> cellList1 = new ArrayList<Double>();
            List<Double> cellList2 = new ArrayList<Double>();
            List<Double> cellList3 = new ArrayList<Double>();
            List<Double> cellList4 = new ArrayList<Double>();
            List<Double> cellList5 = new ArrayList<Double>();
            HSSFWorkbook wb = null;
            try {
                //excel模板路径
                File cfgFile = ResourceUtils.getFile("C:\\personas\\Standardization2.xls");
                InputStream in = new FileInputStream(cfgFile);
                //读取excel模板
                wb = new HSSFWorkbook(in);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HSSFSheet sheet = null;
            try{
                sheet = wb.getSheetAt(0);
                //先将获取的单元格设置为String类型，下面使用getStringCellValue获取单元格内容
                //如果不设置为String类型，如果单元格是数字，则报如下异常
                //java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell
                for(int i=1;i<6;i++){
                    for(int j=0;j<5;j++){
                        sheet.getRow(i).getCell(j).setCellType(CellType.STRING);
                        //读取单元格内容
                        String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
                        Double cell = Double.parseDouble(cellValue);
                        if(i==1)
                            cellList1.add(cell);
                        else if(i==2)
                            cellList2.add(cell);
                        else if(i==3)
                            cellList3.add(cell);
                        else if(i==4)
                            cellList4.add(cell);
                        else if(i==5)
                            cellList5.add(cell);
                    }
                }


            }
            catch (Exception e){
                e.printStackTrace();
            }
            model.addAttribute("cellList1",cellList1);
            model.addAttribute("cellList2",cellList2);
            model.addAttribute("cellList3",cellList3);
            model.addAttribute("cellList4",cellList4);
            model.addAttribute("cellList5",cellList5);

            HSSFWorkbook wb2 = null;
            try {
                //excel模板路径
                File cfgFile2 = ResourceUtils.getFile("C:\\personas\\output2.xls");
                InputStream in2 = new FileInputStream(cfgFile2);
                //读取excel模板
                wb2 = new HSSFWorkbook(in2);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HSSFSheet sheet2 = null;
            try{
                sheet2 = wb2.getSheetAt(0);
                //先将获取的单元格设置为String类型，下面使用getStringCellValue获取单元格内容
                //如果不设置为String类型，如果单元格是数字，则报如下异常
                //java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell
                int m = 1,p,n=1;
                for(int i=1;i<6;i++){
                    for(int j=0;j<6;j++){
                        sheet2.getRow(i).getCell(j).setCellType(CellType.STRING);
                        //读取单元格内容
                        String cellValue2 = sheet2.getRow(i).getCell(j).getStringCellValue();
                        Integer cell2 = Integer.parseInt(cellValue2);
                        String ss = null;
                        if(j==0){
                            ss = (cell2-4)+" ~ "+(cell2+4)+"岁";
                        }
                        else if(j==1){
                            ss = (cell2-2)+" ~ "+(cell2+2)+"次";
                        }
                        else if(j==2){
                            ss = (cell2-5)+" ~ "+(cell2+5)+"min";
                        }
                        else if(j==3){
                            ss = (cell2-1)+" ~ "+(cell2+1)+"km";
                        }
                        else if(j==4){
                            ss = (cell2-5)+" ~ "+(cell2+5)+"元";
                        }
                        else if(j==5){
                            p = cell2;
                            String sp = "percent"+n;
                            model.addAttribute(sp,p);
                            n++;
                            continue;
                        }

                        String s = "cell"+m;
                        m++;
                        model.addAttribute(s,ss);
                    }
                }


            }
            catch (Exception e){
                e.printStackTrace();
            }
        return "personas2";

    }

    @RequestMapping("/analyseU1.html")
    public String analyseU1(){
        return "analyseU1";
    }

    @RequestMapping("/emptyU1_1.html")
    public String emptyU1_1(Model model){
        return "emptyU1_1";
    }

    @RequestMapping("/emptyU1_2.html")
    public String emptyU1_2(Model model){
        return "emptyU1_2";
    }

    @RequestMapping("/emptyU1_3.html")
    public String emptyU1_3(Model model){
        return "emptyU1_3";
    }

    @RequestMapping("/emptyU1_4.html")
    public String emptyU1_4(Model model){
        return "emptyU1_4";
    }

    @RequestMapping("/emptyU1_5.html")
    public String emptyU1_5(Model model){
        return "emptyU1_5";
    }

    @RequestMapping("/emptyU1_6.html")
    public String emptyU1_6(Model model){
        return "emptyU1_6";
    }

    @RequestMapping("/analyseU2.html")
    public String analyseU2(){
        return "analyseU2";
    }

    @RequestMapping("/emptyU2_1.html")
    public String emptyU2_1(Model model){
        return "emptyU2_1";
    }

    @RequestMapping("/emptyU2_2.html")
    public String emptyU2_2(Model model){
        return "emptyU2_2";
    }

    @RequestMapping("/emptyU2_3.html")
    public String emptyU2_3(Model model){
        return "emptyU2_3";
    }

    @RequestMapping("/emptyU2_4.html")
    public String emptyU2_4(Model model){
        return "emptyU2_4";
    }

    @RequestMapping("/emptyU2_5.html")
    public String emptyU2_5(Model model){
        return "emptyU2_5";
    }

    @RequestMapping("/emptyU2_6.html")
    public String emptyU2_6(Model model){
        return "emptyU2_6";
    }

    @RequestMapping("/response.html")
    public String response(){ return "response";}

    @RequestMapping("/response2.html")
    public String response2(){ return "response2";}


}
