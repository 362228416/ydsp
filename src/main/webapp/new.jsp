<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name");
    String content = request.getParameter("content");
    boolean create = false;
    if (request.getMethod().equals("POST")) {
        if (!StringUtils.isEmpty(name)) {

            String realPath = application.getRealPath(name);
            File file = new File(realPath);

            // 如果有目录则创建目录
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
            create = true;
        }
    }
    if (name == null) {
        name = "";
    }
    if (content == null) {
        content = "";
    }
%>
<html>
<head>
    <meta charset="utf-8">
    <title>new file</title>
</head>
<body>
    <%
        if (create) {

    %>
        create success.
    <%
        }
    %>
    <form method="post">
        file name:<input name="name" value="<%=name%>"><br/>
        content:&nbsp;&nbsp;<textarea name="content" style="width: 600px; height: 400px"><%=content%></textarea>
        <input type="submit" value="create">
    </form>
</body>
</html>
