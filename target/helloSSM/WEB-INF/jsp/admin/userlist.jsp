<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body>


<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">

                        <div class="layui-input-inline layui-show-xs-block">
                            <select name="contrller">
                                <option>信用贷款</option>
                                <option>抵押贷款</option>
                                <option>企业贷款</option>
                            </select>
                        </div>
                        <div class="layui-input-inline lafite_search layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                查询
                            </button>
                        </div>
                    </form>
                </div>

                <div class="layui-card-header">
                    <a class="layui-btn lafite_main_color" onclick="xadmin.open('新增用户','./showUser.jsp',600,500)"><i
                            class="layui-icon"></i>新增用户</a>
                </div>

                <div class="layui-card-body">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr style="background: #F8E5E5;">
                            <th>编号</th>
                            <th>用户编号</th>
                            <th>用户称呼</th>
                            <th>手机</th>
                            <th>类型</th>
                            <th>公司成立期限(年)</th>
                            <th>占股比例(%)</th>
                            <th>公司近一年开票金额(万)</th>
                            <th>公司近一年纳税金额(万)</th>
                            <th>社保</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.userList}" var="u">
                            <tr>
                                <td>${u.companyLoanId}</td>
                                <td>${u.userId}</td>
                                <td>${u.name1}</td>
                                <td>${u.phone}</td>
                                <td>${u.identity}</td>
                                <td>${u.fund}</td>
                                <td>${u.companyYears}</td>
                                <td>${u.stockPer}</td>
                                <td>${u.invoiceFee}</td>
                                <td>${u.taxFee}</td>
                                <td>${u.addTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div id="lafite_pages"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script>layui.use(['laypage', 'laydate', 'form'],
    function () {
        var laydate = layui.laydate;
        var laypage = layui.laypage;

        // 分页样式
        laypage.render({
            elem: 'lafite_pages'
            , count: 100
            , theme: '#D91715',
            jump: function (obj) {
                //模拟渲染
                console.log(obj);
            }
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

/*用户-删除*/
function member_del(obj, id) {
    layer.confirm('是否确认删除当前项目？',
        {title: "项目删除"},
        function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {
                icon: 1,
                time: 1000
            });
        });
}

/*用户-撤销*/
function member_revoke(obj, id) {
    layer.confirm('确认冻结吗？',
        {title: "用户冻结"},
        function (index) {
            //发异步删除数据
            // $(obj).parents("tr").remove();
            // layer.msg('已删除!', {
            //     icon: 1,
            //     time: 1000
            // });
        });
}

</script>

</html>