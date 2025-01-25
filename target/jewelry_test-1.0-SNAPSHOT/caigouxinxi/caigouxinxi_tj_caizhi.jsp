<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.YearMonth" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>采购数量统计（按日、月、年）</title>
    <script src="../echarts.min.js"></script>
</head>
<body>
<!-- 按日统计图表 -->
<h2>按日采购数量统计</h2>
<div id="dailyChart" style="width:100%;height:480px"></div>
<!-- 按月统计图表 -->
<h2>按月采购数量统计</h2>
<div id="monthlyChart" style="width:100%;height:480px"></div>
<!-- 按年统计图表 -->
<h2>按年采购数量统计</h2>
<div id="yearlyChart" style="width:100%;height:480px"></div>

<%
    // 按日统计
    // 获取当前月份
    YearMonth currentYearMonth = YearMonth.now();
    int year1 = currentYearMonth.getYear();
    int month1 = currentYearMonth.getMonthValue();

    // 获取当天日期
    LocalDate today = LocalDate.now();
    String todayStr = today.toString();

    // 按日统计，添加筛选条件只查询当月数据
    String dailySql = "SELECT caizhi,  COUNT(caizhi) as bbb, DATE_FORMAT(caigouriqi, '%Y-%m-%d') as date " +
            "FROM caigouxinxi " +
            "WHERE YEAR(caigouriqi) =? AND MONTH(caigouriqi) =? " +
            "GROUP BY caizhi, DATE_FORMAT(caigouriqi, '%Y-%m-%d')";
    PreparedStatement pstmt = connDbBean.getConnection().prepareStatement(dailySql);
    pstmt.setInt(1, year1);
    pstmt.setInt(2, month1);
    ResultSet dailyRS = pstmt.executeQuery();

    // 存储按日统计的数据，键为日期，值为商品名称和销售数量的映射
    Map<String, Map<String, Integer>> dailyDataMap = new HashMap<>();
    while (dailyRS.next()) {
        String date = dailyRS.getString("date");
        String productName = dailyRS.getString("caizhi");
        int count = dailyRS.getInt("bbb");

        Map<String, Integer> productCountMap = dailyDataMap.get(date);
        if (productCountMap == null) {
            productCountMap = new HashMap<>();
            dailyDataMap.put(date, productCountMap);
        }
        productCountMap.put(productName, count);
    }

    // 生成按日统计的 Echarts 数据
    StringBuilder dailyDates = new StringBuilder();
    StringBuilder dailySeriesData = new StringBuilder();
    for (Map.Entry<String, Map<String, Integer>> entry : dailyDataMap.entrySet()) {
        String date = entry.getKey();
        Map<String, Integer> productCountMap = entry.getValue();

        dailyDates.append("'").append(date).append("',");

        StringBuilder seriesData = new StringBuilder();
        for (Map.Entry<String, Integer> productEntry : productCountMap.entrySet()) {
            String productName = productEntry.getKey();
            int count = productEntry.getValue();
            seriesData.append("{value: ").append(count).append(", name: '").append(productName).append("'},");
        }
        if (seriesData.length() > 0) {
            seriesData.deleteCharAt(seriesData.length() - 1);
        }
        dailySeriesData.append("{name: '").append(date).append("', type: 'pie', radius: 150, center: ['50%', '50%'], data: [").append(seriesData).append("]},");
    }
    if (dailyDates.length() > 0) {
        dailyDates.deleteCharAt(dailyDates.length() - 1);
    }
    if (dailySeriesData.length() > 0) {
        dailySeriesData.deleteCharAt(dailySeriesData.length() - 1);
    }

    // 按月统计
    String monthlySql = "SELECT caizhi, COUNT(caizhi) as bbb, DATE_FORMAT(caigouriqi, '%Y-%m') as month " +
            "FROM caigouxinxi " +
            "GROUP BY caizhi, DATE_FORMAT(caigouriqi, '%Y-%m')";
    ResultSet monthlyRS = connDbBean.executeQuery(monthlySql);

    // 存储按月统计的数据，键为月份，值为商品名称和销售数量的映射
    Map<String, Map<String, Integer>> monthlyDataMap = new HashMap<>();
    while (monthlyRS.next()) {
        String month = monthlyRS.getString("month");
        String productName = monthlyRS.getString("caizhi");
        int count = monthlyRS.getInt("bbb");

        Map<String, Integer> productCountMap = monthlyDataMap.get(month);
        if (productCountMap == null) {
            productCountMap = new HashMap<>();
            monthlyDataMap.put(month, productCountMap);
        }
        productCountMap.put(productName, count);
    }

    // 生成按月统计的 Echarts 数据
    StringBuilder monthlyMonths = new StringBuilder();
    StringBuilder monthlySeriesData = new StringBuilder();
    for (Map.Entry<String, Map<String, Integer>> entry : monthlyDataMap.entrySet()) {
        String month = entry.getKey();
        Map<String, Integer> productCountMap = entry.getValue();

        monthlyMonths.append("'").append(month).append("',");

        StringBuilder seriesData = new StringBuilder();
        for (Map.Entry<String, Integer> productEntry : productCountMap.entrySet()) {
            String productName = productEntry.getKey();
            int count = productEntry.getValue();
            seriesData.append("{value: ").append(count).append(", name: '").append(productName).append("'},");
        }
        if (seriesData.length() > 0) {
            seriesData.deleteCharAt(seriesData.length() - 1);
        }
        monthlySeriesData.append("{name: '").append(month).append("', type: 'pie', radius: 150, center: ['50%', '50%'], data: [").append(seriesData).append("]},");
    }
    if (monthlyMonths.length() > 0) {
        monthlyMonths.deleteCharAt(monthlyMonths.length() - 1);
    }
    if (monthlySeriesData.length() > 0) {
        monthlySeriesData.deleteCharAt(monthlySeriesData.length() - 1);
    }

    // 按年统计
    String yearlySql = "SELECT caizhi,  COUNT(caizhi) as bbb, DATE_FORMAT(caigouriqi, '%Y') as year " +
            "FROM caigouxinxi " +
            "GROUP BY caizhi, DATE_FORMAT(caigouriqi, '%Y')";
    ResultSet yearlyRS = connDbBean.executeQuery(yearlySql);

    // 存储按年统计的数据，键为年份，值为商品名称和销售数量的映射
    Map<String, Map<String, Integer>> yearlyDataMap = new HashMap<>();
    while (yearlyRS.next()) {
        String year = yearlyRS.getString("year");
        String productName = yearlyRS.getString("caizhi");
        int count = yearlyRS.getInt("bbb");

        Map<String, Integer> productCountMap = yearlyDataMap.get(year);
        if (productCountMap == null) {
            productCountMap = new HashMap<>();
            yearlyDataMap.put(year, productCountMap);
        }
        productCountMap.put(productName, count);
    }

    // 生成按年统计的 Echarts 数据
    StringBuilder yearlyYears = new StringBuilder();
    StringBuilder yearlySeriesData = new StringBuilder();
    for (Map.Entry<String, Map<String, Integer>> entry : yearlyDataMap.entrySet()) {
        String year = entry.getKey();
        Map<String, Integer> productCountMap = entry.getValue();

        yearlyYears.append("'").append(year).append("',");

        StringBuilder seriesData = new StringBuilder();
        for (Map.Entry<String, Integer> productEntry : productCountMap.entrySet()) {
            String productName = productEntry.getKey();
            int count = productEntry.getValue();
            seriesData.append("{value: ").append(count).append(", name: '").append(productName).append("'},");
        }
        if (seriesData.length() > 0) {
            seriesData.deleteCharAt(seriesData.length() - 1);
        }
        yearlySeriesData.append("{name: '").append(year).append("', type: 'pie', radius: 150, center: ['50%', '50%'], data: [").append(seriesData).append("]},");
    }
    if (yearlyYears.length() > 0) {
        yearlyYears.deleteCharAt(yearlyYears.length() - 1);
    }
    if (yearlySeriesData.length() > 0) {
        yearlySeriesData.deleteCharAt(yearlySeriesData.length() - 1);
    }
%>

<script type="text/javascript">

    var dailyChart = echarts.init(document.getElementById('dailyChart'));
    window.onresize = dailyChart.resize;

    var allDates = [<%=dailyDates.toString()%>];
    var allSeriesData = [<%=dailySeriesData.toString()%>];

    // 找到当天日期在图例中的索引
    var todayIndex = -1;
    for (var i = 0; i < allDates.length; i++) {
        if (allDates[i] === '<%=todayStr%>') {
            todayIndex = i;
            break;
        }
    }

    // 构建图例数据和选择状态对象
    var legendData = [];
    var legendSelected = {};
    for (var j = 0; j < allDates.length; j++) {
        legendData.push(allDates[j]);
        legendSelected[allDates[j]] = j === todayIndex;
    }

    var dailyOption = {
        title: {
            text: '按日采购数量统计',
            left: 'center'
        },
        tooltip: {},
        legend: {
            data: legendData,
            right: 10,
            selected: legendSelected
        },
        series: allSeriesData
    };

    dailyChart.setOption(dailyOption);


    // 按月统计图表配置
    var monthlyChart = echarts.init(document.getElementById('monthlyChart'));
    window.onresize = monthlyChart.resize;
    var monthlyOption = {
        title: {
            text: '按月采购数量统计'
        },
        tooltip: {},
        legend: {
            data: [<%=monthlyMonths.toString()%>]
        },
        series: [
            <%=monthlySeriesData.toString()%>
        ]
    };
    monthlyChart.setOption(monthlyOption);

    // 按年统计图表配置
    var yearlyChart = echarts.init(document.getElementById('yearlyChart'));
    window.onresize = yearlyChart.resize;
    var yearlyOption = {
        title: {
            text: '按年采购数量统计'
        },
        tooltip: {},
        legend: {
            data: [<%=yearlyYears.toString()%>]
        },
        series: [
            <%=yearlySeriesData.toString()%>
        ]
    };
    yearlyChart.setOption(yearlyOption);
</script>
</body>
</html>