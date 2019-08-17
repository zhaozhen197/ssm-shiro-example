package cn.zanezz.sys.service;


import cn.zanezz.sys.entity.WageEarner;

import java.util.HashMap;
import java.util.List;

public interface WageEarnerService {

    public int insert(WageEarner wageEarner);


    public WageEarner getWageEarnerByUserId(int userId);


    public int updateByPrimaryKey(WageEarner record);

    public boolean inputOfWageEarner(WageEarner wageEarner);

    List<WageEarner> selectAllWageEarner();

    List<WageEarner> formatPageList(List<WageEarner> wageEarnerList, HashMap<String, String> dictionary);

}
