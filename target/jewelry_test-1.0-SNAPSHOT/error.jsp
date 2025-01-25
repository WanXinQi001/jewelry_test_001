<%--
  Created by IntelliJ IDEA.
  User: 26647
  Date: 2025/1/23
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>错误页面</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-container {
            text-align: center;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #dc3545;
            font-size: 48px;
            margin-bottom: 20px;
        }

        p {
            color: #6c757d;
            font-size: 18px;
            margin-bottom: 30px;
        }

        button {
            background-color: #007bff;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
<div class="error-container">
    <h1>出错啦！</h1>
    <p>很抱歉，当前页面遇到了一些问题。请稍后重试，或者返回首页。</p>
    <button onclick="goHome()">返回首页</button>
</div>
<script>
    function goHome() {
        window.location.href = '../index.jsp';
    }
</script>
</body>

</html>