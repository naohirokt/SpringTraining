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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ユーザー一覧</h1>
	<f:form modelAttribute="userListForm" action="userList" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<button name="create">登録</button>
					<button name="update">更新</button>
					<button name="delete">削除</button>
				</div>
				<div class="col-md-6">
					<div class="pull-right">
						<button type="button" onclick="location.href='/SpringTraining2/userList/back'">戻る</button>
						<button name="logout">ログアウト</button>
					</div>
				</div>
			</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>&nbsp;</th>
						<th>ユーザーID</th>
						<th>ユーザー名</th>
						<th>権限</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="userList" items="${userList}" >
						<tr>
							<td><f:radiobutton path="userIds" value="${userList.getUserId()}"/>
							<f:errors path="userIds" element="div" cssStyle="color:red" /></td>
							<td><c:out value="${userList.getUserId()}"/></td>
							<td><c:out value="${userList.getName()}"/></td>
							<td>
								<c:if test="${userList.getAuth() == 0}">管理者</c:if>
								<c:if test="${userList.getAuth() == 1}">一般社員</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</f:form>
</body>
</html>