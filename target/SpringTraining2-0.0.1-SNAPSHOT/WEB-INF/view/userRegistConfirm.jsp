<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>ユーザー登録</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ユーザー登録（確認）</h1>
	<f:form modelAttribute="userRegistForm" action="complete" method="post">

		<div align="left">
			<button name="userRegistComplete">登録</button>
			<button type="button" onclick="javascript:history.back()">戻る</button>
		</div>

		<div id="table">
			<div id="row">
				<div>
					<label>ユーザーID</label>
					<div><c:out value="${ userRegistForm.getUserId() }"/></div>
					<f:hidden path="userId" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>パスワード</label>
					<div><c:out value="${ userRegistForm.getPassword() }"/></div>
					<f:hidden path="password" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>権限</label>
					<div><c:out value="${ authDispName }"/></div>
					<f:hidden path="auth" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>部署</label>
					<div><c:out value="${ sectionDispName }"/></div>
					<f:hidden path="sectionId" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>ユーザー名</label>
					<div><c:out value="${ userRegistForm.getName() }"/></div>
					<f:hidden path="name" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>生年月日（年）</label>
					<div><c:out value="${ userRegistForm.getBirthdayYear() }"/></div>
					<f:hidden path="birthdayYear" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>生年月日（月）</label>
					<div><c:out value="${ userRegistForm.getBirthdayMonth() }"/></div>
					<f:hidden path="birthdayMonth" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>生年月日（日）</label>
					<div><c:out value="${ userRegistForm.getBirthdayDay() }"/></div>
					<f:hidden path="birthdayDay" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>性別</label>
					<div><c:out value="${ userRegistForm.getSex() }"/></div>
					<f:hidden path="sex" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>住所</label>
					<div><c:out value="${ userRegistForm.getAddress() }"/></div>
					<f:hidden path="address" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>メールアドレス</label>
					<div><c:out value="${ userRegistForm.getMailAddress() }"/></div>
					<f:hidden path="mailAddress" />
				</div>
			</div>
			<div id="row">
				<div>
					<label>資格</label>
					<div><c:out value="${ userRegistForm.getQualify() }"/></div>
					<f:hidden path="qualify" />
				</div>
			</div>
		</div>
	</f:form>
</body>
</html>

