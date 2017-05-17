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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ユーザー登録
		<c:choose>
			<c:when test="${dispMode == 0}">
				（入力）
			</c:when>
			<c:when test="${dispMode == 1}">
				（確認）
			</c:when>
			<c:when test="${dispMode == 2}">
				（完了）
			</c:when>
		</c:choose>
	</h1>

	<f:form modelAttribute="userCreateForm" action="/SpringTraining2/create/${url}" method="post" class="form-horizontal">

		<c:if test="${dispMode != 0}">
			<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
					<c:choose>
						<c:when test="${dispMode == 1}">
							以下の内容で登録を行います。よろしいですか？
						</c:when>
						<c:when test="${dispMode == 2}">
							以下の内容で登録を行います。よろしいですか？
						</c:when>
					</c:choose>
				</div>
			</div>
		</c:if>

		<div class="form-group">
			<div class="col-md-offset-2 col-md-8">
				<c:choose>
					<c:when test="${dispMode == 0}">
						<button name="confirm">確認</button>
						<button type="button" onclick="location.href='/SpringTraining2/userList'">
							戻る
						</button>
						<button name="logout" class="pull-right">ログアウト</button>
					</c:when>
					<c:when test="${dispMode == 1}">
						<button name="complete">完了</button>
						<button type="button" onclick="javascript:history.back()">戻る</button>
					</c:when>
					<c:when test="${dispMode == 2}">
						<button type="button" onclick="location.href='/SpringTraining2/create'">
							連続登録
						</button>
						<button type="button" onclick="location.href='/SpringTraining2/userList'">
							ユーザー一覧へ
						</button>
					</c:when>
				</c:choose>
			</div>
		</div>

		<c:if test="${dispMode == 1}">
			<f:hidden path="userId"/>
			<f:hidden path="password"/>
			<f:hidden path="auth"/>
			<f:hidden path="sectionId"/>
			<f:hidden path="name"/>
			<f:hidden path="birthdayYear"/>
			<f:hidden path="birthdayMonth"/>
			<f:hidden path="birthdayDay"/>
			<f:hidden path="sex"/>
			<f:hidden path="address"/>
			<f:hidden path="mailAddress"/>
			<f:hidden path="qualify"/>
		</c:if>

	<c:if test="${dispMode != 0}">
		<fieldset disabled>
	</c:if>

		<div class="form-group">
			<f:label path="userId" class="col-md-2 control-label">ユーザーID</f:label>
			<div class="col-md-8">
				<f:input path="userId" type="text" class="form-control" size="5"/>
				<f:errors path="userId" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="password" class="col-md-2 control-label">パスワード</f:label>
			<div class="col-md-8">
				<f:password path="password" class="form-control" size="5"/>
				<f:errors path="password" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="auth" class="col-md-2 control-label">権限</f:label>
			<div class="col-md-8">
				<f:select path="auth" class="form-control">
					<f:options items="${userCreateForm.getAuthMap()}"/>
				</f:select>
				<f:errors path="auth" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="sectionId" class="col-md-2 control-label">部署</f:label>
			<div class="col-md-8">
				<f:select path="sectionId" class="form-control">
					<f:options items="${userCreateForm.getSectionMap()}"/>
				</f:select>
				<f:errors path="sectionId" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="name" class="col-md-2 control-label">ユーザー名</f:label>
			<div class="col-md-8">
				<f:input path="name" class="form-control" type="text" size="5"/>
				<f:errors path="name" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="birthdayYear" class="col-md-2 control-label">生年月日（年）</f:label>
			<div class="col-md-8">
				<f:select path="birthdayYear" class="form-control">
					<f:options items="${userCreateForm.getYearList()}"/>
				</f:select>
				<f:errors path="birthdayYear" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="birthdayMonth" class="col-md-2 control-label">生年月日（月）</f:label>
			<div class="col-md-8">
				<f:select path="birthdayMonth" class="form-control">
					<f:options items="${userCreateForm.getMonthList()}"/>
				</f:select>
				<f:errors path="birthdayMonth" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="birthdayDay" class="col-md-2 control-label">生年月日（日）</f:label>
			<div class="col-md-8">
				<f:select path="birthdayDay" class="form-control">
					<f:options items="${userCreateForm.getDayList()}"/>
				</f:select>
				<f:errors path="birthdayDay" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="sex" class="col-md-2 control-label">性別</f:label>
			<div class="col-md-8">
				<f:select path="sex" class="form-control">
					<f:options items="${userCreateForm.getSexMap()}" />
				</f:select>
				<f:errors path="sex" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="address" class="col-md-2 control-label">住所</f:label>
			<div class="col-md-8">
				<f:input path="address" type="text" class="form-control" size="5" />
				<f:errors path="address" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="mailAddress" class="col-md-2 control-label">メールアドレス</f:label>
			<div class="col-md-8">
				<f:input path="mailAddress" type="text" class="form-control" size="5"/>
				<f:errors path="mailAddress" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<f:label path="qualify" class="col-md-2 control-label">資格</f:label>
			<div class="col-md-8">
				<f:textarea path="qualify" class="form-control" rows="2"/>
				<f:errors path="qualify" element="div" cssStyle="color:red" />
			</div>
		</div>

	<c:if test="${dispMode != 0}">
		</fieldset>
	</c:if>

	</f:form>
</body>
</html>