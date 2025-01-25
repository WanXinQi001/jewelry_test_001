<%--
  Created by IntelliJ IDEA.
  User: 26647
  Date: 2025/1/23
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>500 - 服务器内部错误</title>
    <style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-box {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #d9534f;
            font-size: 50px;
            margin-bottom: 15px;
        }

        p {
            color: #555;
            font-size: 18px;
            margin-bottom: 25px;
        }

        a {
            background-color: #5cb85c;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #4cae4c;
        }
    </style>
</head>

<body>
<div class="error-box">
    <h1>500</h1>
    <p>很抱歉，服务器似乎出现了一些问题，请稍后再试。</p>
    <button onclick="goHome()">返回首页</button>
</div>
<script>
    function goHome() {
        window.location.href = '../index.jsp';
    }
</script>
</body>

</html>