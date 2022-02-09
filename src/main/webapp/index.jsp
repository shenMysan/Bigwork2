<%--
  Created by IntelliJ IDEA.
  User: sms
  Date: 2022/1/6
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>


</head>
<body>
<div id="container">
    <div id="top" style="text-align: center"> 网约车管理系统</div>
    <div id="left">

        <ul id="tabs_nav" >
            <li  ><a href="login.jsp" target="mainFrame" >登陆页面</a></li>
            <li ><a href="register.jsp" target="mainFrame">注册</a></li>

        </ul>


    </div>
    <div id="main">   <iframe name="mainFrame" id="Iframe" style="width: 100%; height: 100%;" src="login.jsp">> </iframe></div>
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


   // 使用了 jquery ，不使用的请自行修改为原生 js
   $(ducument).ready(function(){
       // 当页面加载完后判断页面内是否有 iframe
       if ($('iframe').length) {
           // 获取 iframe window对象的 document
           var ifr = $(window.frames[0].document);
           // 当 iframe document 加载完成是判断内容
           ifr.ready(function () {
               // 如果内容中包含 id=map的控件时，表示内容加载完成
               // 这里可以换成其他任意标签
               if (ifr.find('#map').length) {
                   // 因为我用的是 .net 的页面，所以 form 表单的高度基本就是页面高度了

               }
           });
       }
   });





</script>


</html>