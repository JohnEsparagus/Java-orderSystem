<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>All Patient Data</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h1>All Patient Data</h1>
    <%
        System.out.println("check");
        List<Map<String, String>> allPatientData = (List<Map<String, String>>) request.getAttribute("allPatientData");
        if (!allPatientData.isEmpty()) {
    %>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>BIRTHDATE</th>
            <th>DEATHDATE</th>
            <th>SSN</th>
            <th>DRIVERS</th>
            <th>PASSPORT</th>
            <th>PREFIX</th>
            <th>FIRST</th>
            <th>LAST</th>
            <th>SUFFIX</th>
            <th>MAIDEN</th>
            <th>MARITAL</th>
            <th>RACE</th>
            <th>ETHNICITY</th>
            <th>GENDER</th>
            <th>BIRTHPLACE</th>
            <th>ADDRESS</th>
            <th>CITY</th>
            <th>STATE</th>
            <th>ZIP</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Map<String, String> patient : allPatientData) {
        %>
        <tr>
            <td><%= patient.get("ID") %></td>
            <td><%= patient.get("BIRTHDATE") %></td>
            <td><%= patient.get("DEATHDATE") %></td>
            <td><%= patient.get("SSN") %></td>
            <td><%= patient.get("DRIVERS") %></td>
            <td><%= patient.get("PASSPORT") %></td>
            <td><%= patient.get("PREFIX") %></td>
            <td><%= patient.get("FIRST") %></td>
            <td><%= patient.get("LAST") %></td>
            <td><%= patient.get("SUFFIX") %></td>
            <td><%= patient.get("MAIDEN") %></td>
            <td><%= patient.get("MARITAL") %></td>
            <td><%= patient.get("RACE") %></td>
            <td><%= patient.get("ETHNICITY") %></td>
            <td><%= patient.get("GENDER") %></td>
            <td><%= patient.get("BIRTHPLACE") %></td>
            <td><%= patient.get("ADDRESS") %></td>
            <td><%= patient.get("CITY") %></td>
            <td><%= patient.get("STATE") %></td>
            <td><%= patient.get("ZIP") %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>No patients found.</p>
    <% } %>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>