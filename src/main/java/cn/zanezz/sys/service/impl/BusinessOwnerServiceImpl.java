package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.BusinessOwnerService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.BusinessOwnerMapper;
import cn.zanezz.sys.entity.BusinessOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("bussinessOwnerService")
public class BusinessOwnerServiceImpl implements BusinessOwnerService {

    @Autowired
    private BusinessOwnerMapper businessOwnerMapper;

    @Override
    public int insert(BusinessOwner businessOwner) {
        return businessOwnerMapper.insert(businessOwner);
    }

    @Override
    public BusinessOwner getBusinessOwnerByUserId(int userId) {
        return businessOwnerMapper.getBusinessOwnerByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(BusinessOwner record) {
        return businessOwnerMapper.updateByPrimaryKey(record);
    }


    @Override
    public boolean inputOfBusinessOwner(BusinessOwner businessOwner) {
        BusinessOwner oldBusinessOwner = businessOwnerMapper.getBusinessOwnerByUserId(businessOwner.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        businessOwner.setUpdateTime(Util.getNowDateTime());
        if (oldBusinessOwner != null) {
            businessOwner.setBusinessOwnerId(oldBusinessOwner.getBusinessOwnerId());
            flag1 = businessOwnerMapper.updateByPrimaryKeySelective(businessOwner);
        } else {
            businessOwner.setCreateTime(Util.getNowDateTime());
             flag2 = businessOwnerMapper.insert(businessOwner);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<BusinessOwner> selectAllBusinessOwner() {
        return businessOwnerMapper.selectAllBusinessOwner();
    }

    @Override
    public List<BusinessOwner> formatPageList(List<BusinessOwner> aList, HashMap<String, String> dictionary) {
        for (BusinessOwner businessOwner : aList) {
            businessOwner.setOperationYears(dictionary.get(businessOwner.getOperationYears()));
            businessOwner.setLocationOfCompany(dictionary.get(businessOwner.getLocationOfCompany()));
            businessOwner.setLicense(dictionary.get(businessOwner.getLicense()));
        }
        return aList;
    }

}
