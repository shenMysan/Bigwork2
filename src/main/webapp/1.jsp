<%--
  Created by IntelliJ IDEA.
  User: sms
  Date: 2022/1/7
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <style type="text/css">
    body,
    html,
    #allmap {
      width: 500px;
      height: 500px;
      overflow: hidden;
      margin: 0;
      font-family: "微软雅黑";
    }
  </style>
  <script   src="//api.map.baidu.com/api?v=1.0&type=webgl&ak=gMYlsmilhib78x9uBG2OjYGvWtsSBpDC&s=1"></script>
  <title>地图展示</title>
</head>

<body>
<div id="allmap"></div>
</body>
<script >
  // 百度地图API功能
  alert("开始定位")
  var map = new BMap.Map("allmap"); // 创建Map实例
  map.centerAndZoom(new BMap.Point(116.404, 39.915), 11); // 初始化地图,设置中心点坐标和地图级别
  //添加地图类型控件
  map.addControl(new BMap.MapTypeControl({
    mapTypes: [
      BMAP_NORMAL_MAP,
      BMAP_HYBRID_MAP
    ]
  }));
  map.setCurrentCity("北京"); // 设置地图显示的城市 此项是必须设置的
  map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
</script>

</html>
