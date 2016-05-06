<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Person</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
</head>
<body style="padding:2% 10% 10% 10%">
	<form:form action="${pageContext.request.contextPath}/save" commandName="personDto" modelAttribute="personDto" method="post">
		<div class="row">
			<div class="col-md-6"><div class="text-danger">${error}</div></div>
		</div>
		<div class="row">
			<c:forEach var="error" items="${errors}">
				<div class="col-md-6"><div class="text-danger">${error}</div></div>
			</c:forEach>
		</div>
	<div>
		<fieldset class="default-border">
		<legend class="default-border">
			<c:choose>
				<c:when test="${personDto.id == 0}">Add Person</c:when>
				<c:otherwise>Update Person</c:otherwise>
			</c:choose>
		</legend>	
		<div style="padding:1%">
			<fieldset class="default-border">
				<legend class="default-border">General Information</legend>
				<form:hidden path="id" value="${person.id}"/>
				<div class="row">
				    <div class="col-md-6">
				        <div class="row">
				            <div class="col-md-4">First Name<span class="text-danger">*</span></div>
				            <div class="col-md-8"><form:input path="firstName" cssClass="form-control" value="${personDto.firstName}"/>
				            	<form:errors path="firstName" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">Middle Name<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="middleName" cssClass="form-control" value="${personDto.middleName}"/>
			            		<form:errors path="middleName" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">BirthDate<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<fmt:formatDate pattern="MM-dd-yyy" value="${personDto.birthdate}" var="formatDate"/>
				            	<form:input path="birthdate" value="${formatDate}" cssClass="form-control" placeholder="12-30-1900"/>
				            	<form:errors path="birthdate" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">Gwa<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="gwa" cssClass="form-control" value="${personDto.gwa != '0.0' ? personDto.gwa : ''}"/>
				            	<form:errors path="gwa" cssClass="text-danger"/><br>
				            </div>
				        </div>
				    </div>
				    <div class="col-md-6">
				        <div class="row">
				            <div class="col-md-4">Last Name<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="lastName" cssClass="form-control" value="${personDto.lastName}"/>
				            	<form:errors path="lastName" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">Gender<span class="text-danger">*</span></div>
				            <div class="col-md-8">
								<form:radiobutton path="gender" value="MALE"/>Male 
								<form:radiobutton path="gender" value="FEMALE"/>Female
								<br><form:errors path="gender" cssClass="text-danger"/>
				            </div>
				        </div><br>
				        <div class="row">
				            <div class="col-md-4">Employed?<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:radiobutton path="employed" value="true"/>Yes
								<form:radiobutton path="employed" value="false"/>No
								<form:errors path="employed" cssClass="text-danger"/>
				            </div>
				        </div>
				    </div>
				</div>
				<div class="row">
				    <div class="col-md-6">
				    	<fieldset class="default-border">
							<legend class="default-border">Role<span class="text-danger">*</span> </legend>
							<form:errors path="roleDtos" cssClass="text-danger"/>
							<form:checkboxes items="${roles}" path="roleDtos" delimiter="<br/>"/>
						</fieldset>
				    </div>
				</div>        
				
			</fieldset>
		</div>
		<div style="padding:1%">
			<fieldset class="default-border">
				<legend class="default-border">Address</legend>
				<div class="row">
				    <div class="col-md-6">
				        <div class="row">
				            <div class="col-md-4">Street<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="addressDto.street" cssClass="form-control" value="${personDto.addressDto.street}"/>
				            	<form:errors path="addressDto.street" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">Barangay<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="addressDto.barangay" cssClass="form-control" value="${personDto.addressDto.barangay}"/>
				            	<form:errors path="addressDto.barangay" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">City<span class="text-danger">*</span></div>
				            <div class="col-md-8">
			            		<form:input path="addressDto.city" cssClass="form-control" value="${personDto.addressDto.city}"/>
			            		<form:errors path="addressDto.city" cssClass="text-danger"/><br>
				            </div>
				        </div>
				    </div>
				    <div class="col-md-6">
				        <div class="row">
				            <div class="col-md-4">House No.<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="addressDto.houseNo" cssClass="form-control" value="${personDto.addressDto.houseNo}"/>
				            	<form:errors path="addressDto.houseNo" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">Subdivision</div>
				            <div class="col-md-8">
				            	<form:input path="addressDto.subdivision" cssClass="form-control" value="${personDto.addressDto.subdivision}"/>
				            	<form:errors path="addressDto.subdivision" cssClass="text-danger"/><br>
				            </div>
				        </div>
				        <div class="row">
				            <div class="col-md-4">Zipcode<span class="text-danger">*</span></div>
				            <div class="col-md-8">
				            	<form:input path="addressDto.zipCode" cssClass="form-control" value="${personDto.addressDto.zipCode}"/>
				            	<form:errors path="addressDto.zipCode" cssClass="text-danger"/><br>
				            </div>
				        </div>
				    </div>
				</div>
			</fieldset>
		</div>
		
		<div style="padding:1%">
			<fieldset class="default-border">
				<legend class="default-border">Contact</legend>
				<c:set var="contactCount" value="${0}"/>
				<c:forEach var="contact" items="${personDto.contactDtos}" varStatus="count">
					<div class="row">
						<div class="col-md-2">Type</div>
						<div class="col-md-4">
							<form:radiobutton path="contactDtos[${count.index}].type" value="MOBILE"/>Mobile
							<form:radiobutton path="contactDtos[${count.index}].type" value="PHONE"/>Phone
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">Number</div>
						<div class="col-md-4">
							<form:input cssClass="form-control" path="contactDtos[${count.index}].value"/>
						</div>
					</div>
					<form:hidden path="contactDtos[${count.index}].id" value="${personDto.contactDtos[$count.index].id}"/>
					<c:set var="contactCount" value="${count.index + 1}"/>
				</c:forEach>
				<c:if test="${not empty personDto.contactDtos}"><hr></c:if>
				<div class="row">
					<div class="col-md-2">Type</div>
					<div class="col-md-4">
						<form:radiobutton path="contactDtos[${contactCount}].type" value="MOBILE"/> Mobile
						<form:radiobutton path="contactDtos[${contactCount}].type" value="PHONE"/> Phone
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">Number</div>
					<div class="col-md-4">
						<form:input path="contactDtos[${contactCount}].value" value="${personDto.contactDtos[contactCount].value}"/>
					</div>
				</div>
			</fieldset>
		</div>
		<div align="right">
			<button type="submit" class="btn btn-default" name="save" value="save">Save</button>
		</div>
		</fieldset>	
	</div>
	</form:form>
</body>
</html>