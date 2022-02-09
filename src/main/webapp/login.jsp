<%--
  Created by IntelliJ IDEA.
  User: sms
  Date: 2022/1/12
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>登录</title>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<form action="/LoginCheck" method="POST">
    账号：<input type="text" name="id" /><br/>
    密码：<input type="password" name="password" /><br/>
    <input type="radio" id="radio-1" name="type" checked value="1" />
    <label>乘客</label>
    <input type="radio" id="radio-2" name="type" value="2" />
    <label>司机</label>
    <input type="radio" id="radio-3" name="type" value="3" />
    <label>管理员</label>

    <input type="submit" name="login" value="登录" />
</form>

</body>
<script type="text/javascript">
    $(function() {
        //给获取位置按钮注册事件
        $("input[name='login']").bind('click', function () {
            //获取起始位置

            var id  = $("input[name='id']").val();
            //获取结束位置
            var  password = $("input[name='password']").val();
            if (id != '' && password != '') {

            } else {
                alert('未填写完整');
            }
        })
    });
        //ip定位，精度为城市级别






</script>
</html>