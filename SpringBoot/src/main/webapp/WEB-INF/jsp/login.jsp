
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Login page</title>
<style>


</style>
<div class="wrapper fadeInDown">
  <div id="formContent">
   <div class="fadeIn first">
      <h2>Login Page</h2>
    </div>
    <!-- Tabs Titles -->
<c:if test="${param.error != null}">
   <div class="fadeIn first">
      <h2>Invalid user name and password</h2>
    </div>
    </c:if>
    <c:if test="${param.logout != null}">
   <div class="fadeIn first">
      <h2>you have been logged out</h2>
    </div>
    </c:if>
    <!-- Login Form -->
    <form:form action="/login" method="POST">
      *Username:  <input type="text" id="username" class="fadeIn second" name="username" placeholder="enter username"><br/><br/>
      *Password:  <input type="password" id="password" class="fadeIn third" name="password" placeholder="password"><br/><br/>
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form:form>
	<a href="showRegistration" >Create an account</a>
  </div>
</div>
  