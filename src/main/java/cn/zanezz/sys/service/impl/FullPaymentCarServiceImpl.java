package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.FullPaymentCarService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.FullPaymentCarMapper;
import cn.zanezz.sys.entity.FullPaymentCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("fullPaymentCarService")
public class FullPaymentCarServiceImpl implements FullPaymentCarService {
    @Autowired
    private FullPaymentCarMapper fullPaymentCarMapper;
    @Override
    public int deleteByPrimaryKey(Integer fullPaymentCarId) {
        return fullPaymentCarMapper.deleteByPrimaryKey(fullPaymentCarId);
    }

    @Override
    public int insert(FullPaymentCar record) {
        return fullPaymentCarMapper.insert(record);
    }

    @Override
    public int insertSelective(FullPaymentCar record) {
        return fullPaymentCarMapper.insertSelective(record);
    }

    @Override
    public FullPaymentCar selectByPrimaryKey(Integer fullPaymentCarId) {
        return fullPaymentCarMapper.selectByPrimaryKey(fullPaymentCarId);
    }

    @Override
    public int updateByPrimaryKeySelective(FullPaymentCar record) {
        return fullPaymentCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FullPaymentCar record) {
        return fullPaymentCarMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfFullPaymentCar(FullPaymentCar fullPaymentCar) {
        FullPaymentCar oldFullPaymentCar = fullPaymentCarMapper.selectFullPaymentCarByUserId(fullPaymentCar.getUserId());

        int flag1 = 0;
        int flag2 = 0;

        fullPaymentCar.setUpdateTime(Util.getNowDateTime());
        if (oldFullPaymentCar != null) {
            fullPaymentCar.setFullPaymentCarId(oldFullPaymentCar.getFullPaymentCarId());
            flag1 = fullPaymentCarMapper.updateByPrimaryKeySelective(fullPaymentCar);
        } else {
            fullPaymentCar.setCreateTime(Util.getNowDateTime());
            flag2 = fullPaymentCarMapper.insert(fullPaymentCar);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<FullPaymentCar> selectAllFullPaymentCar() {
        return fullPaymentCarMapper.selectAllFullPaymentCar();
    }

    @Override
    public List<FullPaymentCar> formatPageList(List<FullPaymentCar> aList, HashMap<String, String> dictionary) {

        return null;
    }

}
