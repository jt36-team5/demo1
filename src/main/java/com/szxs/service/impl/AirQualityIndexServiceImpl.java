package com.szxs.service.impl;

import com.szxs.dao.AirQualityIndexDao;
import com.szxs.dao.DistrictDao;
import com.szxs.entity.AirQualityIndex;
import com.szxs.entity.District;
import com.szxs.entity.Pager;
import com.szxs.service.AirQualityIndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AirQualityIndexServiceImpl implements AirQualityIndexService {

    @Resource
    private AirQualityIndexDao airQualityIndexDao;
    @Resource
    private DistrictDao districtDao;

    public Pager<AirQualityIndex> queryAirQualityIndexs(int districtId, int pageNo, int pageSize) {
        Pager pager = new Pager();
        int pageRows = airQualityIndexDao.queryRows(districtId);
        pager.setPageNo(pageNo); //设置当前页
        pager.setPageSize(pageSize); //设置每页行数
        pager.setTotalPage((pageRows+pageSize-1)/pageSize); //设置总页数
        pager.setTotalRows(pageRows); //设置总行数
        pager.setDatas(airQualityIndexDao.queryAirQualityIndexs(districtId,(pageNo-1)*pageSize,pageSize));
        return pager;
    }

    public List<District> queryDistricts() {
        return districtDao.queryDistricts();
    }

    public boolean addAirQualityIndex(AirQualityIndex airQualityIndex) {
        return airQualityIndexDao.addAirQualityIndex(airQualityIndex) > 0;
    }

    public AirQualityIndex queryAirQualityIndexById(int id) {
        return airQualityIndexDao.queryAirQualityIndexById(id);
    }

    public boolean updateAirQualityIndex(AirQualityIndex airQualityIndex) {
        return airQualityIndexDao.updateAirQualityIndex(airQualityIndex) > 0;
    }

    public boolean deleteAirQualityIndex(int id) {
        return airQualityIndexDao.deleteAirQualityIndex(id) > 0;
    }
}
