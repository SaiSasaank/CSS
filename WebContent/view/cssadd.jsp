<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_logout.jspf" %> 

<div class="container">
<H1 align="center">CSS Add Credentials</H1>
	Your New Credential:<br><br>
	<form method="POST" action="add.do">
	<fieldset class="form-group">
			
		<fieldset class="form-group">
			<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
		</fieldset>
		
		<label>Select a Category<br><br><select class="form-control"  data-target=".my-info-1" name="category">
		<option value="web" data-show=".web">Web-site</option>
		<option value="card" data-show=".card">Credit/Debit Card</option>
		<option value="passport" data-show=".passport">Passport</option>
		<option value="aadhar" data-show=".aadhar">Aadhar Card</option>
		<option value="license" data-show=".license">Driving-License/Registration</option>
		<option value="others" data-show=".others">Others</option>
		</select> </label> <BR />
		</fieldset>
		
		<div class="my-info-1">
			<div class="web hide" >
				<label>URL</label> <input name="reference" type="text" class="form-control" /> <BR />
				<label>Username</label> <input name="reference" type="text"	class="form-control" /> <BR />
				<label>Password</label> <input name="reference" type="text"	class="form-control" /> <BR />
			</div>
			
        	<div class="card hide" >
        	<label>Card Number</label> <input name="reference" type="text" class="form-control" /> <BR />
        	<label>Validity of the Card <input type="month" id="dateDefault" class="form-control" value='2018-03'></label><BR />
        	<label>Name on the Card</label> <input name="reference" type="text" class="form-control" /> <BR />
        	<label>CVV</label> <input name="reference" type="password" class="form-control" /> <BR />
			</div>
			
        	<div class="passport hide" >
        		<label>Passport Number</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Passport type</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Nationality</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Name on the Passport</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Address on the Passport</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Date of Expiry <input type="date" name="date" value='2018-03-16' class="form-control" /></label><BR />
        	</div>
        	
        	<div class="aadhar hide" >
        		<label>Aadhar Number</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Name on Aadhar</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Date of Birth <input name="reference" type="date" class="form-control" value='1996-12-16'/></label> <BR />
        		<label>Address</label> <input name="reference" type="text" class="form-control" /> <BR />
        	</div>
        	
        	<div class="license hide" >
        	<label>License Number</label> <input name="reference" type="text" class="form-control" /> <BR />
        	<label>Name on License</label> <input name="reference" type="text" class="form-control" /> <BR />
        	<label>Valid Upto <input name="reference" type="date" class="form-control" /></label> <BR /><br>
        	<label><input name="reference" type="checkbox" class="form-control" />Light Motor Vehicle 
        	<input name="reference" type="checkbox" class="form-control" /><label>Motor Vehicle with Gear</label>  <BR />
        	</div>
        	
        	<div class="others hide" >
        		<label>Document Number</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Name on the Document</label> <input name="reference" type="text" class="form-control" /> <BR />
        		<label>Information about Document</label> <input name="reference" type="text" class="form-control" /> <BR />
        	</div>
        </div>


        <script>
        $(document).on('change', '.form-control', function() {
        	  var target = $(this).data('target');
        	  var show = $("option:selected", this).data('show');
        	  $(target).children().addClass('hide');
        	  $(show).removeClass('hide');
        	});
        	$(document).ready(function(){
        	    $('.form-control').trigger('change');
        	});
        </script>
		
		<input name="add" type="submit" class="btn btn-success" value="Submit" />
	</form>
</div>
</body>
</html>