package cn.zanezz.sys.service;


import cn.zanezz.sys.entity.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService {
    int deleteByPrimaryKey(Integer dictionaryId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dictionaryId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    List<Map<String, String>> selectAllDictionaryHashMap();

    /**
     * 组装成map.在页面展示的时候进行数据格式转换。
     * @param dictionaries
     * @return
     */
    Map<String, String> formatToDictionary(List<Map<String, String>> dictionaries);

}
