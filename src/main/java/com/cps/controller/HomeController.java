package com.cps.controller;

import com.cps.dao.IpDAO;
import com.cps.model.Ip_coor_res;
import com.cps.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yale on 16/10/6.
 */

@Controller
public class HomeController {

    @Autowired
    IpDAO ipDAO;

    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("position", "ChangSha");
        return "index";
    }

    @RequestMapping("/index_test")
    public String index_test(Model model){
        model.addAttribute("position", "ChangSha");
        return "index_test";
    }

    @RequestMapping("/time")
    public String time(Model model){
        model.addAttribute("position", "ChangSha");
        return "time";
    }

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("position", "ChangSha");
        return "test";
    }

    @RequestMapping("/ajaxTest")
    @ResponseBody
    public String ajaxTest(){

        Map resMap = new HashMap<>();


        List<Ip_coor_res> res = ipDAO.selectAllWithCoordinateAndCount(1);
        for(Ip_coor_res list : res){
            Map aListMap = new HashMap<>();
            aListMap.put(list.getCoordinate(), Integer.valueOf(list.getCount()) + 20);
            resMap.put(list.getCoordinate(), aListMap);
        }
//        JSONArray array = JSONArray.fromObject(resMap);
//        JSONObject jo = new JSONObject(resMap);
        JsonUtil ju = new JsonUtil();
        System.out.println(resMap.toString());
        return ju.map2json(resMap);
    }
}
