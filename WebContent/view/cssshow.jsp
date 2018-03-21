<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_logout.jspf" %>
<div class="container">
 <br><br><br><br>
 <div>
 <H2>Account Details </H2>
 <button class="btn btn-success" id="Button1" type="button" value="${catid}" onclick="switchVisible();">Show Data</button>
</div>
	<c:forEach items="${css}" var="css1">
		<div id="1" class="divs">
		<div class="form-group col-md-6">
			<label>URL</label> <input name="url" type="text" class="form-control" value="${css1.url}"/> <BR />
			<label>Username</label> <input name="username" type="text"	class="form-control" value="${css1.username}"/> <BR />
			<label>Password</label> <input name="password" type="text"	class="form-control" value="${css1.password}" /> <BR />
		</div>	       	
        </div>
        <div id="2" class="divs">
        <div class="form-group col-md-6">
        	<label>Card Number</label><input name="doc_num" type="text" class="form-control" value="${css1.doc_num}"/> <BR />
        	<label>Validity of the Card</label> <input type="date" name="val_date"  class="form-control" value="${css1.val_date}"/><BR />
        	<label>Name on the Card</label><input name="doc_name" type="text" class="form-control" value="${css1.doc_name}" /> <BR />
        	<label>CVV</label><input name="cvv" type="text" class="form-control" value="${css1.cvv}"/> <BR /> 
       </div>	
       </div>
       <div id="3" class="divs">
       <div class="form-group col-md-6">
       		<label>Passport Number</label> <input name="doc_num" type="text" class="form-control" value="${css1.doc_num}"/> <BR />
        	<label>Passport type</label> <input name="type_info" type="text" class="form-control" value="${css1.type_info}"/> <BR />
        	<label>Nationality</label> <input name="nation" type="text" class="form-control" value="${css1.nation}"/> <BR />
        	<label>Name on the Passport</label> <input name="doc_name" type="text" class="form-control" value="${css1.doc_name}"/> <BR />
        	<label>Address on the Passport</label> <input name="address" type="text" class="form-control" value="${css1.address}"/> <BR />
        	<label>Date of Expiry</label> <input type="date" name="val_date"  class="form-control" /><BR value="${css1.val_date}"/>
       </div>
       </div>
       <div id="4" class="divs">
       <div class="form-group col-md-6">
			<label>Aadhar Number</label> <input name="doc_num" type="text" class="form-control" value="${css1.doc_num}"/> <BR />
       		<label>Name on Aadhar</label> <input name="doc_name" type="text" class="form-control" value="${css1.doc_name}"/> <BR />
       		<label>Date of Birth </label><input name="val_date" type="date" class="form-control"  value="${css1.val_date}"/> <BR />
       		<label>Address</label> <input name="address" type="text" class="form-control" value="${css1.address}"/> <BR />
       </div>
       </div>
       <div id="5" class="divs">
       <div class="form-group col-md-6">
       		<label>License Number</label> <input name="doc_num" type="text" class="form-control" value="${css1.doc_num}"/> <BR />
        	<label>Name on License</label> <input name="doc_name" type="text" class="form-control" value="${css1.doc_name}"/> <BR />
        	<label>Valid Upto</label> <input name="val_date" type="date" class="form-control"  value="${css1.val_date}" /> <BR />
        	<label>Address</label> <input name="address" type="text" class="form-control" value="${css1.address}"/> <BR />
       </div>
       </div>
       <div id="6" class="divs">
       <div class="form-group col-md-6">
       		<label>Document Number</label> <input name="doc_num" type="text" class="form-control" value="${css1.doc_num}"/> <BR />
        	<label>Name on the Document</label> <input name="doc_name" type="text" class="form-control" value="${css1.doc_name}"/> <BR />
        	<label>Information about Document</label> <input name="type_info" type="text" class="form-control" value="${css1.type_info}"/> <BR />
        	<label>Valid Upto</label> <input name="val_date" type="date" class="form-control" value="${css1.val_date}" /> <BR />
        	<label>Address</label> <input name="address" type="text" class="form-control" value="${css1.address}"/> <BR />
       </div>
       </div>
	</c:forEach>
</div>
<style>
.divs {
display:none;
}
</style>
 <script>
 function switchVisible() {

         if (document.getElementById('Button1').value == 1) {
             document.getElementById('1').style.display = 'block';
         }
         else if (document.getElementById('Button1').value == 2) {
             document.getElementById('2').style.display = 'block';
         }
         else if (document.getElementById('Button1').value == 3) {
             document.getElementById('3').style.display = 'block';
         }
         else if (document.getElementById('Button1').value == 4) {
             document.getElementById('4').style.display = 'block';
         }
         else if (document.getElementById('Button1').value == 5) {
             document.getElementById('5').style.display = 'block';
         }
         else {
             document.getElementById('6').style.display = 'block';
         }
}
    </script> 
<%@include file="/common/footer.jspf" %>