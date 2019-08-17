package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Other;

import java.util.HashMap;
import java.util.List;

/**
 * @author zane
 */
public interface OtherService {
    public int insert(Other other);


    public Other getOtherByUserId(int userId);


    public int updateByPrimaryKey(Other record);

    public boolean inputOfOther(Other Other);

    List<Other> selectAllOther();

    List<Other> formatPageList(List<Other> otherList, HashMap<String, String> dictionary);

}
