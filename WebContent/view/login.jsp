<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_login.jspf" %> 
 <div class="container">
<br><br><br>
 	<!-- <form action="login.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
		<div align="center"><img src="images/avatar.png"  height="120" width="120"></div>
			<input type="text" class="form-control" name="name" placeholder="Username" required="" autofocus="" />
			<input type="password" class="form-control" name="password" placeholder="Password" required=""/>
			    	      
      <button class="btn btn-lg btn-success btn-block" type="submit" >Login</button> 		    	
	</form> -->
	<form action="login.do" method="post">
		<p>
			<font color="red">${error}</font>
		</p>
		<div align="center"><img src="images/avatar2.png"  height="200" width="200"></div>
		<div class="form-row">
  		<div class="form-group col-md-6">
    		<label for="username">Username</label>
    		<input type="text" class="form-control" id="username" aria-describedby="emailHelp" placeholder="Username" name="name" required="" autofocus="">
    		<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  		</div>
  		<div class="form-group col-md-6">
    		<label for="password">Password</label>
    		<input type="password" class="form-control" id="password" placeholder="Password" name="password" required="">
  		</div>
  		</div>
  			<button  class="btn btn-lg btn-outline-success btn-block" type="submit" >Login</button>
	</form>

 
 </div>
 
<%@include file="/common/footer.jspf" %>