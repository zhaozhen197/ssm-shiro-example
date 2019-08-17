package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.MortgageHouseService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.MortgageHouseMapper;
import cn.zanezz.sys.entity.MortgageHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("mortgageHouseService")
public class MortgageHouseServiceImpl implements MortgageHouseService {
    @Autowired
    private MortgageHouseMapper mortgageHouseMapper;


    @Override
    public int deleteByPrimaryKey(Integer mortgageHouseId) {
        return mortgageHouseMapper.deleteByPrimaryKey(mortgageHouseId);
    }

    @Override
    public int insert(MortgageHouse record) {
        return mortgageHouseMapper.insert(record);
    }

    @Override
    public int insertSelective(MortgageHouse record) {
        return mortgageHouseMapper.insertSelective(record);
    }

    @Override
    public MortgageHouse selectByPrimaryKey(Integer mortgageHouseId) {
        return mortgageHouseMapper.selectByPrimaryKey(mortgageHouseId);
    }

    @Override
    public int updateByPrimaryKeySelective(MortgageHouse record) {
        return mortgageHouseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MortgageHouse record) {
        return mortgageHouseMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfMortgageHouse(MortgageHouse record) {

        MortgageHouse oldMortgageHouse = mortgageHouseMapper.selectMortgageHouseByUserId(record.getUserId());
        int flag1 = 0;
        int flag2 = 0;
        record.setUpdateTime(Util.getNowDateTime());
        if (oldMortgageHouse != null) {
            record.setMortgageHouseId(oldMortgageHouse.getMortgageHouseId());
            flag1 = mortgageHouseMapper.updateByPrimaryKeySelective(record);
        } else {
            record.setCreateTime(Util.getNowDateTime());
            flag2 = mortgageHouseMapper.insert(record);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<MortgageHouse> selectAllMortgageHouse() {
        return mortgageHouseMapper.selectAllMortgageHouse();
    }

    @Override
    public List<MortgageHouse> formatPageList(List<MortgageHouse> mortgageHouseList, HashMap<String, String> dictionary) {
        for (MortgageHouse mortgageHouse : mortgageHouseList) {
            mortgageHouse.setMianLoanPerson(dictionary.get(mortgageHouse.getMianLoanPerson()));
            mortgageHouse.setHouseType(dictionary.get(mortgageHouse.getHouseType()));
        }
        return mortgageHouseList;
    }

}
