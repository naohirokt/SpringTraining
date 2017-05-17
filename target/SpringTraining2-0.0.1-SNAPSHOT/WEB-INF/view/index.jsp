<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>ログイン</title>
<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ログイン画面</h1>
	<f:form modelAttribute="loginForm" action="login" method="post">

		<div id="table">
			<div id="row">
				<div>
					ユーザID：<input type="text" id="userId" name="userId">
					<f:errors path="userId" element="div" cssStyle="color:red" />
				</div>
				<div>
					パスワード：<input type="text" id="loginPassword" name="loginPassword"
						maxlength="16">
					<f:errors path="loginPassword" element="div" cssStyle="color:red" />
				</div>
			</div>
		</div>

		<div>
			<input type="submit" value="ログイン">
		</div>

	</f:form>

</body>
</html>