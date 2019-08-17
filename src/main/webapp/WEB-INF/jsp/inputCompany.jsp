<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="Author" contect="">
    <title>信息填写</title>
    <link href="<%=basePath%>select/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>select/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>select/js/rem.js" type="text/javascript"></script>
</head>
<body>
<div class="content invoice_cont">
    <div class="header">
        <div class="head">
            <a href="javascript:;" onclick="javascript:history.back(-1);" class="back"></a>
            信息填写
        </div>
    </div>
    <div class="forms">
        <form id="form1" method="post" action="<%=basePath%>user/companyLoan">

            <input id="setPhone" name="phone" type="hidden">
            <input id="setBackUrl" name="backUrl" type="hidden">

            <div class="formList clearfix">
                <div class="formTi float-l">申请金额(万)<span class="red">*</span></div>
                <div class="form_input float-l">
                    <input id="loanMoney" name="loanMoney" type="number" placeholder="请输入您所申请的贷款金额"/>
                </div>
            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">申请期限(月)<span class="red">*</span></div>
                <div class="form_input float-l">
                    <input name="loanTimeLimit" type="number" placeholder="请输入您贷款期限"/>
                </div>
            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">本人姓名<span class="red">*</span></div>
                <div class="form_input float-l">
                    <input name="name2" type="text" placeholder="请输入"/>
                </div>
            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">公司情况<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select id="identity" name="identity" class="form_sel">
                        <option value="0">请选择</option>
                        <option value="legalPerson">法人</option>
                        <option value="shareHolder">股东</option>
                    </select>
                </div>
            </div>
            <div id="identitydiv">
            </div>


            <div class="formList clearfix">
                <div class="formTi float-l">征信<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select name="credit" class="form_sel">
                        <option value="0">请选择</option>
                        <option value="credit1">信用良好</option>
                        <option value="credit2">半年内逾期超过2次或者30天以上逾期</option>
                        <option value="credit3">一年内逾期超过3次或者90天以上逾期</option>
                        <option value="credit4">无信用卡贷款</option>
                    </select>
                </div>
            </div>


            <%--<div class="fuwuxuzhi"><label for="xuzhi"><input type="checkbox" checked id="xuzhi"/>已阅读</label> <span--%>
            <%--class="red">服务须知</span></div>--%>
            <button type="button" id="button1" class="formsub" style="margin:.7rem auto .5rem auto;">提交
            </button>
        </form>
    </div>

</div>


<div class="bg100"></div>
<script type="text/javascript">
    $(document).ready(function () {
        //设置电话号码
        setPhoneHidden();
        setBackUrl();
        $("#identity").change(function () {
            var data = $("#identity").val();
            switch (data) {
                case "legalPerson":
                    $("#identitydiv").empty();
                    $("#identitydiv").append(
                        "<div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>公司成立期限(年)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"companyYears\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>公司近一年开票金额(万)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"invoiceFee\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>公司近一年纳税金额(万)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"taxFee\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>"
                    );
                    break;
                case "shareHolder":
                    $("#identitydiv").empty();
                    $("#identitydiv").append(
                        "<div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>占股比例(%)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"stockPer\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>公司成立期限(年)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"companyYears\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>公司近一年开票金额(万)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"invoiceFee\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\" style='color: #8a8a8a;'>公司近一年纳税金额(万)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"taxFee\" type=\"number\" style='color: #8a8a8a;' placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>"
                    );
                    break;
                default:
                    $("#identitydiv").empty(

                    );
            }
        })

    });


    $("#button1").click(
        function () {
            var money = $("input[name='loanMoney']").val();
            var loanTimeLimit = $("input[name='loanTimeLimit']").val();
            var name = $("input[name='name2']").val();

            var g = /^[1-9]*[1-9][0-9]*$/;
            var flag = 1;
            if (money == "" || money == null || money == undefined) {
                alert("贷款金额不能为空！");
                flag = 0;
            } else if (!g.test(money)) {
                flag = 0;
                alert("贷款金额只能是数字")
            } else if (loanTimeLimit == "" || loanTimeLimit == null || loanTimeLimit == undefined) {
                alert("贷款期限不能为空");
                flag = 0;
            } else if (!g.test(loanTimeLimit)) {
                alert("贷款期限只能是数字")
                flag = 0;
            } else if (name == "" || name == null || name == undefined) {
                flag = 0;
                alert("本人姓名不能为空！")
            }
            if (flag == 1) {
                $("#form1").submit();
                alert("信息提交成功！")
                <%--window.location.href = "<%=basePath%>user/showContact";--%>
            } else {
                return;
            }
        });

    /**
     * 获取地址栏中传过来的电话号码
     * @returns {string[]}
     * @constructor
     */
    function setPhoneHidden() {
        var url = document.location.toString();
        var arrUrl = url.split("&");
        var paras = arrUrl[1];
        var par = paras.split("=");
        $("#setPhone").val(par[1]);
    }

    function setBackUrl() {
        var url = document.location.toString();
        var arrUrl = url.split("=");
        var paras = arrUrl[1];
        var par = paras.split("&");
        $("#setBackUrl").val(par[0]);
    }
</script>

</body>
</html>