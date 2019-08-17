package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.MortgageCar;

import java.util.HashMap;
import java.util.List;

public interface MortgageCarService {
    int deleteByPrimaryKey(Integer mortgageCarId);

    int insert(MortgageCar record);

    int insertSelective(MortgageCar record);

    MortgageCar selectByPrimaryKey(Integer mortgageCarId);

    int updateByPrimaryKeySelective(MortgageCar record);

    int updateByPrimaryKey(MortgageCar record);

    boolean inputOfMortgageCar(MortgageCar mortgageCar);

    List<MortgageCar> selectAllMortgageCar();

    List<MortgageCar> formatPageList(List<MortgageCar> aList, HashMap<String, String> dictionary);

}