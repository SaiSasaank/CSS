<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_logout.jspf" %> 

 

<br><br><br> 
 <div class="container">
 	<H1 >Search List</H1>
 	<table class="table table-striped">
		<caption>Searched for <b>${keyword}</b> and found <b>${searchSize}</b> css</caption>
		<thead>
			<th>Reference</th>
			<th>Category</th>
		</thead>
		<tbody>
			<c:forEach items="${css1}" var="css">
				<tr>
					<td>${css.reference}</td>
					<td>${css.category}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
 	
 </div>
 
 <%@include file="/common/footer.jspf" %>