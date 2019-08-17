package cn.zanezz.sys.service;


import cn.zanezz.sys.entity.BusinessOwner;

import java.util.HashMap;
import java.util.List;

public interface BusinessOwnerService {
    public int insert(BusinessOwner businessOwner);


    public BusinessOwner getBusinessOwnerByUserId(int userId);


    public int updateByPrimaryKey(BusinessOwner record);

    public boolean inputOfBusinessOwner(BusinessOwner businessOwner);

    List<BusinessOwner> selectAllBusinessOwner();

    List<BusinessOwner> formatPageList(List<BusinessOwner> aList, HashMap<String, String> dictionary);


}
