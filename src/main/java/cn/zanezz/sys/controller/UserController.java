package cn.zanezz.sys.controller;

import cn.zanezz.sys.entity.*;
import cn.zanezz.sys.service.*;
import cn.zanezz.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * project helloSSM
 * authod 赵振
 * datetime 2017/11/23 16:16
 * desc
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CompanyLoanService companyLoanService;
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
//    private

    /**
     * 测试
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/showLoginCedit")
    public String toLoginCreditPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "loginCredit";
    }

    @RequestMapping("/showInputInfo")
    public String toInputPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "inputInfo";
    }

    @RequestMapping("/showInputCompany")
    public String toinputCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "inputCompany";
    }

    @RequestMapping("/showInputMortgage")
    public String toinputMortgage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "inputMortgage";
    }

    @RequestMapping("/showLoginCompany")
    public String toLoginCompanyPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "loginCompany";
    }

    @RequestMapping("/showLoginMortgage")
    public String toLoginMortgagePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "loginMortgage";
    }

    /**
     * 发送验证码
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String sendMessage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String mobeil = request.getParameter("phoneNumber");
        ReturnMessage message = messageService.sendMsg(mobeil);
        String jsonString = JSONObject.toJSONString(message);
        return jsonString;
    }


    /**
     * 用户进行登录                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   提交操作
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String name1 = request.getParameter("name");
        String validateCode = request.getParameter("validateCode");
        String type = request.getParameter("type");
        //验证验证码是否正确
        ReturnMessage returnMessage = messageService.selectCodeByPhone(phoneNumber, validateCode);
        if ("Success".equals(returnMessage.getStatusCode())) {
            User user = new User();
            user.setName1(name1);
            user.setPhone(phoneNumber);
            user.setType(type);
            user.setCreateTime(Util.getNowDateTime());
            User oldUser = userService.selectUserByPhone(user.getPhone());
            if (oldUser != null) {
                user.setUserId(oldUser.getUserId());
                userService.updateByPrimaryKeySelective(user);
            } else {
                userService.insertUser(user);
            }
        }
        //返回登录结果
        String jsonString = JSONObject.toJSONString(returnMessage);
        return jsonString;
    }

    /**
     * 接收输入的表单数据
     *
     * @param user
     * @param businessOwner
     * @param person
     * @param wageEarner
     * @param other
     * @param fund
     * @return
     */
    @RequestMapping(value = "/inputInfo", method = RequestMethod.POST)
    public String inputInfo(User user, BusinessOwner businessOwner, Person person, WageEarner wageEarner, Other other,
                            Fund fund, FullPaymentCar fullPaymentCar, FullPaymentHouse fullPaymentHouse,
                            MortgageCar mortgageCar, MortgageHouse mortgageHouse, InsuranceList insuranceList, String backUrl, RedirectAttributes attr) {
        User oldUser = userService.selectUserByPhone(user.getPhone());
        attr.addAttribute("backUrl", backUrl);
        boolean flagIdentity = false, flagFund = false;
        if (oldUser == null) {
            if ("mortgageLoan".equals(user.getType())) {
                return "loginMortgage";
            } else if ("creditLoan".equals(user.getType())) {
                return "loginCredit";
            } else {
                return "loginCompany";
            }
        }
        user.setName1(oldUser.getName1());
        user.setUserId(oldUser.getUserId());
        user.setPhone(oldUser.getPhone());
        user.setType(oldUser.getType());
        user.setUpdateTime(Util.getNowDateTime());
        userService.updateByPrimaryKeySelective(user);

        switch (user.getIdentity()) {
            case "wage_earners":
                wageEarner.setUserId(user.getUserId());
                wageEarner.setUserphone(user.getPhone());
                wageEarner.setUserName1(oldUser.getName1());
                flagIdentity = wageEarnerService.inputOfWageEarner(wageEarner);
                break;
            case "business_owner":
                businessOwner.setUserId(user.getUserId());
                businessOwner.setCreateTime(Util.getNowDateTime());
                businessOwner.setUserPhone(user.getPhone());
                businessOwner.setUserName1(oldUser.getName1());
                flagIdentity = businessOwnerService.inputOfBusinessOwner(businessOwner);
                break;
            case "person":
                person.setUserId(user.getUserId());
                person.setCreateTime(Util.getNowDateTime());
                person.setUserPhone(user.getPhone());
                person.setUserName1(oldUser.getName1());
                flagIdentity = personService.inputOfPerson(person);
                break;
            case "other":
                other.setUserId(user.getUserId());
                other.setCreationTime(Util.getNowDateTime());
                other.setUserPhone(user.getPhone());
                other.setUserName1(oldUser.getName1());
                flagIdentity = otherService.inputOfOther(other);
                break;
            default:
                break;

        }
        //公积金
        if ("1".equals(user.getFund())) {
            fund.setUserId(user.getUserId());
            fund.setUserPhone(user.getPhone());
            fund.setCreateTime(Util.getNowDateTime());
            fund.setUserName1(oldUser.getName1());
            flagFund = fundService.inputOfFund(fund);
        }

        //是否有房
        switch (user.getHouse()) {
            case "fullPaymentHouse":
                fullPaymentHouse.setUserId(user.getUserId());
                fullPaymentHouse.setUserPhone(user.getPhone());
                fullPaymentHouse.setUserName1(oldUser.getName1());
                fullPaymentHouseService.inputOfFullPaymentHouse(fullPaymentHouse);
                break;
            case "mortgageHouse":
                mortgageHouse.setUserId(user.getUserId());
                mortgageHouse.setUserPhone(user.getPhone());
                mortgageHouse.setUserName1(oldUser.getName1());
                mortgageHouseService.inputOfMortgageHouse(mortgageHouse);
                break;
            default:
                break;
        }

        //车
        switch (user.getCar()) {
            case "fullPaymentCar":
                fullPaymentCar.setUserId(user.getUserId());
                fullPaymentCar.setUserPhone(user.getPhone());
                fullPaymentCar.setUserName1(oldUser.getName1());
                fullPaymentCarService.inputOfFullPaymentCar(fullPaymentCar);
                break;
            case "mortgageCar":
                mortgageCar.setUserId(user.getUserId());
                mortgageCar.setUserPhone(user.getPhone());
                mortgageCar.setUserName1(oldUser.getName1());
                mortgageCarService.inputOfMortgageCar(mortgageCar);
                break;
            default:
                break;

        }

        //保险
        if ("1".equals(user.getInsurance())) {
//            insuranceService.deleteByPrimaryKey()
            for (Insurance insurance : insuranceList.getInsuranceList()) {
                if (!insuranceIsNull(insurance)) {
                    insurance.setUserId(user.getUserId());
                    insurance.setUserPhone(user.getPhone());
                    insurance.setUserName1(oldUser.getName1());
                    insuranceService.inputOfInsurance(insurance);
                }
            }
        }
        return "redirect:showContact";
//        ReturnMessage returnMessage= new ReturnMessage("Success","信息保存成功！");
//        if (!flagFund || !flagIdentity) {
//            returnMessage.setStatusCode("Error");
//            returnMessage.setMsg("信息保存失败请重试1");
//        }
//        String jsonString = JSONObject.toJSONString(returnMessage);
//        if (!flagFund || !flagIdentity) {
//            return "inputInfo";
//        }
    }


    //跳转到提交成功提示页面
    @RequestMapping(value = "/showContact")
    public String showContact() {
        return "contact";
    }

    /**
     * 判断用户输入的保单信息是否为空
     *
     * @param insurance
     * @return
     */
    boolean insuranceIsNull(Insurance insurance) {
        if (insurance.getMoneyOfYearInsurance() == null && "0".equals(insurance.getInsuranceOrNot())
                && "companyOfInsurance0".equals(insurance.getCompanyOfInsurance()) && insurance.getYearsOfInsurance() == null) {
            return true;
        } else {

            return false;
        }

    }


    /**
     * 判断按揭房是否为空
     *
     * @param mortgageHouse
     * @return
     */
    boolean mortgageHouseIsNull(MortgageHouse mortgageHouse) {
        if (mortgageHouse.getRightOfPeoplenumber() == null && mortgageHouse.getMarketValue() == null && mortgageHouse.getHouseArea() == null
                && mortgageHouse.getCompleteYear() == null && mortgageHouse.getRemainingMoney() == null
        ) {

            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断全款房是否为空
     *
     * @param fullPaymentHouse
     * @return
     */
    boolean fullPaymentHouseIsNull(FullPaymentHouse fullPaymentHouse) {
        if (fullPaymentHouse.getCompleteYear() == null && fullPaymentHouse.getHouseArea() == null
                && fullPaymentHouse.getMarketValue() == null && fullPaymentHouse.getRightOfPeoplenumber() == null
        ) {
            return true;
        } else {

            return false;
        }

    }

    /**
     * 企业贷款 控制器方法
     *
     * @param user
     * @param companyLoan
     * @param backUrl
     * @param attr
     * @return
     */
    @RequestMapping(value = "/companyLoan", method = RequestMethod.POST)
    public String companyLoan(User user, CompanyLoan companyLoan, String backUrl, RedirectAttributes attr) {
        User oldUser = userService.selectUserByPhone(user.getPhone());
        attr.addAttribute("backUrl", backUrl);
        boolean flagIdentity = false, flagFund = false;
        if (oldUser == null) {
            return "loginCompany";
        }
        user.setName1(oldUser.getName1());
        user.setUserId(oldUser.getUserId());
        user.setPhone(oldUser.getPhone());
        user.setType(oldUser.getType());
        user.setUpdateTime(Util.getNowDateTime());
        userService.updateByPrimaryKeySelective(user);
        companyLoan.setIdentity(user.getIdentity());
        companyLoan.setUserId(user.getUserId());
        companyLoan.setPhone(user.getPhone());
        companyLoan.setName1(user.getName1());
        companyLoanService.inputOfCompanyLoan(companyLoan);
        return "redirect:showContact";
    }


    /**
     * 抵押贷款控制器方法
     * @param user
     * @param mortgageHouseList
     * @param fullPaymentHouseList
     * @param attr
     * @return
     */
    @RequestMapping(value = "/mortgageLoan", method = RequestMethod.POST)
    public String MortgageLoan(User user, BusinessOwner businessOwner, Person person, WageEarner wageEarner, Other other, MortgageHouseList mortgageHouseList, FullPaymentHouseList fullPaymentHouseList, String backUrl, RedirectAttributes attr) {

        User oldUser = userService.selectUserByPhone(user.getPhone());
        if (oldUser == null) {
            return "loginMortgage";
        }

        attr.addAttribute("backUrl", backUrl);
        user.setName1(oldUser.getName1());
        user.setUserId(oldUser.getUserId());
        user.setPhone(oldUser.getPhone());
        user.setType(oldUser.getType());
        user.setUpdateTime(Util.getNowDateTime());
        userService.updateByPrimaryKeySelective(user);

        switch (user.getIdentity()) {
            case "wage_earners":
                wageEarner.setUserId(user.getUserId());
                wageEarner.setUserphone(user.getPhone());
                wageEarner.setUserName1(oldUser.getName1());
                wageEarnerService.inputOfWageEarner(wageEarner);
                break;
            case "business_owner":
                businessOwner.setUserId(user.getUserId());
                businessOwner.setCreateTime(Util.getNowDateTime());
                businessOwner.setUserPhone(user.getPhone());
                businessOwner.setUserName1(oldUser.getName1());
                businessOwnerService.inputOfBusinessOwner(businessOwner);
                break;
            case "person":
                person.setUserId(user.getUserId());
                person.setCreateTime(Util.getNowDateTime());
                person.setUserPhone(user.getPhone());
                person.setUserName1(oldUser.getName1());
                personService.inputOfPerson(person);
                break;
            case "other":
                other.setUserId(user.getUserId());
                other.setCreationTime(Util.getNowDateTime());
                other.setUserPhone(user.getPhone());
                other.setUserName1(oldUser.getName1());
                otherService.inputOfOther(other);
                break;
            default:
                break;

        }


        if ("fullPaymentHouse".equals(user.getHouse())) {

            for (FullPaymentHouse fullPaymentHouse : fullPaymentHouseList.getFullPaymentHouseList()) {
                if (!fullPaymentHouseIsNull(fullPaymentHouse)) {
                    fullPaymentHouse.setUserPhone(user.getPhone());
                    fullPaymentHouse.setUserName1(user.getName1());
                    fullPaymentHouse.setUserId(user.getUserId());
                    fullPaymentHouse.setCreateTime(Util.getNowDateTime());
                    fullPaymentHouse.setUpdateTime(Util.getNowDateTime());
                    fullPaymentHouseService.insert(fullPaymentHouse);
                }
            }
        } else if ("mortgageHouse".equals(user.getHouse())) {
            for (MortgageHouse mortgageHouse : mortgageHouseList.getMortgageHouseList()) {
                if (!mortgageHouseIsNull(mortgageHouse)) {
                    mortgageHouse.setUserPhone(user.getPhone());
                    mortgageHouse.setUserId(user.getUserId());
                    mortgageHouse.setUserName1(user.getName1());
                    mortgageHouse.setHouseType(user.getType());
                    mortgageHouse.setUpdateTime(Util.getNowDateTime());
                    mortgageHouse.setCreateTime(Util.getNowDateTime());
                    mortgageHouseService.insert(mortgageHouse);
                }
            }
        }

        return "redirect:showContact";
    }
}

