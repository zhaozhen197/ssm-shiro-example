<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>



<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="../../../admin/css/font.css">
        <link rel="stylesheet" href="../../../admin/css/xadmin.css">
        <script type="text/javascript" src="../../../admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="../../../admin/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

    request:${requestScope.userList}<br/>
    <c:forEach items="${requestScope.userList }" var="u">
        ${u.phone }-${u.name2 }-${u.userId2 }<br/>
    </c:forEach>
        <div class="layui-fluid lafite_add_alert">
            <div class="layui-row">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span> 用户名
                        </label> 
                        <div class="layui-input-block lafite_width_60">
                            <input type="text" id="L_email" name="email" required lay-verify="required" autocomplete="off" class="layui-input"></div>
                        <!-- <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>将会成为您唯一的登入名
                        </div> -->
                        </div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span> 手机号码
                        </label>
                        <div class="layui-input-block lafite_width_60">
                            <input type="text" id="L_username" name="username" required="" lay-verify="nikename" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_pass" class="layui-form-label">
                            <span class="x-red">*</span> 密码</label>
                        <div class="layui-input-block lafite_width_60">
                            <input type="password" id="L_pass" name="pass" required="" lay-verify="pass" autocomplete="off" class="layui-input"></div>
                        </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span> 确认密码</label>
                        <div class="layui-input-block lafite_width_60">
                            <input type="password" id="L_repass" name="repass" required="" lay-verify="repass" autocomplete="off" class="layui-input"></div>
                    </div>

                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span> 角色</label>
                        <div class="layui-input-block lafite_width_60">
                            <select name="city" lay-verify="required">
                                <option value=""></option>
                                <option value="0" selected>管理员</option>
                                <option value="1">上海</option>
                                <option value="2">广州</option>
                                <option value="3">深圳</option>
                                <option value="4">杭州</option>
                            </select>    
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            备注
                        </label>
                        <div class="layui-input-block lafite_width_60">
                            <textarea name="desc" placeholder="请输入内容" class="layui-textarea lafite_textarea lafite_min_height_80px"></textarea>    
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                        <div class="lafite-layui-btn lafite_float_left lafite_height_35px" onclick="xadmin.close()">取消</div>
                        <button lay-submit lay-filter="formDemo" class="lafite-layui-btn2 lafite_margin_left_10 lafite_height_35px">保存</button>
                        </div>
                    </div>

                    <!-- <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">增加</button></div> -->
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //自定义验证规则
                form.verify({
                    nikename: function(value) {
                        if (value.length < 5) {
                            return '昵称至少得5个字符啊';
                        }
                    },
                    pass: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#L_pass').val() != $('#L_repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });

                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    layer.alert("增加成功", {
                        icon: 6
                    },
                    function() {
                        //关闭当前frame
                        xadmin.close();

                        // 可以对父窗口进行刷新 
                        xadmin.father_reload();
                    });
                    return false;
                });
            });
        </script>
    </body>

</html>