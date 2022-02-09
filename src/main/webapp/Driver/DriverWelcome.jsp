<%--
  Created by IntelliJ IDEA.
  User: sms
  Date: 2022/1/9
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>


</head>
<body>
<% String id=request.getParameter("id");  %>
<div id="container">
    <div id="top" style="text-align: center"> 快快打车司机版</div>
    <div id="left">

        <ul id="tabs_nav" >

            <li  ><a href="1.html?id=<%=id%>"   target="mainFrame" >开始营运</a></li>
            <li  list-style: none;><a href="2.html?id=<%=id%>"   target="mainFrame">结束营运</a></li>
            <li  list-style: none;><a href="3.html?id=<%=id%>"    target="mainFrame">查看订单</a></li>
            <li  list-style: none;><a href="4.html?id=<%=id%>"   target="mainFrame">个人中心</a></li>

        </ul>


    </div>
    <div id="main">   <iframe name="mainFrame" class="Iframe" style="width: 100%; height: 100%;" src="1.html?id=<%=id%>">> </iframe></div>
    <div id="footer"></div>
</div>



<style type="text/css">
    body { margin: 0; }
    #container {
        width: 100%;
        height:100%
    ;
        margin: 0px ;
        background-color: #CCC;
    }
    #top {
        width: 100%;
        height: 3%;
        background-color: #0F6;
    }
    #left {
        width: 10%;
        height: 90%;
        background-color:   #3A3D3A ;
        float: left;

    }
    #main {
        width: 90%;
        height: 90%;
        background-color: #660;
        float: right;
    }
    #footer {
        width: 100%;
        height: 7%;
        background-color: #C93;
        clear: both;
    }
    #tabs_nav{

        list-style-type: none;
    }
    #tabs_nav li{
        width:100%;
        height: 8%;
        text-align: center
    }
    a:link,a:visited {
        /*去掉a标签链接的下划线的效果*/
        text-decoration: none;
    }

    .cur{
        background: yellow!important;

    }

</style>

</body>

<script type="text/javascript" >



    $('#tabs_nav') .find('a').click(function() {

// 为当前点击的导航加上高亮，其余的移除高亮


        $(this). parents('li').  addClass('cur');
        $(this)  .parents('li').siblings(). removeClass('cur');


    });



</script>


</html>