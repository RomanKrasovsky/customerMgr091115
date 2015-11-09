<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Customer List</title>
  <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>

<a href="/" class="btn btn-link">Back</a>

<h3>Customers</h3>
<c:if test="${!empty List}">
  <table class="table table-hover">
    <tr>
      <th>Name</th>
      <th>Email</th>
      <th>Telephone</th>
      <th>id</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${List}" var="customer">
      <tr>
        <td>${customer.lastname}, ${customer.firstname} </td>
        <td>${customer.email}</td>
        <td>${customer.telephone}</td>
        <td>${customer.id}</td>
        <td><a href="delete/${customer.id}">delete</a></td>
        <td><a href="edit/${customer.id}">edit</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<form:form method="post" action="edit" commandName="customer" class="form-horizontal">
  <c:forEach items="${List}" var="customer">
  <fieldset>
    <legend>Customer Details</legend>
    <div class="form-group">
      <form:label class="col-lg-2 control-label" path="firstname">
        <spring:message code="label.firstname"/>
      </form:label>
      <div class="col-sm-3">
        <form:input path="firstname" placeholder="${customer.firstname}" value="${customer.firstname}"  cssClass="form-control"/>
      </div>
      <form:errors path="firstname" cssClass="error"/>
    </div>

    <div class="form-group">
      <form:label class="col-lg-2 control-label" path="lastname">
        <spring:message code="label.lastname"/>
      </form:label>
      <div class="col-sm-3">
        <form:input path="lastname" placeholder="${customer.lastname}"  value="${customer.lastname}" cssClass="form-control"/>
      </div>
      <form:errors path="lastname" cssClass="error"/>
    </div>
    <legend>Contact Details</legend>
    <div class="form-group">
      <form:label class="col-lg-2 control-label" path="email">
        <spring:message code="label.email"/>
      </form:label>
      <div class="col-md-3">
        <form:input path="email" placeholder="${customer.email}"  value="${customer.email}" cssClass="form-control"/>
      </div>
      <form:errors path="email" cssClass="error"/>
    </div>
    <div class="form-group">
      <form:label class="col-lg-2 control-label" path="telephone">
        <spring:message code="label.telephone"/>
      </form:label>
      <div class="col-lg-3">
        <form:input path="telephone" placeholder="${customer.telephone}" value="${customer.telephone}"  cssClass="form-control"/>
      </div>
      <form:errors path="telephone" cssClass="error"/>
    </div>
    <div class="form-group">
      <form:label class="col-lg-2 control-label" path="">
      </form:label>
      <div class="col-lg-3">
        <form:input path="id" placeholder="${customer.id}"  value="${customer.id}" cssClass="form-control"/>
      </div>
    </div>
  </fieldset>
  </c:forEach>
  <div class="form-group">
    <div class="col-lg-offset-2 col-lg-10">
      <button type="submit" class="btn btn-primary"><spring:message code="label.lastname"/></button>
    </div>
  </div>
</form:form>
</body>
</html>
