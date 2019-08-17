package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.CompanyLoan;

import java.util.HashMap;
import java.util.List;

public interface CompanyLoanService {

    int deleteByPrimaryKey(Integer companyLoanId);

    int insert(CompanyLoan record);

    int insertSelective(CompanyLoan record);

    CompanyLoan selectByPrimaryKey(Integer companyLoanId);

    int updateByPrimaryKeySelective(CompanyLoan record);

    int updateByPrimaryKey(CompanyLoan record);

    public boolean inputOfCompanyLoan(CompanyLoan companyLoan);

    List<CompanyLoan> selectAllCompanyLoan();

    List<CompanyLoan> formatPageList(List<CompanyLoan> aList, HashMap<String, String> dictionary);
}
