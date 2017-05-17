<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="utf-8">
<title>勤怠一覧（月次）</title>
<link href="<c:url value="/resources/css/test.css" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">勤怠一覧（月次）</h1>
	<f:form modelAttribute="kintaiListForm" action="kintaiList" method="post">

		<div>
			<f:label path="sectionId">部署：</f:label>
			<f:select path="sectionId">
				<f:options items="${sectionList}"/>
			</f:select>
		</div>
		<div>
			<button name="search">検索</button>
		</div>
		<div align="left">
			<button name="logout">ログアウト</button>
			<button name="back">戻る</button>
		</div>

		<div id="table">
			<div class="header">
				<div>ユーザー名</div>
				<div>勤務時間</div>
				<div>残業時間</div>
				<div>勤務日数</div>
				<div>遅刻日数</div>
				<div>早退日数</div>
			</div>
			<c:forEach var="userList" items="${ kintaiList }" >
				<div class="row">
					<div><c:out value="${ kintaiList.getUserName() }"/></div>
					<div><c:out value="${ kintaiList.getWorkHours() }"/></div>
					<div><c:out value="${ kintaiList.getOverTime() }"/></div>
					<div><c:out value="${ kintaiList.getWorkingDay() }"/></div>
					<div><c:out value="${ kintaiList.getLateDays() }"/></div>
					<div><c:out value="${ kintaiList.getLeaveEarlyDays() }"/></div>
				</div>
			</c:forEach>
		</div>

	</f:form>

</body>
</html>