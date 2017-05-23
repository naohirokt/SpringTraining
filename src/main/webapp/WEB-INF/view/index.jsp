<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<title>ログイン</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">ログイン画面</h1>
	<f:form modelAttribute="loginForm" action="login" method="post" class="form-horizontal">

		<div class="form-group">
			<label for="userId" class="col-sm-2 control-label">ユーザID</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="userId" name="userId">
			</div>
			<f:errors path="userId" element="div" cssStyle="color:red" />
		</div>

		<div class="form-group">
			<label for="loginPassword" class="col-sm-2 control-label">パスワード</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="loginPassword" name="loginPassword" maxlength="16">
			</div>
			<f:errors path="userId" element="div" cssStyle="color:red" />
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-sm btn-primary">ログイン</button>
			</div>
		</div>

	</f:form>

</body>
</html>