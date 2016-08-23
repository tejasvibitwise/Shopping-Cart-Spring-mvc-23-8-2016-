<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- ${total } --%>


<c:forEach items="${cartItems.products}" var="product" varStatus="status">

		<td>
			Product : ${product.product_Name}
			Price : ${product.price}
 			Quantity : ${product.quantity}
 			Total Price : ${product.price*product.quantity}<BR><BR>
<!-- 		<input type="submit" value="Add to Cart" name=${product.product_Name}/><BR><BR> -->
<!-- 		<input type="submit" value="View Details" name=${product.product_Name}/> -->
<%-- 	<a href="/Shopping_Cart/details?id=${product.product_Name}></a> --%>
	
	
		</td>
	</c:forEach>
	<BR><BR>
	
	<h2>Total : ${total }</h2>
<a href="/Shopping_Cart/logout"><input type="submit"  value="Log Out"/> </a>

</body>
</html>