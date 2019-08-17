<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="Zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="content-type" content="text/html">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>联系我们</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" href="<%=basePath%>contact/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>contact/drawer.min.css">
    <link rel="stylesheet" href="<%=basePath%>contact/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>contact/common.css">
    <link rel="stylesheet" href="<%=basePath%>contact/product.css">

    <style>
        .content {
            padding: 18px 15px;
            font-size: 16px;
            line-height: 30px;
        }

        .content div {
            line-height: 22px;
            margin: 12px 0px;
        }

        .content img {
            width: 100%;
        }
    </style>

</head>

<body class="drawer drawer--right">


<div class="header">

    <div class="hdtop clearfix">
        <span class="hdtopl">
            <img src="<%=basePath%>contact/logo.png" class="logo">
        </span>
        <span class="hdtopr">联系我们</span>
    </div>

</div>

<div class="content">

    <div class="hdtopr" style="color:red;font-size: 24px; font-weight: bold; margin-bottom: 28px;text-align:center">
        <strong>
            提交成功，请等待后台匹配！
        </strong>
    </div>

    <div style="text-align: center">
        <a id="reback" class="btn btn-primary" href="${backUrl}">点击返回主页面</a>
    </div>

    <div style="font-size: 24px; font-weight: bold; margin-bottom: 18px;">上海鑫漾网络科技有限公司</div>
    <div><strong>客服电话：</strong>021-50208660</div>
    <div><strong>邮箱：</strong>1406720454@qq.com</div>
    <div><strong>地址：</strong>上海市浦东新区世纪大道1568号中建大厦18层</div>
    <div><strong>网址：</strong>http:/www.shxindouyun.com</div>
    <div><img src="<%=basePath%>contact/ercode.jpg">
        <div style="text-align: center;">微信公众号</div>
    </div>
</div>

<div class="footer">京ICP证030173号</div>
<script src="<%=basePath%>contact/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>contact/popper.min.js"></script>
<script src="<%=basePath%>contact/bootstrap.min.js"></script>
<script src="<%=basePath%>contact/iscroll.min.js"></script>
<script src="<%=basePath%>contact/drawer.min.js"></script>
<script>
    $(function () {
        var url = document.location.toString();
        var arrUrl = url.split("=");
        var paras = arrUrl[1];
        var par =decodeURIComponent(paras)
        $("#reback").attr('href', par);
    });
</script>


<div class="drawer-overlay drawer-toggle"></div>
</body>
</html>