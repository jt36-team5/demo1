package com.szxs.dao;

import com.szxs.entity.District;

import java.util.List;

public interface DistrictDao {

    /**
     * 查询全部的区域
     * @return
     */
    List<District> queryDistricts();
}
