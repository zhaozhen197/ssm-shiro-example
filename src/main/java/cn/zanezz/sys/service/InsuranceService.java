package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Insurance;

import java.util.HashMap;
import java.util.List;

public interface InsuranceService {
    int deleteByPrimaryKey(Integer insuranceId);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer insuranceId);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);

    boolean inputOfInsurance(Insurance insurance);

    List<Insurance> selectAllInsurance();

    List<Insurance> formatPageList(List<Insurance> aList, HashMap<String, String> dictionary);


}