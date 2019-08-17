package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.FullPaymentHouseService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.FullPaymentHouseMapper;
import cn.zanezz.sys.entity.FullPaymentHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author zane
 */
@Service("fullPaymentHouseService")
public class FullPaymentHouseServiceImpl implements FullPaymentHouseService {
    @Autowired
    private FullPaymentHouseMapper fullPaymentHouseMapper;

    @Override
    public int insert(FullPaymentHouse fullPaymentHouse) {
        return fullPaymentHouseMapper.insert(fullPaymentHouse);
    }

    @Override
    public FullPaymentHouse getFullPaymentHouseByUserId(int userId) {
        return fullPaymentHouseMapper.getFullPaymentHouseByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(FullPaymentHouse record) {
        return fullPaymentHouseMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfFullPaymentHouse(FullPaymentHouse fullPaymentHouse) {
        FullPaymentHouse oldFullPaymentHouse = fullPaymentHouseMapper.getFullPaymentHouseByUserId(fullPaymentHouse.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        fullPaymentHouse.setUpdateTime(Util.getNowDateTime());
        if (oldFullPaymentHouse != null) {
            fullPaymentHouse.setFullPaymentHouseId(oldFullPaymentHouse.getFullPaymentHouseId());
            flag1 = fullPaymentHouseMapper.updateByPrimaryKeySelective(fullPaymentHouse);

        } else {
            fullPaymentHouse.setCreateTime(Util.getNowDateTime());
            flag2 = fullPaymentHouseMapper.insert(fullPaymentHouse);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<FullPaymentHouse> selectAllFullPaymentHouse() {
        return fullPaymentHouseMapper.selectAllFullPaymentHouse();
    }

    @Override
    public List<FullPaymentHouse> formatPageList(List<FullPaymentHouse> aList, HashMap<String, String> dictionary) {
        return null;
    }

}
