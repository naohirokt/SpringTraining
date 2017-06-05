<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<title>ユーザー削除</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
	</head>

	<body>
		<h1 align="center">ユーザー削除
			<c:choose>
				<c:when test="${dispMode == 0}">（確認）</c:when>
				<c:when test="${dispMode == 1}">（完了）</c:when>
			</c:choose>
		</h1>
		<f:form modelAttribute="userCreateForm" action="delete/complete" method="post" class="form-horizontal">

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<c:choose>
						<c:when test="${dispMode == 0}">
							以下のデータを削除します。よろしいですか？
						</c:when>
						<c:when test="${dispMode == 1}">
							以下のデータを削除しました。
						</c:when>
					</c:choose>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<c:choose>
						<c:when test="${dispMode == 0}">
							<button name="deleteComplete">完了</button>
							<button type="button" onclick="javascript:history.back()">戻る</button>
						</c:when>
						<c:when test="${dispMode == 1}">
							<button type="button" onclick="location.href='/SpringTraining2/userList'">
								ユーザー一覧へ
							</button>
						</c:when>
					</c:choose>
				</div>
			</div>

			<c:if test="${dispMode == 0}">
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
				<f:hidden path="authDispName"/>
				<f:hidden path="sectionDispName"/>
				<f:hidden path="sexDispName"/>
			</c:if>

			<div class="form-group">
				<label class="col-sm-2 control-label">ユーザーID</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getUserId()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">パスワード</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getPassword()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="auth" class="col-sm-2 control-label">権限</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getAuthDispName()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="sectionId" class="col-sm-2 control-label">部署</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getSectionDispName()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">ユーザー名</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getName()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="birthdayYear" class="col-sm-2 control-label">生年月日（年）</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getBirthdayYear()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="birthdayMonth" class="col-sm-2 control-label">生年月日（月）</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getBirthdayMonth()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="birthdayDay" class="col-sm-2 control-label">生年月日（日）</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getBirthdayDay()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">性別</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getSexDispName()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">住所</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getAddress()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="mailAddress" class="col-sm-2 control-label">メールアドレス</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getMailAddress()}"/>
				</div>
			</div>

			<div class="form-group">
				<label for="qualify" class="col-sm-2 control-label">資格</label>
				<div class="col-sm-8">
					<c:out value="${userCreateForm.getQualify()}"/>
				</div>
			</div>

		</f:form>

	</body>
</html>

