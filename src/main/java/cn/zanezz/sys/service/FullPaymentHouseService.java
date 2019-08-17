package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.FullPaymentHouse;

import java.util.HashMap;
import java.util.List;

public interface FullPaymentHouseService {

    public int insert(FullPaymentHouse fullPaymentHouse);


    public FullPaymentHouse getFullPaymentHouseByUserId(int userId);


    public int updateByPrimaryKey(FullPaymentHouse record);

    public boolean inputOfFullPaymentHouse(FullPaymentHouse fullPaymentHouse);

    List<FullPaymentHouse> selectAllFullPaymentHouse();


    List<FullPaymentHouse> formatPageList(List<FullPaymentHouse> aList, HashMap<String, String> dictionary);

}
