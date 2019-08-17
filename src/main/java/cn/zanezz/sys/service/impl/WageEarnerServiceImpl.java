package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.WageEarnerService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.WageEarnerMapper;
import cn.zanezz.sys.entity.WageEarner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service("wageEarnerService")
public class WageEarnerServiceImpl implements WageEarnerService {
    @Autowired
    private WageEarnerMapper wageEarnerMapper;


    @Override
    public int insert(WageEarner wageEarner) {

        return wageEarnerMapper.insert(wageEarner);
    }

    @Override
    public WageEarner getWageEarnerByUserId(int userId) {
        return wageEarnerMapper.getWageEarnerByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(WageEarner record) {
        return wageEarnerMapper.updateByPrimaryKey(record);
    }

    /**
     * 保存输入的wageEarner信息，如果该用户之前已经提交过信息了，那么就是更新用户的信息，没有的话就插入
     * @param wageEarner
     * @return
     */
    @Override
    public boolean inputOfWageEarner(WageEarner wageEarner) {
        WageEarner oldWageEarner = wageEarnerMapper.getWageEarnerByUserId(wageEarner.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        wageEarner.setUpdateTime(Util.getNowDateTime());
        if (oldWageEarner != null) {
            wageEarner.setWageEarnerId(oldWageEarner.getWageEarnerId());
            flag1 = wageEarnerMapper.updateByPrimaryKeySelective(wageEarner);
        }else {
            wageEarner.setCreateTime(Util.getNowDateTime());
            flag2 =  wageEarnerMapper.insert(wageEarner);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<WageEarner> selectAllWageEarner() {
        return wageEarnerMapper.selectAllWageEarner();
    }

    @Override
    public List<WageEarner> formatPageList(List<WageEarner> wageEarnerList, HashMap<String, String> dictionary) {
        for (WageEarner wageEarner : wageEarnerList) {
            wageEarner.setSalaryType(dictionary.get(wageEarner.getSalaryType()));
            wageEarner.setPunchTime(dictionary.get(wageEarner.getPunchTime()));
            wageEarner.setCompanytype(dictionary.get(wageEarner.getCompanytype()));
        }
        return wageEarnerList;
    }

}
