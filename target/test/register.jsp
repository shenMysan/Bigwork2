<%--
  Created by IntelliJ IDEA.
  User: sms
  Date: 2022/1/18
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</head>
<script >


    function    check() {
        var id  =document.getElementById('id').value;

        var name  = document.getElementById('name').value;
        var  password = document.getElementById('password').value;

        //给获取位置按钮注册事件

        //获取起始位置
        // id !=null && password !=null&& name!=null&&

        if (id !="" && password !=""&& name !="") {
            return true;
        } else {
            alert('未填写完整');
            return  false;
        }
    }



</script>
<body>




<form action="/Register" method="POST" onsubmit="return check();">
    账号：<input   type="text"  id="id" name="id" /><br/>
    姓名：<input type="text"  id="name" name="name" /><br/>
    密码：<input type="password"  id="password" name="password" /><br/>
    <input type="radio" id="radio-1" name="type" checked value="1" />
    <label>乘客</label>
    <input type="radio" id="radio-2" name="type" value="2" />
    <label>司机</label>


    <input type="submit"  name =“register“ value="注册" />
</form>



</body>


</html>
