package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Fund;

import java.util.HashMap;
import java.util.List;

public interface FundService {

    public int insert(Fund fund);


    public Fund getFundByUserId(int userId);


    public int updateByPrimaryKey(Fund record);

    public boolean inputOfFund(Fund fund);

    public List<Fund> selectAllUserFund();
    List<Fund> formatPageList(List<Fund> aList, HashMap<String, String> dictionary);

}
