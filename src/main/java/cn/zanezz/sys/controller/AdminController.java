package cn.zanezz.sys.controller;


import cn.zanezz.sys.entity.*;
import cn.zanezz.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zane
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @Autowired
    private WageEarnerService wageEarnerService;

    @Autowired
    private PersonService personService;

    @Autowired
    private OtherService otherService;

    @Autowired
    private BusinessOwnerService businessOwnerService;

    @Autowired
    private FundService fundService;

    @Autowired
    private FullPaymentHouseService fullPaymentHouseService;

    @Autowired
    private FullPaymentCarService fullPaymentCarService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private MortgageHouseService mortgageHouseService;

    @Autowired
    private MortgageCarService mortgageCarService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CompanyLoanService companyLoanService;

    @RequestMapping("/allUserList")
    public String toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> allUser = userService.selectAllUser();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        List<User> userList = userService.formatPageList(allUser, (HashMap<String, String>) dictionary);
        request.setAttribute("userList", userList);
        return "admin/allUserList";
    }

    @RequestMapping("/wageEarnerList")
    public String wageEarnerList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<WageEarner> wageEarnerList = new ArrayList<>();
        wageEarnerList = wageEarnerService.selectAllWageEarner();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        wageEarnerList = wageEarnerService.formatPageList(wageEarnerList, (HashMap<String, String>) dictionary);
        request.setAttribute("wageEarnerList", wageEarnerList);
        return "admin/wageEarnerList";
    }

    @RequestMapping("/bussinessOwnerList")
    public String bussinessOwnerList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<BusinessOwner> businessOwnerList = new ArrayList<>();
        businessOwnerList = businessOwnerService.selectAllBusinessOwner();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        businessOwnerList = businessOwnerService.formatPageList(businessOwnerList, (HashMap<String, String>) dictionary);
        request.setAttribute("businessOwnerList", businessOwnerList);
        return "admin/bussinessOwnerList";
    }

    @RequestMapping("/personList")
    public String personList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Person> personList = new ArrayList<>();
        personList = personService.selectAllPerson();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        personList = personService.formatPageList(personList, (HashMap<String, String>) dictionary);
        request.setAttribute("personList", personList);
        return "admin/personList";
    }


    @RequestMapping("/otherList")
    public String otherList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Other> otherList = new ArrayList<>();
        otherList = otherService.selectAllOther();
        request.setAttribute("otherList", otherList);
        return "admin/otherList";
    }

    @RequestMapping("/fullPaymentCarList")
    public String fullPaymentCarList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<FullPaymentCar> fullPaymentCarList = new ArrayList<>();
        fullPaymentCarList = fullPaymentCarService.selectAllFullPaymentCar();
        request.setAttribute("fullPaymentCarList", fullPaymentCarList);
        return "admin/fullPaymentCarList";
    }

    @RequestMapping("/fullPaymentHouseList")
    public String fullPaymentHouseList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<FullPaymentHouse> fullPaymentHouseList = new ArrayList<>();
        fullPaymentHouseList = fullPaymentHouseService.selectAllFullPaymentHouse();
        request.setAttribute("fullPaymentHouseList", fullPaymentHouseList);
        return "admin/fullPaymentHouseList";
    }


    @RequestMapping("/mortgageHouseList")
    public String mortgageHouseList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<MortgageHouse> mortgageHouselist = mortgageHouseService.selectAllMortgageHouse();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        mortgageHouselist = mortgageHouseService.formatPageList(mortgageHouselist, (HashMap<String, String>) dictionary);
        request.setAttribute("mortgageHouseList", mortgageHouselist);
        return "admin/mortgageHouseList";
    }

    @RequestMapping("/mortgageCarList")
    public String mortgageCarList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<MortgageCar> mortgageCarList = new ArrayList<>();
        mortgageCarList = mortgageCarService.selectAllMortgageCar();
        request.setAttribute("mortgageCarList", mortgageCarList);
        return "admin/mortgageCarList";
    }

    @RequestMapping("/fundList")
    public String fundList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Fund> fundList = new ArrayList<>();
        fundList = fundService.selectAllUserFund();
        request.setAttribute("fundList", fundList);
        return "admin/fundList";
    }


    @RequestMapping("/insuranceList")
    public String insuranceList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Insurance> insuranceList = new ArrayList<>();
        insuranceList = insuranceService.selectAllInsurance();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        insuranceList = insuranceService.formatPageList(insuranceList, (HashMap<String, String>) dictionary);
        request.setAttribute("insuranceList", insuranceList);
        return "admin/insuranceList";
    }


    @RequestMapping("/companyLoanList")
    public String companyLoanList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CompanyLoan> companyLoanList = new ArrayList<>();
        companyLoanList = companyLoanService.selectAllCompanyLoan();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        companyLoanList = companyLoanService.formatPageList(companyLoanList, (HashMap<String, String>) dictionary);
        request.setAttribute("companyLoanList", companyLoanList);
        return "admin/companyLoanList";
    }
}
