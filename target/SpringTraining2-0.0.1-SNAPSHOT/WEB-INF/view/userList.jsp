<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>ユーザー一覧</title>
<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ユーザー一覧</h1>
	<f:form modelAttribute="userListForm" action="edit/input" method="post">

		<div align="left">
			<button name="userRegist">登録</button>
			<button name="update">更新</button>
			<button name="logout">ログアウト</button>
			<button name="back">戻る</button>
			<button type="button" onclick="location.href='/SpringTraining2/login'">
				戻る
			</button>
		</div>

		<div id="table">
			<div class="header">
				<div>&nbsp;</div>
				<div>ユーザーID</div>
				<div>ユーザー名</div>
				<div>権限</div>
			</div>
			<c:forEach var="userList" items="${ userList }" >
				<div class="row">
					<div><input type="radio" name="userIdRadio" value="${ userList.getUserId() }"/></div>
					<div><c:out value="${ userList.getUserId() }"/></div>
					<div><c:out value="${ userList.getName() }"/></div>
					<div>
						<c:if test="${ userList.getAuth() == 0 }">管理者</c:if>
						<c:if test="${ userList.getAuth() == 1 }">一般社員</c:if>
					</div>
				</div>
			</c:forEach>
		</div>

	</f:form>

</body>
</html>