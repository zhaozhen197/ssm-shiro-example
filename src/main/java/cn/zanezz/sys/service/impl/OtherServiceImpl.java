package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.OtherService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.OtherMapper;
import cn.zanezz.sys.entity.Other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * @author zane
 */
@Service("otherService")
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherMapper otherMapper;
    @Override
    public int insert(Other other) {
        return otherMapper.insert(other);
    }

    @Override
    public Other getOtherByUserId(int userId) {
        return otherMapper.getOtherByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(Other record) {
        return otherMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfOther(Other other) {
        Other oldOther = otherMapper.getOtherByUserId(other.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        other.setUpdateTime(Util.getNowDateTime());
        if (oldOther != null) {
            other.setOtherId(oldOther.getOtherId());
            flag1 = otherMapper.updateByPrimaryKeySelective(other);
        }else {
            other.setCreationTime(Util.getNowDateTime());
            flag2 =  otherMapper.insert(other);
        }

        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Other> selectAllOther() {
        return otherMapper.selectAllOther();
    }

    @Override
    public List<Other> formatPageList(List<Other> otherList, HashMap<String, String> dictionary) {
        return null;
    }

}
