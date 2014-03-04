<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script>
//        $.getJSON('users', function(data){
//            console.log(data);
//        })

        $.post('users?{"name":"zhangsan"}')

    </script>
</head>
<body>

</body>
</html>
