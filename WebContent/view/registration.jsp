<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_login.jspf" %> 

<script type="text/javascript">
$('submit').click(function () {
	  if ($('#password').val() == $('#confirm_password').val()) {
	    $('#message').html('Matching').css('color', 'green');
	  } else 
	    $('#message').html('Not Matching').css('color', 'red');
	});
</script>

 
 <div class="container">
 <br><br><br><br>
 <H1 align="center">Registration </H1>
 
 <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
 

 
 	<!-- <form action="register.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			<input type="text" class="form-control" name="name" placeholder="Userame" required="" autofocus="" />
			<input type="text" class="form-control" name="fullname" placeholder="Full Name" required="" autofocus="" />
			<input type="text" class="form-control" name="email" placeholder="Email ID" required="" autofocus="" />
			<input type="password" class="form-control" id="password"  name="password" placeholder="Password" required=""/>
			<input type="password" class="form-control" name="confirm_password"  id="confirm_password" placeholder="Confirm Password" required=""/>
			    	      
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Register</button> 
			    	
	</form > -->
	<form action="register.do" method="post">
		<div class="form-row">
    		<div class="form-group col-md-6">
      			<label for="username4">Username</label>
      			<input type="text" class="form-control" id="username4" placeholder="Username" name="name" required="" autofocus="">
   			</div>
    		<div class="form-group col-md-6">
      			<label for="fullname4">Full Name</label>
      			<input type="text" class="form-control" id="fullname4" placeholder="Full Name" name="fullname" required="" autofocus="">
    		</div>
  		</div>
  		<div class="form-group">
      		<label for="inputEmail4">Email</label>
      		<input type="email" class="form-control" id="inputEmail4" placeholder="1234@email.com" name="email" required="" autofocus="">
    	</div>
  		<div class="form-row">
  			<div class="form-group col-md-6">
      			<label for="password">Password</label>
      			<input type="password" class="form-control" id="password" placeholder="Password" name="password" required="" autofocus="">
    		</div>
    		<div class="form-group col-md-6">
    			<label for="confirm_password">Confirm Password</label>
    			<input type="password" class="form-control" id="confirm_password" placeholder="Confirm Password" name="confirm_password" required="" autofocus="">
  			</div>
  		</div>  		
  <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Register</button> 
</form>
 </div>
 
 <%@include file="/common/footer.jspf" %>
 