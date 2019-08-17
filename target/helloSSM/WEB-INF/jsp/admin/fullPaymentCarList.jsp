<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title></title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath%>assets/materialize/css/materialize.min.css" media="screen,projection"/>
    <!-- Bootstrap Styles-->
    <link href="<%=basePath%>assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FontAwesome Styles-->
    <link href="<%=basePath%>assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- Morris Chart Styles-->
    <link href="<%=basePath%>assets/js/morris/morris-0.4.3.min.css" rel="stylesheet"/>
    <!-- Custom Styles-->
    <link href="<%=basePath%>assets/css/custom-styles.css" rel="stylesheet"/>
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="<%=basePath%>assets/js/Lightweight-Chart/cssCharts.css">
</head>


<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand waves-ef fect waves-dark" href="<%=basePath%>admin/allUserList"><i
                    class="large material-icons">insert_chart</i>
                <strong>后台管理</strong></a>
            <div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
        </div>
    </nav>

    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="<%=basePath%>admin/allUserList" class="  waves-effect waves-dark"><i
                            class="fa fa-dashboard"></i> 用户信息预览</a>
                </li>
                <li>
                    <a href="<%=basePath%>admin/fundList" class="waves-effect waves-dark"><i
                            class="fa fa-table"></i>
                        公积金用户</a>
                </li>
                <li>
                    <a href="#" id="identity" class="waves-effect waves-dark"><i class="fa fa-sitemap"></i>用户身份分类<span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=basePath%>admin/wageEarnerList">工薪族信息列表</a>
                        </li>
                        <li>
                            <a href="<%=basePath%>admin/bussinessOwnerList"  >企业主信息列表</a>
                        </li>

                        <li>
                            <a href="<%=basePath%>admin/personList" >个体户信息列表</a>
                        </li>

                        <li>
                            <a href="<%=basePath%>admin/otherList" >其他用户信息列表</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="waves-effect waves-dark"><i class="fa fa-fw fa-file"></i>住房用户分类<span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=basePath%>admin/fullPaymentHouseList" >全款房用户</a>
                        </li>
                        <li>
                            <a href="<%=basePath%>admin/mortgageHouseList">按揭房用户</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" id="car" class="active-menu waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i>汽车用户分类<span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=basePath%>admin/fullPaymentCarList" class="active-menu">全款车用户</a>
                        </li>
                        <li>
                            <a href="<%=basePath%>admin/mortgageCarList">按揭车用户</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="<%=basePath%>admin/insuranceList" class="waves-effect waves-dark"><i
                            class="fa fa-qrcode"></i> 保险用户信息</a>
                </li>

                <li>
                    <a href="<%=basePath%>admin/companyLoanList" class="waves-effect waves-dark"><i
                            class="fa fa-qrcode"></i>法人或股东用户</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div class="header">
            <h1 class="page-header">
                全款车用户
            </h1>
        </div>

        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="card">
                        <%--<div class="card-action">--%>
                            <%--Advanced Tables--%>
                        <%--</div>--%>
                        <div class="card-content">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables- ">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>所属用户</th>
                                        <th>用户称呼</th>
                                        <th>用户手机</th>
                                        <th>裸车价(万)</th>
                                        <th>车子年限</th>
                                        <th>提交时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    <c:forEach items="${requestScope.fullPaymentCarList}" var="u">

                                        <tr class="odd gradeX">
                                            <td>${u.fullPaymentCarId}</td>
                                            <td>${u.userId}</td>
                                            <td>${u.userName1}</td>
                                            <td>${u.userPhone}</td>
                                            <td>${u.carValue}</td>
                                            <td>${u.carYears}</td>
                                            <td>${u.formateTime(u.createTime)}</td>

                                        </tr>
                                    </c:forEach>
                                    <%--<tr class="odd gradeX">--%>
                                        <%--<td>Trident</td>--%>
                                        <%--<td>Internet Explorer 4.0</td>--%>
                                        <%--<td>Win 95+</td>--%>
                                        <%--<td class="center">4</td>--%>
                                        <%--<td class="center">X</td>--%>
                                        <%--<td>Trident</td>--%>
                                        <%--<td>Internet Explorer 4.0</td>--%>
                                        <%--<td>Win 95+</td>--%>
                                        <%--<td class="center">4</td>--%>
                                        <%--<td class="center">X</td>--%>
                                        <%--<td>Trident</td>--%>
                                        <%--<td>Internet Explorer 4.0</td>--%>
                                        <%--<td>Win 95+</td>--%>
                                        <%--<td class="center">4</td>--%>
                                        <%--<td class="center">X</td>--%>
                                        <%--<td>Trident</td>--%>
                                        <%--<td>Internet Explorer 4.0</td>--%>
                                        <%--<td>Win 95+</td>--%>
                                        <%--<td class="center">4</td>--%>
                                        <%--<td class="center">X</td>--%>
                                    <%--</tr>--%>

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

            <footer><p>Copyright &copy; 2016.Company name All rights reserved.</p></footer>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->

</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->


<!-- jQuery Js -->
<script src="<%=basePath%>assets/js/jquery-1.10.2.js"></script>

<!-- Bootstrap Js -->
<script src="<%=basePath%>assets/js/bootstrap.min.js"></script>

<script src="<%=basePath%>assets/materialize/js/materialize.min.js"></script>

<!-- Metis Menu Js -->
<script src="<%=basePath%>assets/js/jquery.metisMenu.js"></script>
<!-- Morris Chart Js -->
<script src="<%=basePath%>assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="<%=basePath%>assets/js/morris/morris.js"></script>


<script src="<%=basePath%>assets/js/easypiechart.js"></script>
<script src="<%=basePath%>assets/js/easypiechart-data.js"></script>

<script src="<%=basePath%>assets/js/Lightweight-Chart/jquery.chart.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="<%=basePath%>assets/js/dataTables/jquery.dataTables.js"></script>
<script src="<%=basePath%>assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    // $(document).ready(function () {
    //     $(".headerPage").load("header.jsp");
    //     // $('#dataTables-example').dataTable();
    // });


    // $(function () {
    //     $("#identity").onclick();
    // });
</script>
<!-- Custom Js -->
<script src="<%=basePath%>assets/js/custom-scripts.js"></script>


</body>

</html>
