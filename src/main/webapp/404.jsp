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
    <title>404 - 页面未找到</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .error-container {
            text-align: center;
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            font-size: 60px;
            margin-bottom: 20px;
        }

        p {
            color: #666;
            font-size: 20px;
            margin-bottom: 30px;
        }

        a {
            display: inline-block;
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
<div class="error-container">
    <h1>404</h1>
    <p>抱歉，你访问的页面不存在。</p>
    <a href="../main.jsp">返回首页</a>
</div>
</body>

</html>