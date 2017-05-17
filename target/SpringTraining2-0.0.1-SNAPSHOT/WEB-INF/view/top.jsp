<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>トップ</title>
<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">TOP画面</h1>
	ようこそ
	<c:out value="${loginForm.getLoginUserDepartmentName()}" />
	の
	<c:out value="${loginForm.getLoginUserName()}" />
	さん

	<f:form modelAttribute="loginForm" action="userList" method="post">

		<div>
			<a href="/SpringTraining2/userList">ユーザー</a>
			<a href="/SpringTraining2/kintaiList">勤怠一覧（月次）</a>
		</div>

		<div>
			<button name="shukkin">出勤</button>
			<button name="taikin">退勤</button>
		</div>
		<div>
			<button name="logout">ログアウト</button>
		</div>

	</f:form>
</body>
</html>