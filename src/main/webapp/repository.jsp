<%@ page import="com.ydsp.util.SpringContextUtils" %>
<%@ page import="com.ydsp.repository.UserRepository" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String type = request.getParameter("type");
    String name = request.getParameter("name");

    Map<String, Class> map = new HashMap<String, Class>();
    map.put("user", UserRepository.class);

    Class clazz = map.get(type);
    if (clazz != null) {
        Object repository = SpringContextUtils.getBean(clazz);
        Method method = clazz.getMethod(name);
        if (method != null && repository != null) {
            method.invoke(repository);
        }
    }

%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
