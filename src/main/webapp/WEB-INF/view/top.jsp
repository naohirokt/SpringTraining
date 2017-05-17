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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">TOP画面</h1>
	<f:form modelAttribute="loginForm" action="/SpringTraining2/top" method="post">

		<div class="container">

			<div class="row">
				<div class="col-md-offset-4 col-md-8">
					ようこそ
					<c:out value="${loginForm.getLoginUserDepartmentName()}" />
					の
					<c:out value="${loginForm.getLoginUserName()}" />
					さん
				</div>
				<div class="col-md-offset-7 col-md-5">
					<div class="pull-right">
						<a href="/SpringTraining2/userList">ユーザー</a>
						<a href="/SpringTraining2/kintaiList">勤怠一覧（月次）</a>
					</div>
				</div>
			</div>

			<div class="col-md-offset-4 col-md-8">
				<button name="shukkin">出勤</button>
				<button name="taikin">退勤</button>
				<button name="logout">ログアウト</button>
			</div>
		</div>
	</f:form>
</body>
</html>