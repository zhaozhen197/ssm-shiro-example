package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.MortgageHouse;

import java.util.HashMap;
import java.util.List;

public interface MortgageHouseService {
    int deleteByPrimaryKey(Integer mortgageHouseId);

    int insert(MortgageHouse record);

    int insertSelective(MortgageHouse record);

    MortgageHouse selectByPrimaryKey(Integer mortgageHouseId);

    int updateByPrimaryKeySelective(MortgageHouse record);

    int updateByPrimaryKey(MortgageHouse record);

     boolean inputOfMortgageHouse(MortgageHouse record);

    List<MortgageHouse> selectAllMortgageHouse();

    List<MortgageHouse> formatPageList(List<MortgageHouse> mortgageHouseList, HashMap<String, String> dictionary);

}