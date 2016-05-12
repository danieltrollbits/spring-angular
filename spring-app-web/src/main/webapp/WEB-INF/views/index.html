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
			<div class="row">
				<div class="col-md-12 text-right">
					<span>Welcome ${sessionScope.username} - ${sessionScope.authorities.get(0)} | </span>
					<c:if test="${sessionScope.authorities.get(0).toString().equals('ADMIN')}">
						<a href="/pending_account">Pending account <span class="badge">${pendingAccount}</span></a> |
					</c:if>
					<a href="<c:url value='/logout' />" class="btn btn-link">Logout</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="text-success">${param.message}</div>
				</div>
			</div>
			<fieldset class="default-border">
				<legend class="default-border">Persons</legend>
				<div style="padding:1%">
					<fieldset style="padding:1%" class="default-border">
						<legend class="default-border">Search Filter</legend>
						<form action="search" method="get">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<div class="row">
							    <div class="col-md-6">
							        <div class="row">
							            <div class="col-md-4">First Name</div>
							            <div class="col-md-8">
							            	<input type="text" name="firstName" value="${param.firstName}" class="form-control">
							            </div>
							        </div><br>
							        <div class="row">
							            <div class="col-md-4">Middle Name</div>
							            <div class="col-md-8">
							            	<input type="text" name="middleName" value="${param.middleName}" class="form-control">
							            </div>
							        </div>
							    </div>
							    <div class="col-md-6">
							        <div class="row">
							            <div class="col-md-4">Last Name</div>
							            <div class="col-md-8">
							            	<input type="text" name="lastName" value="${param.lastName}" class="form-control">
							            </div>
							        </div><br>
							        <div class="row">
							            <div class="col-md-4">Role</div>
							            <div class="col-md-8">
							            	<select name="roles" class="form-control">
												<option value="">Select role...</option>
												<c:forEach var="role" items="${roles}">
													<option ${role.role == param.roles ? 'selected="selected"' : ''} 
													value="${role.role}">${role.role}</option>
												</c:forEach>
											</select>
							            </div>
							        </div>
							    </div>
							</div><br>
							<div align="right">
								<button type="submit" name="search" value="search" class="btn btn-default">Search</button>
							</div>
						</form>
					</fieldset>
				</div>
				<div style="padding:1%">
					<fieldset style="padding:1%" class="default-border">
						<legend class="default-border">Person Table</legend>
						<form id="personForm">
							<div align="right">
								<input type="button" value="View" name="view" id="btnView" class="btn btn-default">
								<input type="button" value="Add" name="add" id="btnAdd" class="btn btn-default">
								<input type="button" value="Update" name="update" id="btnUpdate" class="btn btn-default">
								<c:if test="${sessionScope.authorities.get(0).toString().equals('ADMIN')}">
									<input type="button" value="Delete" name="delete" id="btnDelete" class="btn btn-default">
									<input type="button" value="Audit" name="audit" id="btnAudit" class="btn btn-default">
								</c:if>
							</div><br>
							<table class="table table-striped table-bordered table-hover">
								<thead>
								<tr>
									<th></th>
									<th>Id</th>
									<th>First Name</th>
									<th>Middle Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th>Birthdate</th>
									<th>Employed</th>
									<th>Gwa</th>
									<th>Role</th>
								</tr>
								</thead>
								<tbody>
									<c:if test="${!persons.isEmpty()}">
									<c:forEach var="person" items="${persons}">
										<tr>
											<td><input type="checkbox" name="personId" value="${person.id}"></td>
											<td>${person.id}</td>
											<td>${person.firstName}</td>
											<td>${person.middleName}</td>
											<td>${person.lastName}</td>
											<td>${person.gender}</td>
											<td><fmt:formatDate dateStyle="long" value="${person.birthdate}"/></td>
											<td>${person.employed}</td>
											<td>${person.gwa}</td>
											<td>${person.rolesToString()}</td>
										</tr>
									</c:forEach>
									</c:if>
									<c:if test="${persons.isEmpty()}">
										<td colspan="10" align="center">NO DETAILS</td>
									</c:if>
								</tbody>
							</table>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>
					</fieldset>	
				</div>
			</fieldset>
		</div>

	<script src="<c:url value="/resources/js/jquery-2.2.3.min.js"/>"></script>
	<script>
		$('[name=personId]').on("click",function(){
			if($('input[name=personId]:checked').size() > 1){
				$("#btnView").attr("disabled",true);
			}
			else{
				$("#btnView").attr("disabled",false);	
			}
		});
		$("#btnView").on("click",function(){
		   $("#personForm").attr("action", "/view/"+$('input[name=personId]:checked').val())
		   .attr("method","get").submit();
		});
		$("#btnAdd").on("click",function(){
		   $("#personForm").attr("action", "/add")
		   .attr("method","get").submit();
		});
		$("#btnUpdate").on("click",function(){
		   $("#personForm").attr("action", "/update")
		   .attr("method","get").submit();
		});
		$("#btnDelete").on("click",function(){
		   $("#personForm").attr("action", "/delete")
		   .attr("method","post").submit();
		});
		$("#btnAudit").on("click",function(){
		   $("#personForm").attr("action", "/audit")
		   .attr("method","get").submit();
		});
	</script>
	</body>
</html>