<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form action="http://localhost:8080/spring-mvc-website/test" method = >
         Name <input type="text" title="Please enter User Name" placeholder="Please enter User Name" name="Name" />
         
Course <select name="Course" id="singleCourse">
     <option value ="java" >Java</option>
     <option value="android">Android</option>
     <option value="AJS">Angular Java Script</option>
     <option value="MVC">Spring MVC</option>
</select>
      Fee <input type="number" min="100" title="Please enter the Fee" placeholder="Please enter the Fee" name="Fee" />
      Year <input type="number" min="2017" title="Please enter the Year" placeholder="Please enter the Year" name="Year" />
      <button type="submit" class="btn">Submit</button>      
        </form>
    </body>
</html>