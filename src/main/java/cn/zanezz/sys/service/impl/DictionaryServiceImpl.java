package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.DictionaryService;
import cn.zanezz.sys.mapper.DictionaryMapper;
import cn.zanezz.sys.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zane
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int deleteByPrimaryKey(Integer dictionaryId) {
        return dictionaryMapper.deleteByPrimaryKey(dictionaryId);
    }

    @Override
    public int insert(Dictionary record) {
        return dictionaryMapper.insert(record);
    }

    @Override
    public int insertSelective(Dictionary record) {
        return dictionaryMapper.insertSelective(record);
    }

    @Override
    public Dictionary selectByPrimaryKey(Integer dictionaryId) {
        return dictionaryMapper.selectByPrimaryKey(dictionaryId);
    }

    @Override
    public int updateByPrimaryKeySelective(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, String>> selectAllDictionaryHashMap() {
        return dictionaryMapper.selectAllDictionaryHashMap();
    }

    /**
     * 组装成map.在页面展示的时候进行数据格式转换。
     *
     * @param dictionaries
     * @return
     */
    @Override
    public Map<String, String> formatToDictionary(List<Map<String, String>> dictionaries) {
        List<Map<String, String>> list = dictionaryMapper.selectAllDictionaryHashMap();
        Map<String, String> resultMap = new HashMap();
        for (Map<String, String> hashMap : list) {
            resultMap.put(hashMap.get("key"), hashMap.get("value"));
        }
        return resultMap;
    }
}
