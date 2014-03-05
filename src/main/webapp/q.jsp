<%@ page import="com.ydsp.repository.QueryRepository" %>
<%@ page import="com.ydsp.util.SpringContextUtils" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="com.ydsp.domain.Query" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<%
    String keyword = request.getParameter("k");
    String cb = request.getParameter("cb");
    keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");

    if (!StringUtils.isEmpty(keyword)) {
        QueryRepository repository = SpringContextUtils.getBean(QueryRepository.class);
        repository.save(new Query(keyword, new Date()));
    }

    if (cb == null) {
        cb = "callback";
    }

%>

<%=cb%> && <%=cb%>("<%=keyword%>");
