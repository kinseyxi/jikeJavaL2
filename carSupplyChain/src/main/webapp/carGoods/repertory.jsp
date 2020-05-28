<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>第一个 ECharts 实例</title>
    <!-- 引入 echarts.js -->
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
    <script src="../js/jquery-1.8.2.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>

<div id="main1" style="width: 600px;height:400px;"></div>
<script type="text/javascript">

    $().ready(function () {
        $.ajax({
            url:"/cargoods/statisticsOrderdetails",
            dataType:"JSON",
            type:"get",
            success:function (data) {
                var xdata=[];
                var ydata=[];
                var yydata=[];
                 var echartData=data;
                for (var i=0;i<echartData.length;i++){
                    xdata.push(echartData[i].goodsname)
                    console.log(xdata);
                    ydata.push(echartData[i].price)
                    yydata.push({value:echartData[i].num, name:echartData[i].goodsname})
                }

                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '商品和营业额柱状图'
                    },
                    tooltip: {},
                    legend: {
                        data:['营业额(元)']
                    },
                    xAxis: {
                        data: xdata
                        // data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    },
                    yAxis: {},
                    series: [{
                        name: '数量',
                        type: 'bar',
                        // data: [5, 20, 36, 10, 10, 20]
                        data:ydata
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);


                var myChart = echarts.init(document.getElementById('main1'));
                option = {
                    title : {
                        text: '商品和下单数量饼状图',       //大标题
                        subtext: '下单数量',                //类似于副标题
                        x:'center'                 //标题位置   居中
                    },
                    tooltip : {
                        trigger: 'item',           //数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
                        formatter: "{a} <br/>{b} : {c} ({d}%)"   //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）用于鼠标悬浮时对应的显示格式和内容
                    },
                    legend: {                           //图例组件。
                        orient: 'vertical',             //图例列表的布局朝向
                        left: 'left',
                        data: xdata
                    },
                    series : [              //系列列表。每个系列通过 type 决定自己的图表类型
                        {
                            name: '下单详情',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:yydata,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                myChart.setOption(option);





            }
        });
    });







</script>

</body>
</html>