<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="kr.or.ddit.lprod.model.Lprod"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basic</title>
<%@ include file="/WEB-INF/views/commonJsp/basicLib.jsp"%>
<script>
	$(document).ready(function(){
		
		$(".lprodTr").on("click", function(){
			
			console.log("lpordTr click");
			var dataValue = $(this).data("lprod_gu");
			
			$("#lprod_gu").val(dataValue);
			
			$("#frm").submit();
			
			
			
			
			
// 			$("#lprod_gu").val($(this).children().first().text());
						
			
		})
	})

</script>
<!--header  -->
<%@include file="/WEB-INF/views/commonJsp/header.jsp"%>
<body>
<form id="frm" action="${cp}/prodList" method="get">
	<input type="hidden" id="lprod_gu" name ="lprod_gu">
	
</form>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!--left  -->
				<%@ include file="/WEB-INF/views/commonJsp/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">제품</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr class="lprodTr">
									<th>Lprod_GU</th>
									<th>Lprod_Id</th>
									<th>Lprod_NM</th>
								</tr>
							
								<c:forEach items="${lprodList}"  var="lprod">
										<tr class="lprodTr" data-lprod_gu="${lprod.LPROD_GU}">
												<td>${lprod.LPROD_GU}</td>
												<td>${lprod.LPROD_ID} </td>
												<td>${lprod.LPROD_NM} </td>
										</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
