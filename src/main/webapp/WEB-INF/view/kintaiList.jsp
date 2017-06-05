<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<title>勤怠一覧（月次）</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
</head>
<body>
	<h1 align="center">勤怠一覧（月次）</h1>
	<f:form modelAttribute="kintaiListForm" action="kintaiList" method="post" class="form-horizontal">
		<div class="container">
			<div class="form-group">
				<f:label path="sectionId" class="control-label col-md-1">部署</f:label>
				<div class="col-md-3">
					<f:select path="sectionId" class="col-md-3 form-control">
						<f:options items="${sectionList}" />
					</f:select>
				</div>
				<div class="col-md-2">
					<button name="search">検索</button>
				</div>
				<div class="col-md-6">
					<div class="pull-right">
						<button name="back">戻る</button>
						<button name="logout">ログアウト</button>
					</div>
				</div>
			</div>
			<c:if test="${kintaiListDispFlg == 1}">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ユーザー名</th>
							<th>勤務時間</th>
							<th>残業時間</th>
							<th>勤務日数</th>
							<th>遅刻日数</th>
							<th>早退日数</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="kintaiList" items="${kintaiList}">
							<tr>
								<td><c:out value="${kintaiList.getUserName()}" /></td>
								<td><c:out value="${kintaiList.getWorkHours()}" /></td>
								<td><c:out value="${kintaiList.getOverTime()}" /></td>
								<td><c:out value="${kintaiList.getWorkingDay()}" /></td>
								<td><c:out value="${kintaiList.getLateDays()}" /></td>
								<td><c:out value="${kintaiList.getLeaveEarlyDays()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</f:form>
</body>
</html>