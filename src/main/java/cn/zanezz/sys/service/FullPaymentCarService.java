package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.FullPaymentCar;

import java.util.HashMap;
import java.util.List;

/**
 * @author zane
 */
public interface FullPaymentCarService {

    int deleteByPrimaryKey(Integer fullPaymentCarId);

    int insert(FullPaymentCar record);

    int insertSelective(FullPaymentCar record);

    FullPaymentCar selectByPrimaryKey(Integer fullPaymentCarId);

    int updateByPrimaryKeySelective(FullPaymentCar record);

    int updateByPrimaryKey(FullPaymentCar record);

    public boolean inputOfFullPaymentCar(FullPaymentCar fullPaymentCar);

    List<FullPaymentCar> selectAllFullPaymentCar();

    List<FullPaymentCar> formatPageList(List<FullPaymentCar> aList, HashMap<String, String> dictionary);


}
