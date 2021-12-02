<%-- 
    Document   : View
    Created on : Dec 2, 2021, 3:14:06 PM
    Author     : nemishappy
--%>

<%@page import="java.util.List"%>
<%@page import="controller.StudentTable"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <h1>List Student</h1>
        
        <br/>
        <%
            List<Student> StudentList = StudentTable.findAllStudent();
            if (StudentList.size() > 0) {
                for (Student stud : StudentList) {
                    out.print(stud.getId() + " ");
                    out.print(stud.getVaccine1()+ " ");
                    out.print(stud.getVaccine2() + " ");
                    out.print(stud.getVaccine3() + " ");
                    out.print("<br/>");
                }
            } else {
                out.println("No Data");
            }
        %>
    </body>
</html>
