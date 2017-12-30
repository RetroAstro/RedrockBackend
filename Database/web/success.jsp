<%--
  Created by IntelliJ IDEA.
  User: DN
  Date: 2017/12/27
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<html>
<head>
</head>
<body>
<h1>您想要查找的文件 <% out.print((String) request.getAttribute("name")); %> 的具体文件信息有：</h1>
<div>
    <%
        List<Map<String, String>> info = (List) request.getAttribute("result");
        for(Map<String, String> map : info) {
            for(Map.Entry<String, String> entry : map.entrySet()){
                out.print(entry.getKey() + ";" + entry.getValue() + "</br>");
            }
        }
    %>
</div>
</body>
</html>
