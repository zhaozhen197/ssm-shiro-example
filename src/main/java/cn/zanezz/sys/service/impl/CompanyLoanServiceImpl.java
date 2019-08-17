package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.CompanyLoanService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.CompanyLoanMapper;
import cn.zanezz.sys.entity.CompanyLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("companyLoanService")
public class CompanyLoanServiceImpl implements CompanyLoanService {
    @Autowired
    private CompanyLoanMapper companyLoanMapper;

    @Override
    public int deleteByPrimaryKey(Integer companyLoanId) {
        return companyLoanMapper.deleteByPrimaryKey(companyLoanId);
    }

    @Override
    public int insert(CompanyLoan record) {
        return companyLoanMapper.insert(record);
    }

    @Override
    public int insertSelective(CompanyLoan record) {
        return companyLoanMapper.insertSelective(record);
    }

    @Override
    public CompanyLoan selectByPrimaryKey(Integer companyLoanId) {
        return companyLoanMapper.selectByPrimaryKey(companyLoanId);
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyLoan record) {
        return companyLoanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CompanyLoan record) {
        return companyLoanMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfCompanyLoan(CompanyLoan companyLoan) {
        CompanyLoan oldCompanyLoan = companyLoanMapper.selectCompanyLoanByUserId(companyLoan.getUserId());

        int flag1 = 0;
        int flag2 = 0;

        companyLoan.setUpdateTime(Util.getNowDateTime());
        if (oldCompanyLoan != null) {
            companyLoan.setCompanyLoanId(oldCompanyLoan.getCompanyLoanId());
            flag1 = companyLoanMapper.updateByPrimaryKeySelective(companyLoan);
        } else {
            companyLoan.setAddTime(Util.getNowDateTime());
            flag2 = companyLoanMapper.insert(companyLoan);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<CompanyLoan> selectAllCompanyLoan() {
        return companyLoanMapper.selectAllCompanyLoan();
    }

    @Override
    public List<CompanyLoan> formatPageList(List<CompanyLoan> aList, HashMap<String, String> dictionary) {
        for (CompanyLoan companyLoan : aList) {
            companyLoan.setIdentity(dictionary.get(companyLoan.getIdentity()));
        }
        return aList;
    }
}
