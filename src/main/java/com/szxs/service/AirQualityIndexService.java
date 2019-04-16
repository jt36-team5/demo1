package com.szxs.service;

import com.szxs.entity.AirQualityIndex;
import com.szxs.entity.District;
import com.szxs.entity.Pager;

import java.util.List;

public interface AirQualityIndexService {

    /**
     * 查询所有空气质量指数
     * @return
     */
    Pager<AirQualityIndex> queryAirQualityIndexs(int districtId, int pageNo, int pageSize);

    /**
     * 查询全部的区域
     * @return
     */
    List<District> queryDistricts();

    /**
     * 增加空气质量指数
     * @return
     */
    boolean addAirQualityIndex(AirQualityIndex airQualityIndex);

    /**
     * 根据区域编号查询空气质量指数
     * @return
     */
    AirQualityIndex queryAirQualityIndexById(int id);

    /**
     * 修改空气质量指数
     * @param airQualityIndex
     * @return
     */
    boolean updateAirQualityIndex(AirQualityIndex airQualityIndex);

    /**
     * 删除空气质量指数
     * @param id
     * @return
     */
    boolean deleteAirQualityIndex(int id);
}
