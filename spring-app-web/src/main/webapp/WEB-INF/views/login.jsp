<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
                <form name="loginForm" action="/j_spring_security_login" method="POST" class="form-signin">
                <c:if test="${param.error != null}">
					<div class="alert alert-danger text-center">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success text-center">Sucesfully Logged out</div>
				</c:if>
                <input type="text" class="form-control" name="username" value="" placeholder="Username" required autofocus>
                <input type="password" class="form-control" name="password" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                <button type="submit" class="btn btn-link pull-right">Sign in as administrator</button>   
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
        </div>
    </div><br>
    <jsp:include page="create_account.jsp"/>
</div>

</body>
</html>