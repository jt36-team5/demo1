package com.szxs.controller;

import com.szxs.entity.AirQualityIndex;
import com.szxs.entity.District;
import com.szxs.entity.Pager;
import com.szxs.service.AirQualityIndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AirQualityIndexController {

    @Resource
    private AirQualityIndexService airQualityIndexService;

    @RequestMapping("/showAirQualityIndexs")
    public String showAirQualityIndexs(Model model,String queryDistrictName,String pageIndex){
        if (null == queryDistrictName || "".equals(queryDistrictName)){
            queryDistrictName = "0";
        }
        if (null == pageIndex || "".equals(pageIndex)){
            pageIndex = "1";
        }
        Pager<AirQualityIndex> pager = airQualityIndexService.queryAirQualityIndexs(Integer.parseInt(queryDistrictName),Integer.parseInt(pageIndex), 5);
        //获取全部区域信息
        List<District> districtList = airQualityIndexService.queryDistricts();
        model.addAttribute("pager",pager);
        model.addAttribute("districtList",districtList);
        model.addAttribute("queryDistrictName",queryDistrictName);
        return "airQualityIndexlist";
    }

    @RequestMapping("/toadd")
    public String toAdd(Model model){
        //获取全部区域信息
        List<District> districtList = airQualityIndexService.queryDistricts();
        model.addAttribute("districtList",districtList);
        return "AirQualityIndexAdd";
    }

    @RequestMapping("/addAirQualityIndex")
    public String addAirQualityIndex(AirQualityIndex airQualityIndex){
        if(airQualityIndexService.addAirQualityIndex(airQualityIndex)){
            return "redirect:showAirQualityIndexs";
        }
        return null;
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdate(Model model, @PathVariable("id")int id){
        AirQualityIndex airQualityIndex = airQualityIndexService.queryAirQualityIndexById(id);
        model.addAttribute("airQualityIndex",airQualityIndex);
        //获取全部区域信息
        List<District> districtList = airQualityIndexService.queryDistricts();
        model.addAttribute("districtList",districtList);
        return "airQualityIndexModify";
    }

    @RequestMapping("/modifyAirQualityIndex")
    public String airQualityIndexModify(AirQualityIndex airQualityIndex){
        if(airQualityIndexService.updateAirQualityIndex(airQualityIndex)){
            return "redirect:showAirQualityIndexs";
        }
        return null;
    }

    @RequestMapping("/deleteAirQualityIndexs")
    public String deleteAirQualityIndexs(String id){
        if(airQualityIndexService.deleteAirQualityIndex(Integer.parseInt(id))){
            return "redirect:showAirQualityIndexs";
        }
        return null;
    }
}
