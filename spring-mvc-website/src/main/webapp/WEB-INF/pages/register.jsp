<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form:form action="${pageContext.request.contextPath}/test" method="post" modelAttribute ="user">
         Name <input type="text" title="Please enter User Name" placeholder="Please enter User Name" name="Name" />
         
Course <select name="Course" id="singleCourse">
     <option value ="os" >OS</option>
     <option value="java">Java</option>
     <option value="JavaScript">JavaScript</option>
     <option value="SQL">SQL</option>
</select>
      Fee <input type="number" min="100" title="Please enter the Fee" placeholder="Please enter the Fee" name="Fee" />
      Year <input type="number" min="2017" title="Please enter the Year" placeholder="Please enter the Year" name="Year" />
      <button type="submit" class="btn">Submit</button>      
        </form:form>
    </body>
</html>