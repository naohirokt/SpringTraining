<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<meta charset="utf-8">
	<title>ユーザー更新</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ユーザー更新
		<c:choose>
			<c:when test="${dispMode == 0}">（入力）</c:when>
			<c:when test="${dispMode == 1}">（確認）</c:when>
			<c:when test="${dispMode == 2}">（完了）</c:when>
		</c:choose>
	</h1>
	<f:form modelAttribute="userCreateForm" action="/SpringTraining2/update/${url}" method="post" class="form-horizontal">

		<c:if test="${dispMode != 0}">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<c:choose>
						<c:when test="${dispMode == 1}">
							以下の内容で更新を行います。よろしいですか？
						</c:when>
						<c:when test="${dispMode == 2}">
							以下の内容で更新が完了しました。
						</c:when>
					</c:choose>
				</div>
			</div>
		</c:if>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<c:choose>
					<c:when test="${dispMode == 0}">
						<button name="confirm">確認</button>
						<button type="button" onclick="location.href='/SpringTraining2/userList'">戻る</button>
						<div class="pull-right">
							<button name="logout">ログアウト</button>
						</div>
					</c:when>
					<c:when test="${dispMode == 1}">
						<button name="complete">完了</button>
						<button type="button" onclick="javascript:history.back()">戻る</button>
					</c:when>
					<c:when test="${dispMode == 2}">
						<button type="button" onclick="location.href='/SpringTraining2/userList'">ユーザー一覧へ</button>
					</c:when>
				</c:choose>
			</div>
		</div>

		<c:choose>
			<c:when test="${dispMode == 0}">
				<f:hidden path="userId"/>
			</c:when>
			<c:when test="${dispMode == 1}">
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
			</c:when>
		</c:choose>

	<c:if test="${dispMode != 0}">
		<fieldset disabled>
	</c:if>

		<div class="form-group">
			<label for="userId" class="col-sm-2 control-label">ユーザーID</label>
			<div class="col-sm-8">
				<f:input path="userId" type="text" class="form-control" size="5" disabled="true"/>
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">パスワード</label>
			<div class="col-sm-8">
				<f:password path="password" class="form-control" size="5"/>
				<f:errors path="password" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="auth" class="col-sm-2 control-label">権限</label>
			<div class="col-sm-8">
				<f:select path="auth" class="form-control">
					<f:options items="${userCreateForm.getAuthMap()}"/>
				</f:select>
				<f:errors path="auth" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="sectionId" class="col-sm-2 control-label">部署</label>
			<div class="col-sm-8">
				<f:select path="sectionId" class="form-control">
					<f:options items="${userCreateForm.getSectionMap()}"/>
				</f:select>
				<f:errors path="sectionId" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">ユーザー名</label>
			<div class="col-sm-8">
				<f:input path="name" class="form-control" type="text" size="5"/>
				<f:errors path="name" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="birthdayYear" class="col-sm-2 control-label">生年月日（年）</label>
			<div class="col-sm-8">
				<f:select path="birthdayYear" class="form-control">
					<f:options items="${userCreateForm.getYearList()}"/>
				</f:select>
				<f:errors path="birthdayYear" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="birthdayMonth" class="col-sm-2 control-label">生年月日（月）</label>
			<div class="col-sm-8">
				<f:select path="birthdayMonth" class="form-control">
					<f:options items="${userCreateForm.getMonthList()}"/>
				</f:select>
				<f:errors path="birthdayMonth" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="birthdayDay" class="col-sm-2 control-label">生年月日（日）</label>
			<div class="col-sm-8">
				<f:select path="birthdayDay" class="form-control">
					<f:options items="${userCreateForm.getDayList()}"/>
				</f:select>
				<f:errors path="birthdayDay" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="sex" class="col-sm-2 control-label">性別</label>
			<div class="col-sm-8">
				<f:select path="sex" class="form-control">
					<f:options items="${userCreateForm.getSexMap()}" />
				</f:select>
				<f:errors path="sex" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="address" class="col-sm-2 control-label">住所</label>
			<div class="col-sm-8">
				<f:input path="address" type="text" class="form-control" size="5" />
				<f:errors path="address" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="mailAddress" class="col-sm-2 control-label">メールアドレス</label>
			<div class="col-sm-8">
				<f:input path="mailAddress" type="text" class="form-control" size="5"/>
				<f:errors path="mailAddress" element="div" cssStyle="color:red" />
			</div>
		</div>

		<div class="form-group">
			<label for="qualify" class="col-sm-2 control-label">資格</label>
			<div class="col-sm-8">
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