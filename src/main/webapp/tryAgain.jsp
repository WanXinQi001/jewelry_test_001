<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加失败</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            text-decoration: none;
            color: black;
        }
        body{
            display: flex;
            justify-content: center;
            align-content: center;
        }
        a{
            color: blue;
        }
    </style>
</head>
<body>

<div>
    ${error}
    <p id ="page_div"></p>
</div>


<script>
    var num = 4;
    var URL = "/center/staffLogin";
    setTimeout("doUpdate()", 1000);
    function doUpdate(){
        if(num != 0){
            document.getElementById('page_div').innerHTML = '将在'+num+'秒后自动跳转到'+'<a href="${address}">其他页面</a>' ;
            num --;
            window.setTimeout("doUpdate()", 1000);
        }else{
            num = 4;
            window.location = "${address}";
        }
    }
</script>
</body>
</html>
