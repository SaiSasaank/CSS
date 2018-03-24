<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
‌​
<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_logout.jspf" %> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link href="css/sidebar.css" rel="stylesheet">
 <style>
 .column1 {
		overflow: hidden;
		float: left;
	
		padding: 10px;
		width: 20%;
}
.column2 {
		overflow: hidden;
		float: right;
		
		padding: 10px;
		width: 79%;
		
 </style>
<div class="wrapper">

    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>Category</h3></div>
        <ul class="list-unstyled components">
            <li><a href="csssidebar.do?cat_id=1">Website</a></li>
            <li><a href="csssidebar.do?cat_id=2">BankCard</a></li>
            <li><a href="csssidebar.do?cat_id=3">Passport</a></li>
            <li><a href="csssidebar.do?cat_id=4">AadharCard</a></li>
            <li><a href="csssidebar.do?cat_id=5">License</a></li>
            <li><a href="csssidebar.do?cat_id=6">Others</a></li>
            <li><a data-toggle="modal" data-target="#registerUser" >Add New Credentials</a></li>
        </ul>
    </nav>
<script>
$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

});
</script>
 <div class="container-fluid">
		<p>
		<font color="red">${errorMessage}</font>
		</p>
	
	
<div class="container-fluid">
	<!--  <div class="column1">
			<table class="table table-striped">
				<thead>
					<th>Category </th>
				</thead>
				<tbody>
					<c:forEach items="${css}" var="css1">
						<tr>
							<td>${css1.category} </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
	<div  class="column2">-->
	<p>Your saved credentials are</p>
		<table class="table table-striped">
				<thead>
					<th>Reference</th>
					<th>Actions</th>
				</thead>
				<tbody>
					<c:forEach items="${css}" var="css1">
						<tr>
						
							<td>${css1.reference}</td>					
							<td>&nbsp;&nbsp;<a class="btn btn-success btn-sm" href="show.do?css_id=${css1.css_id}&cat_id=${css1.cat_id}" >Show</a>
					    	&nbsp;&nbsp;<button class="open-homeEvents btn btn-warning btn-sm" name="dbType" id="dbType" value="${css1.css_id}" data-id="${css1.css_id}" data-toggle="modal" data-target="#updateUser${css1.cat_id}" >Update</button><!--   <a href="update.do?css_id=${css1.css_id}?cat_id=${css1.cat_id}"></a>-->
						    &nbsp;&nbsp;<a class="btn btn-danger btn-sm"	href="delete.do?css_id=${css1.css_id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
<!--  </div>-->
	
	
	

	
	
<!-- Update Modal -->	
	<div id="1" >
  		<div class="modal fade" id="updateUser1" role="dialog" aria-hidden="true">
	 		<div class="modal-dialog" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><h4 class="modal-title">CSS Update Credentials</h4></div>
					<div class="modal-body">
						<form method="POST" action="update.do">
							<div class="form-group">
								<p align="center">Website:</p>
								<div class="Website" >
									<label>URL</label> <input name="url" type="text" class="form-control" /> <BR />
									<label>Username</label> <input name="username" type="text"	class="form-control" /> <BR />
									<label>Password</label> <input name="password" type="text"	class="form-control" /> <BR />
								</div>
    							<input type="hidden" name="catd" id="catId"  value="1"/>
        						<input type="hidden" name="eventId0" id="eventId0" />
								<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<input name="add" type="submit" class="btn btn-success" value="Submit" /></p>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<p>Powered by CSS</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="2" >
  		<div class="modal fade" id="updateUser2" role="dialog" aria-hidden="true">
	 		<div class="modal-dialog" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><h4 class="modal-title">CSS Update Credentials</h4></div>
					<div class="modal-body">						
						<form method="POST" action="update.do">
							<div class="form-group">
								<p align="center">BankCard:</p>
								<div class="BankCard" >
        							<label>Card Number</label><input name="doc_num" type="text" class="form-control" /> <BR />
        							<label>Validity of the Card</label> <input type="date" name="val_date"  class="form-control" /><BR />
        							<label>Name on the Card</label><input name="doc_name" type="text" class="form-control" /> <BR />
        							<label>CVV</label><input name="cvv" type="text" class="form-control" /> <BR />
								</div>
								<input type="hidden" name="catd" id="catId"  value="2"/>
        						<input type="hidden" name="eventId1" id="eventId1" />
								<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<input name="add" type="submit" class="btn btn-success" value="Submit" /></p>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<p>Powered by CSS</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="3" >
  		<div class="modal fade" id="updateUser3" role="dialog" aria-hidden="true">
	 		<div class="modal-dialog" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><h4 class="modal-title">CSS Update Credentials</h4></div>
					<div class="modal-body">
						<form method="POST" action="update.do">
							<div class="form-group">
								<p align="center">Passport:</p>
								<div class="Passport" >
        							<label>Passport Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        							<label>Passport type</label> <input name="type_info" type="text" class="form-control" /> <BR />
        							<label>Nationality</label> <input name="nation" type="text" class="form-control" /> <BR />
        							<label>Name on the Passport</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        							<label>Address on the Passport</label> <input name="address" type="text" class="form-control" /> <BR />
        							<label>Date of Expiry</label> <input type="date" name="val_date"  class="form-control" /><BR />
        						</div>
        						<input type="hidden" name="catd" id="catId"  value="3"/>
        						<input type="hidden" name="eventId2" id="eventId2" />
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<input name="add" type="submit" class="btn btn-success" value="Submit" /></p>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<p>Powered by CSS</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="4" >
	 	<div class="modal fade" id="updateUser4" role="dialog" aria-hidden="true">
			<div class="modal-dialog" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><h4 class="modal-title">CSS Update Credentials</h4></div>
					<div class="modal-body">
						<form method="POST" action="update.do">
							<div class="form-group">
								<p align="center">AadharCard:</p>
								<div class="AadharCard" >
        							<label>Aadhar Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        							<label>Name on Aadhar</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        							<label>Date of Birth </label><input name="val_date" type="date" class="form-control"  /> <BR />
        							<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />        		
        						</div>
        						<input type="hidden" name="catd" id="catId"  value="4"/>
        						<input type="hidden" name="eventId3" id="eventId3" />
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<input name="add" type="submit" class="btn btn-success" value="Submit" /></p>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<p>Powered by CSS</p>
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div id="5" >
 		<div class="modal fade" id="updateUser5" role="dialog" aria-hidden="true">
	 		<div class="modal-dialog" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><h4 class="modal-title">CSS Update Credentials</h4></div>
					<div class="modal-body">
						<form method="POST" action="update.do">
							<div class="form-group">
								<p align="center">License:</p>
								<div class="License" >
        							<label>License Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        							<label>Name on License</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        							<label>Valid Upto</label> <input name="val_date" type="date" class="form-control"   /> <BR />
        							<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />
        						</div>
        						<input type="hidden" name="catd" id="catId"  value="5"/>
        						<input type="hidden" name="eventId4" id="eventId4" />
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<input name="add" type="submit" class="btn btn-success" value="Submit" /></p>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<p>Powered by CSS</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="6" >
		<div class="modal fade" id="updateUser6" role="dialog" aria-hidden="true">
	 		<div class="modal-dialog" role="document">
	  			<div class="modal-content">
					<div class="modal-header"><h4 class="modal-title">CSS Update Credentials</h4></div>
					<div class="modal-body">
						<form method="POST" action="update.do">
							<div class="form-group">
								<p align="center">Others:</p>
								<div class="Others" >
        							<label>Document Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        							<label>Name on the Document</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        							<label>Information about Document</label> <input name="type_info" type="text" class="form-control" /> <BR />
        							<label>Valid Upto</label> <input name="val_date" type="date" class="form-control"  /> <BR />
        							<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />
        						</div>
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<input name="add" type="submit" class="btn btn-success" value="Submit" /></p>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<p>Powered by CSS</p>
					</div>
				</div>
			</div>
		</div>
	</div>
   <!--  <script>
    $('#dbType').on('change',function(){
        var selection = $(this).val();
       	switch(selection){
       		case "1":
       			$("#1").show()
      			break;
      		case "2":
           		$("#2").show()
          		break;
      		case "3":
           		$("#3").show()
          		break;
      		case "4":
           		$("#4").show()
          		break;
      		case "5":
           		$("#5").show()
          		break;
      		case "6":
           		$("#6").show()
          		break;       
       }
   });
    </script>  -->
    <script>
    $(document).on("click", ".open-homeEvents", function () {
        var eventId0 = $(this).data('id');
        $('#idHolder0').html( eventId0 );
        document.getElementById("eventId0").setAttribute('value',eventId0);
   });
    $(document).on("click", ".open-homeEvents", function () {
        var eventId1 = $(this).data('id');
        $('#idHolder1').html( eventId1 );
        document.getElementById("eventId1").setAttribute('value',eventId1);
   });
    $(document).on("click", ".open-homeEvents", function () {
        var eventId2 = $(this).data('id');
        $('#idHolder2').html( eventId2 );
        document.getElementById("eventId2").setAttribute('value',eventId2);
   });
    $(document).on("click", ".open-homeEvents", function () {
        var eventId3 = $(this).data('id');
        $('#idHolder3').html( eventId3 );
        document.getElementById("eventId3").setAttribute('value',eventId3);
   });
    $(document).on("click", ".open-homeEvents", function () {
        var eventId4 = $(this).data('id');
        $('#idHolder4').html( eventId4 );
        document.getElementById("eventId4").setAttribute('value',eventId4);
   });
    $(document).on("click", ".open-homeEvents", function () {
        var eventId5 = $(this).data('id');
        $('#idHolder5').html( eventId5 );
        document.getElementById("eventId5").setAttribute('value',eventId5);
   });
   </script>

   
	
	
	
	
	
	
	
<!-- Modal -->
	<div class="modal fade" id="registerUser" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
	  		<div class="modal-content">
				<div class="modal-header"><h4 class="modal-title">CSS Add Credentials</h4></div>
				<div class="modal-body">
					<div class="form-group">
						<p align="center">Your New Credential:</p>
						<fieldset class="form-group">
						<label>Select a Category</label><select class="form-control"  data-target=".my-info-1">
							<option >options..</option>
							<option value="Website" data-show=".Website">Web-site</option>
							<option value="BankCard" data-show=".BankCard">Credit/Debit Card</option>
							<option value="Passport" data-show=".Passport">Passport</option>
							<option value="AadharCard" data-show=".AadharCard">Aadhar Card</option>
							<option value="License" data-show=".License">Driving-License/Registration</option>
							<option value="Others" data-show=".Others">Others</option>
							</select> <BR />
						</fieldset>
						<div class="my-info-1">
							<div class="Website hide" >
								<form method="POST" action="add.do">
								<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
								<label>URL</label> <input name="url" type="text" class="form-control" /> <BR />
								<label>Username</label> <input name="username" type="text"	class="form-control" /> <BR />
								<label>Password</label> <input name="password" type="password"	class="form-control" /> <BR />
								<input name="category" type="hidden" class="form-control" value="Website"/>
								<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button  type="submit" class="btn btn-success">Submit</button></p>
								</form>
							</div>
			   				<div class="BankCard hide" >
			   					<form method="POST" action="add.do">
			   					<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
        						<label>Card Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        						<label>Validity of the Card</label> <input name="val_date" type="date" class="form-control"  ><BR />
        						<label>Name on the Card</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        						<label>CVV</label> <input name="cvv" type="password" class="form-control" /> <BR />
        						<input name="category" type="hidden" class="form-control" value="BankCard"/>
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button  type="submit" class="btn btn-success">Submit</button></p>
        						</form>
							</div>
			        		<div class="Passport hide" >
			        			<form method="POST" action="add.do">
			        			<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
        						<label>Passport Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        						<label>Passport type</label> <input name="type_info" type="text" class="form-control" /> <BR />
        						<label>Nationality</label> <input name="nation" type="text" class="form-control" /> <BR />
        						<label>Name on the Passport</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        						<label>Address on the Passport</label> <input name="address" type="text" class="form-control" /> <BR />
        						<label>Date of Expiry</label> <input type="date" name="val_date"  class="form-control" /><BR />
        						<input name="category" type="hidden" class="form-control" value="Passport"/>
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button  type="submit" class="btn btn-success">Submit</button></p>
        						</form>
        					</div>
        		        	<div class="AadharCard hide" >
        		        		<form method="POST" action="add.do">
        		        		<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
        						<label>Aadhar Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        						<label>Name on Aadhar</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        						<label>Date of Birth </label><input name="val_date" type="date" class="form-control"  /> <BR />
        						<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />
        						<input name="category" type="hidden" class="form-control" value="AadharCard"/>
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button  type="submit" class="btn btn-success">Submit</button></p>
        						</form>
        					</div>
        		        	<div class="License hide" >
        		        		<form method="POST" action="add.do">
        		        		<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
        						<label>License Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        						<label>Name on License</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        						<label>Valid Upto</label> <input name="val_date" type="date" class="form-control"   /> <BR />
        						<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />
        						<input name="category" type="hidden" class="form-control" value="License"/>
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button  type="submit" class="btn btn-success">Submit</button></p>
        						</form>
        					</div>
        		        	<div class="Others hide" >
        		        		<form method="POST" action="add.do">
        		        		<label>Reference</label> <input name="reference" type="text" class="form-control" /> <BR />
        						<label>Document Number</label> <input name="doc_num" type="text" class="form-control" /> <BR />
        						<label>Name on the Document</label> <input name="doc_name" type="text" class="form-control" /> <BR />
        						<label>Information about Document</label> <input name="type_info" type="text" class="form-control" /> <BR />
        						<label>Valid Upto</label> <input name="val_date" type="date" class="form-control"  /> <BR />
        						<label>Address</label> <input name="address" type="text" class="form-control" /> <BR />
        						<input name="category" type="hidden" class="form-control" value="Others"/>
        						<p align="right"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button  type="submit" class="btn btn-success">Submit</button></p>
        						</form>
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
        <style>
        .hide {
 				 display: none;
				}
        </style>
				</div>
			</div>
			<div class="modal-footer">
				<p>Powered by CSS</p>
			</div>	   
			</div>
		</div>
		</div>
	</div>
</div>
</body>
</html>