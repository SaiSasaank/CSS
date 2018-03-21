<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_logout.jspf" %> 
 
 <div class="container">
 <br><br><br><br>
 <H2>Account Details </H2>
 
		<c:forEach items="${user}" var="u">
		<form action="accountupdate.do" method="post">
			<div class="form-row">
    			<div class="form-group col-md-6">
      				<label for="fullname">Full Name</label>
      				<input type="text" class="form-control" id="fullname" placeholder="Full Name" name="fullname" required="" autofocus="" value="${u.fullname}">
    			</div>
    			<div class="form-group col-md-6 ">
      				<label for="name">Username</label>
      				<input id="name" class="form-control" name="name"  value="${u.username}" readonly/>
   				</div>
  			</div>
  			<div class="form-group">
      			<label for="email">Email</label>
      			<input type="email" class="form-control" id="email" placeholder="1234@email.com" name="email" required="" autofocus="" value="${u.email}">
    		</div>
  			<div class="form-row">
    			<div class="form-group col-md-6 ">
      				<label for="password">Password <font color="red">${error}</font></label>
      				<input type="text" class="form-control" id="password" placeholder="Password" name="password" required="" autofocus="">
   				</div>
    			<div class="form-group col-md-6 ">
      				<label for="cpassword">Confirm Password</label>
      				<input type="text" class="form-control" id="cpassword" placeholder="Password" name="confirm_password" required="" autofocus="">
   				</div>
  			</div>
  			
    		<input id="token" class="form-control" name="token" type="hidden" value="${sessionScope.csrfToken}" /> 
    		 
    		<button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Update Account</button>    	
    	</form>
		</c:forEach>
		
</div>		
 
 
 <%@include file="/common/footer.jspf" %>
 