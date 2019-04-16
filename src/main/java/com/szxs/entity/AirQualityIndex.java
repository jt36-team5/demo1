package com.szxs.entity;

import java.util.Date;

public class AirQualityIndex {

  private int id;
  private int districtId;
  private Date monitorTime;
  private int pm10;
  private int pm25;
  private String monitoringStation;
  private Date lastModifyTime;
  private District district;

  public District getDistrict() {
    return district;
  }

  public void setDistrict(District district) {
    this.district = district;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDistrictId() {
    return districtId;
  }

  public void setDistrictId(int districtId) {
    this.districtId = districtId;
  }

  public Date getMonitorTime() {
    return monitorTime;
  }

  public void setMonitorTime(Date monitorTime) {
    this.monitorTime = monitorTime;
  }

  public int getPm10() {
    return pm10;
  }

  public void setPm10(int pm10) {
    this.pm10 = pm10;
  }

  public int getPm25() {
    return pm25;
  }

  public void setPm25(int pm25) {
    this.pm25 = pm25;
  }

  public String getMonitoringStation() {
    return monitoringStation;
  }

  public void setMonitoringStation(String monitoringStation) {
    this.monitoringStation = monitoringStation;
  }

  public Date getLastModifyTime() {
    return lastModifyTime;
  }

  public void setLastModifyTime(Date lastModifyTime) {
    this.lastModifyTime = lastModifyTime;
  }
}
