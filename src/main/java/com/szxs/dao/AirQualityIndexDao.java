package com.szxs.dao;

import com.szxs.entity.AirQualityIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirQualityIndexDao {

    /**
     * 查询所有空气质量指数
     * @return
     */
    List<AirQualityIndex> queryAirQualityIndexs(@Param("districtId") int districtId,@Param("pageOffset") int pageOffset, @Param("pageSize") int pageSize);

    /**
     * 增加空气质量指数
     * @return
     */
    int addAirQualityIndex(AirQualityIndex airQualityIndex);

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
    int updateAirQualityIndex(AirQualityIndex airQualityIndex);

    /**
     * 删除空气质量指数
     * @param id
     * @return
     */
    int deleteAirQualityIndex(int id);

    /**
     * 根据区域编号查询空气指数的行数
     * @param districtId
     * @return
     */
    int queryRows(@Param("districtId") int districtId);
}
