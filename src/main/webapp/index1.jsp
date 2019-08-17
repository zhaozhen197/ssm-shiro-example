<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black" name="apple-mobile-web-app-statusCode-bar-style"/>
    <meta content="telephone=no" name="format-detection"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="./static/drawer.min.css">
    <link rel="stylesheet" href="./static/iconfont.css">
    <link rel="stylesheet" href="./static/common.css">
    <link rel="stylesheet" href="./static/product.css">
</head>
<body>

<section class="aui-flexView">
    <section class="aui-scrollView">
        <div class="aui-reg-body">
            <div class="aui-reg-banner">
                <div class="header">
                    <div class="hdtop clearfix">
                        <span class="hdtopl">
                            <img src="./static/logo.png" class="logo"> <span id="productTitle"
                                                                             class="hdtopr">信用贷款</span>
                        </span>

                    </div>
                    <div class="ht1">最高借款额度(元)</div>
                    <div class="ht2">500,000</div>
                    <div class="ht3">
                        <span>当天放款</span>
                        <span>手续简单</span>
                        <span>通过率高</span>

                    </div>
                </div>

                <div class="prodetai">
                    <div class="title">产品详情</div>
                    <div class="detail">
                        <div class="pdr clearfix">
                            <div class="pdrl">最低月息</div>
                            <div class="pdrr">0.29%</div>
                        </div>
                        <div class="pdr clearfix">
                            <div class="pdrl">借款额度</div>
                            <div class="pdrr">￥50000-500000</div>
                        </div>
                        <div class="pdr clearfix">
                            <div class="pdrl">分期期限</div>
                            <div class="pdrr">可选12、24、36、48期</div>
                        </div>
                        <div class="pdr clearfix">
                            <div class="pdrl">还款规则</div>
                            <div class="pdrr">等额本息、先息后本</div>
                        </div>

                    </div>
                </div>
            </div>

            <div  class="aui-cell-item">
                <h2>立即注册</h2>
                <div class="aui-reg-item-for">
                    <i class="icon icon-user"></i>
                    <input id="name1" type="text" placeholder="请输入姓名">
                </div>
                <div class="aui-reg-item-for">
                    <i class="icon icon-phone"></i>
                    <input id="phone1" type="text" placeholder="请输入手机号码">
                </div>
                <div class="aui-reg-item-for">
                    <i class="icon icon-code"></i>
                    <input id="code1" type="text" autocomplete="off" placeholder="请输入验证码">
                    <input id="btnSendCode1" type="button" class="aui-code-btn" onClick="sendMessage1()" value="获取验证码">
                </div>
                <div class="aui-reg-item-go">
                    <button id="loginButton" type="button">立即注册</button>
                </div>
                <%--<div class="aui-reg-cell-right">--%>
                    <%--<label class="cell-right">--%>
                        <%--<input type="checkbox" value="1" name="checkbox" checked="checked">--%>
                        <%--<i class="cell-checkbox-icon"></i>--%>
                        <%--<p>我同意 <em>《用户协议书》</em></p>--%>
                    <%--</label>--%>


                <%--</div>--%>
            </div>

        </div>
        <div class="aui-cell-item">
            <div class="aui-reg-sit">
                <a href="javascript:;" class="aui-flex">
                    <div class="aui-tag-img">
                        <img src="images/fo-001.png" alt="">
                    </div>
                    <div class="aui-flex-box">
                        <h3>平台保障</h3>
                        <p>用户先付保证金,平台保障诚信合作</p>
                    </div>
                </a>
                <a href="javascript:;" class="aui-flex">
                    <div class="aui-tag-img">
                        <img src="images/fo-002.png" alt="">
                    </div>
                    <div class="aui-flex-box">
                        <h3>人工智能</h3>
                        <p>用户先付保证金,平台保障诚信合作</p>
                    </div>
                </a>
                <a href="javascript:;" class="aui-flex">
                    <div class="aui-tag-img">
                        <img src="images/fo-003.png" alt="">
                    </div>
                    <div class="aui-flex-box">
                        <h3>大数据支持</h3>
                        <p>用户先付保证金,平台保障诚信合作</p>
                    </div>
                </a>
            </div>
        </div>
        <div class="aui-footer-bg">
            <div class="hezuo">
                <img src="./static/huoban.png" alt="">
            </div>
            <img src="images/footer-bg.png" alt="">
            <div class="aui-footer-text">
                <p>北京时代索引网络技术有限公司 京ICP备15006025号-3</p>
                <h2><a href="http://116.255.173.38:88/Contact">
                    联系我们
                </a> <em>18519232894</em></h2>

            </div>
        </div>

        </div>

    </section>
</section>

<script type="text/javascript">
    var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;//手机号正则
    var count = 60; //间隔函数，1秒执行
    var InterValObj1; //timer变量，控制时间
    var curCount1;//当前剩余秒数
    /*第一*/
    function sendMessage1() {
        curCount1 = count;
        var phone = $.trim($('#phone1').val());
        if (!phoneReg.test(phone)) {
            alert(" 请输入有效的手机号码");
            return false;
        }
        //设置button效果，开始计时
        $("#btnSendCode1").attr("disabled", "true");
        $("#btnSendCode1").val(+curCount1 + "秒再获取");
        InterValObj1 = window.setInterval(SetRemainTime1, 1000); //启动计时器，1秒执行一次
        //向后台发送处理数据
        send(phone)
    }

    function SetRemainTime1() {
        if (curCount1 == 0) {
            window.clearInterval(InterValObj1);//停止计时器
            $("#btnSendCode1").removeAttr("disabled");//启用按钮
            $("#btnSendCode1").val("重新发送");
        }
        else {
            curCount1--;
            $("#btnSendCode1").val(+curCount1 + "秒再获取");
        }
    }

    /*提交*/
    function binding() {
        alert('请输入有效的手机号码')
    }

    function send(phone) {
        $.ajax({
            url: "<%=path%>/user/sendMessage",
            dataType: 'json',
            method: 'POST',
            data: {"phoneNumber": phone},
            success: function (data) {

                var parsedJson = jQuery.parseJSON(data);
                alert(parsedJson.statusCode + ":" + parsedJson.msg)
                //解析对象
                //alert(data.uname+"\n"+data.age);
                //解析map
                //alert(data.info.age+"\n"+data.info.uname);
                //解析list
                // $.each(data, function (i, dom) {
                //
                // });
            }
        });

    }

    $("#loginButton").click(
        function () {
            var name = $.trim($('#name1').val());
            var validateCode = $.trim($('#code1').val());
            var phone = $.trim($('#phone1').val());
            if (name == "" || name == undefined) {
                alert("姓名不能为空！");
                return false;
            }
            if (!phoneReg.test(phone)) {
                alert(" 请输入有效的手机号码");
                return false;
            }
            if (!codeReg.test(validateCode)) {
                alert("验证码为六位数字");
                return false;
            }

            // $("#form1").submit();

            $.ajax({
                url: "<%=basePath%>user/login",
                dataType: 'json',
                method: 'POST',
                data: {"phoneNumber": phone, "name": name, "validateCode": validateCode},
                success: function (data) {
                    alert(data.statusCode + ":" + data.msg);
                    if (data.statusCode == "success") {
                        window.location.href=".jsp?backurl="+window.location.href;
                    }
                }
            });

        });


</script>


<script type="text/javascript">
    function b() {
        t = parseInt(x.css('top'));
        y.css('top', '20px');
        x.animate({
            top: t - 20 + 'px'
        }, 'slow');
        if (Math.abs(t) == h - 20) {
            y.animate({
                top: '0px'
            }, 'slow');
            z = x;
            x = y;
            y = z;
        }
        setTimeout(b, 3000);
    }

    $(document).ready(function () {
        $('.swap').html($('.news_li').html());
        x = $('.news_li');
        y = $('.swap');
        h = $('.news_li li').length * 20;
        setTimeout(b, 3000);
    })
</script>
</body>


</html>
