<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_login.jspf" %> 
	
	 <div class="container">
<br><br><br><br><br>
 	<form action="otp.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			<input type="password" class="form-control" name="otp" placeholder="Enter OTP" required="" autofocus="" />
			<small id="otphelp" class="form-text text-muted">OTP has been sent your registered Mail ID.</small><br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button> 
			    	
	</form>
	 
	 </div>
	 
<%@include file="/common/footer.jspf" %>