<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReadExcelDemo</title>
</head>
<body>
  <h1>Your excel file is here!</h1>
  <table>
    <tr>
      <th>Column 1</th>
      <th>Column 2</th>
      <th>Column 3</th>
      <th>Column 4</th>
      <th>Column 5</th>
      <th>Column 6</th>
      <th>Column 7</th>
      <th>Column 8</th>
    </tr>
    <c:forEach items="${rows}" var="row">
      <tr>
        <c:forEach items="${row}" var="cell">
          <td>${cell}</td>
        </c:forEach>
      </tr>
    </c:forEach>
  </table>
</body>
</html>