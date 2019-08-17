package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.InsuranceService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.InsuranceMapper;
import cn.zanezz.sys.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author zane
 */
@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService {
    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public int deleteByPrimaryKey(Integer insuranceId) {
        return insuranceMapper.deleteByPrimaryKey(insuranceId);
    }

    @Override
    public int insert(Insurance record) {
        return insuranceMapper.insert(record);
    }

    @Override
    public int insertSelective(Insurance record) {
        return insuranceMapper.insertSelective(record);
    }

    @Override
    public Insurance selectByPrimaryKey(Integer insuranceId) {
        return insuranceMapper.selectByPrimaryKey(insuranceId);
    }

    @Override
    public int updateByPrimaryKeySelective(Insurance record) {
        return insuranceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Insurance record) {
        return insuranceMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfInsurance(Insurance insurance) {

//        Insurance oldInsurance = insuranceMapper.selectInsuranceByUserId(insurance.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        insurance.setUpdateTime(Util.getNowDateTime());
//        if (oldInsurance != null) {
//            insurance.setInsuranceId(oldInsurance.getInsuranceId());
//            flag1 = insuranceMapper.updateByPrimaryKeySelective(insurance);
//        } else {
        insurance.setCreateTime(Util.getNowDateTime());
        flag2 = insuranceMapper.insert(insurance);
//        }
        if (flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Insurance> selectAllInsurance() {
        return insuranceMapper.selectAllInsurance();
    }

    @Override
    public List<Insurance> formatPageList(List<Insurance> aList, HashMap<String, String> dictionary) {
            for (Insurance insurance : aList) {
                insurance.setInsuranceOrNot(dictionary.get(insurance.getInsuranceOrNot()));
                insurance.setCompanyOfInsurance(dictionary.get(insurance.getCompanyOfInsurance()));
            }
        return aList;
    }


}
