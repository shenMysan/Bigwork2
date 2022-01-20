<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=pWRv3QqWl9q9jBgnFXReIexB4szv3jD0"></script>
    <title>地图展示</title>
</head>
<body>



<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
    //var marker = new BMap.Marker(point); //创建marker对象
    //marker.enableDragging(); //marker可拖拽
    //map.addOverlay(new BMap.Marker(new BMap.Point(107.48077,31.21341)));
    /* ,{icon:new BMap.Icon("图片路径",new BMap.Size(25,25))} */

    // 百度地图API功能
    var map = new BMap.Map("allmap"); // 创建Map实例
    var point = new BMap.Point(107.48077,31.21341);
    map.centerAndZoom(point, 15);// 初始化地图,设置中心点坐标和地图级别11 12 13 14 15
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl({
        mapTypes:[
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]}));
    var marker = new BMap.Marker(point);  // 创建标注.创建marker对象
    map.addOverlay(marker);               // 将标注添加到地图中

    map.addEventListener("click", function(e){
        alert('经度:'+e.point.lng+' , 纬度: '+e.point.lat);
        var now_point = new BMap.Point(e.point.lng, e.point.lat );
        marker.setPosition(now_point);//设置覆盖物位置
    });

    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    marker.enableDragging(); //marker可拖拽
    map.setCurrentCity("四川");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
</script>
