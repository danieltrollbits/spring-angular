<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<title>index</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
	</head>
	<body style="padding:2% 10% 10% 10%">
		<div class="container">
			<div style="padding:1%">
				<fieldset style="padding:1%" class="default-border">
					<legend class="default-border">Pending Account/s</legend>
					<c:if test="${param.accepted != null}">
						<div class="alert alert-success" role="alert"><h4>Account accepted</h4></div>
					</c:if>
					<c:if test="${param.error != null}">
						<div class="alert alert-warning" role="alert"><h4>Please select one account</h4></div>
					</c:if>
					<form action="/accept_account" method="POST">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<tr>
								<th></th>
								<th>Id</th>
								<th>Username</th>
								<th>Name</th>
								<th>Date Created</th>
							</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${pendingAccount}">
									<tr>
										<td align="center"><input type="checkbox" name="userId" value="${user.id}"></td>
										<td>${user.id}</td>
										<td>${user.username}</td>
										<td>${user.name}</td>
										<td>${user.dateCreated}</td>
									</tr>
								</c:forEach>
								<c:if test="${pendingAccount.isEmpty()}">
									<td colspan="10" align="center"><h2>NO DETAILS</h2></td>
								</c:if>
							</tbody>
						</table>
						<button type="submit" value="accept" class="btn btn-default pull-right">Accept</button>
					</form>
				</fieldset>	
			</div>
		</div>
	</body>
</html>