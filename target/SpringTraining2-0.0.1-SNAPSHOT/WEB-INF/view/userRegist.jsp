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
<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ユーザー登録（入力）</h1>
	<f:form modelAttribute="userCreateForm" action="confirm" method="post">

		<div align="left">
			<button name="userRegistConfirm">登録</button>
			<button name="logout">ログアウト</button>
			<button type="button" onclick="location.href='/SpringTraining2/userList'">
				戻る
			</button>
		</div>

		<div id="table">
			<div id="row">
				<div>
					<label>ユーザーID</label>
					<f:input path="userId" type="text" size="5"/>
				</div>
			</div>
			<div id="row">
				<div>
					<label>パスワード</label>
					<f:password path="password" size="5"/>
				</div>
			</div>
			<div id="row">
				<div>
					<label>権限</label>
					<f:select path="auth">
						<f:options items="${authList}"/>
					</f:select>
				</div>
			</div>
			<div id="row">
				<div>
					<label>部署</label>
					<f:select path="sectionId">
						<f:options items="${sectionList}"/>
					</f:select>
				</div>
			</div>
			<div id="row">
				<div>
					<label>ユーザー名</label>
					<f:input path="name" type="text" size="5"/>
				</div>
			</div>
			<div id="row">
				<div>
					<label>生年月日（年）</label>
					<f:select path="birthdayYear">
						<f:options items="${yearList}"/>
					</f:select>
				</div>
			</div>
			<div id="row">
				<div>
					<label>生年月日（月）</label>
					<f:select path="birthdayMonth">
						<f:options items="${monthList}"/>
					</f:select>
				</div>
			</div>
			<div id="row">
				<div>
					<label>生年月日（日）</label>
					<f:select path="birthdayDay">
						<f:options items="${dayList}"/>
					</f:select>
				</div>
			</div>
			<div id="row">
				<div>
					<label>性別</label>
					<f:input path="sex" type="text" size="5"/>
				</div>
			</div>
			<div id="row">
				<div>
					<label>住所</label>
					<f:input path="address" type="text" size="5"/>
				</div>
			</div>
			<div id="row">
				<div>
					<label>メールアドレス</label>
					<f:input path="mailAddress" type="text" size="5"/>
				</div>
			</div>
			<div id="row">
				<div>
					<label>資格</label>
					<f:input path="qualify" type="textarea" size="5"/>
				</div>
			</div>
		</div>
	</f:form>
</body>
</html>