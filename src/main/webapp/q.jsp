<%@ page import="com.ydsp.repository.QueryRepository" %>
<%@ page import="com.ydsp.util.SpringContextUtils" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="com.ydsp.domain.Query" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String keyword = request.getParameter("k");

    if (!StringUtils.isEmpty(keyword)) {
        QueryRepository repository = SpringContextUtils.getBean(QueryRepository.class);
        repository.save(new Query(keyword, new Date()));
    }

%>
