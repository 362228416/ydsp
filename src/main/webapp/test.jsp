<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script>
        //        $.getJSON('users', function(data){
        //            console.log(data);
        //        })

        $.getJSON("http://query.yahooapis.com/v1/public/yql", {
            q: "select * from json where url=\"http://m.weather.com.cn/data/101010100.html\"",
            format: "json"
        }, function (data) {
            var $content = $("#content")
            if (data.query.results) {
                $content.text(JSON.stringify(data.query.results));
            } else {
                $content.text('no such code: ' + code);
            }
        })



    </script>
</head>
<body>

</body>
</html>
