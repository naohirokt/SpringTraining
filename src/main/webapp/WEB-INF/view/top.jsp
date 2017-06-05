<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<title>トップ</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/js/bootstrap.min.js" />" rel="stylesheet">
	</head>
	<body>
		<h1 align="center">TOP画面</h1>
		<f:form modelAttribute="parentForm" action="/SpringTraining2/top" method="post">

			<div class="container">

				<div class="row">
					<div class="col-md-offset-4 col-md-8">
						ようこそ
						<c:out value="${loginForm.getLoginUserDepartmentName()}" />
						の
						<c:out value="${loginForm.getLoginUserName()}" />
						さん
					</div>
					<div class="col-md-offset-7 col-md-5">
						<div class="pull-right">
							<c:if test="${loginForm.getLoginUserAuth() == 0}">
								<a href="/SpringTraining2/userList">ユーザー</a>
								<a href="/SpringTraining2/kintaiList">勤怠一覧（月次）</a>
							</c:if>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group">
						<f:label path="month" class="control-label col-xs-1">対象月</f:label>
						<div class="col-xs-1">
							<f:select path="month" class="col-md-3 form-control">
								<f:options items="${parentForm.monthList}" />
							</f:select>
						</div>
						<div class="col-xs-2">
							<button name="search">検索</button>
						</div>
					</div>
				</div>

				<br>

				<div class="row">
					<div class="col-md-12">
						<button name="create">登録</button>
						<button name="logout">ログアウト</button>
					</div>
				</div>

				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>日</th>
							<th>曜日</th>
							<th>出勤時間</th>
							<th>退勤時間</th>
							<th>休憩時間</th>
							<th>労働時間</th>
							<th>備考</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" varStatus="rowStatus" items="${parentForm.topFormList}">
							<tr>
								<c:if test="${list.isSaturday == 1}" var="isSaturday"/>
								<c:if test="${list.isHoliday == 1}" var="isHoliday"/>
								<c:if test="${list.isSaturday == 0}" var="isNormalday"/>

								<td>
									<c:if test="${isSaturday}">
										<font color="blue">
									</c:if>
									<c:if test="${isHoliday}">
										<font color="red">
									</c:if>
									<c:if test="${isNormalday}">
										<font>
									</c:if>
											<fmt:parseDate var="date" value="${list.day}" pattern="yyyy/MM/dd" />
											<fmt:formatDate value="${date}" pattern="dd"/>
											<f:hidden path="topFormList[${rowStatus.index}].day"/>
										</font>
								</td>
								<td>
									<c:if test="${isSaturday}">
										<font color="blue">
									</c:if>
									<c:if test="${isHoliday}">
										<font color="red">
									</c:if>
									<c:if test="${isNormalday}">
										<font>
									</c:if>
											<c:out value="${list.week}"/>
										</font>
								</td>
								<td><f:input type="time" step="300" path="topFormList[${rowStatus.index}].startTime" onchange="dateCalc(${rowStatus.index})"/></td>
								<td><f:input type="time" step="300" path="topFormList[${rowStatus.index}].endTime" onchange="dateCalc(${rowStatus.index})"/></td>
								<td><f:input type="time" step="300" path="topFormList[${rowStatus.index}].breakTime" onchange="dateCalc(${rowStatus.index})"/></td>
								<td><f:input type="text" disabled="true" path="topFormList[${rowStatus.index}].totalTime"/></td>
								<td><f:textarea path="topFormList[${rowStatus.index}].comment" class="form-control" rows="2"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</f:form>
	</body>

	<script type="text/javascript">
		window.onload = function () {
			for (var i = 0; i < 33; i++) {
				dateCalc(i);
			}
		};

		function dateCalc(index){
			var startTime = document.getElementById('topFormList' + index + '.startTime').value;
			var endTime = document.getElementById('topFormList' + index + '.endTime').value;
			var breakTime = document.getElementById('topFormList' + index + '.breakTime').value;
			if (startTime == "" || endTime == "") {
				return;
			}
			var result = timeMath.sub(endTime + ':00', startTime + ':00');
			result = timeMath.sub(result + ':00', breakTime + ':00');
			document.getElementById('topFormList' + index + '.totalTime').value = result;
		};

		var timeMath = {
				// 加算
				sum : function() {
					var result, times, second, i,
						len = arguments.length;
					if (len === 0) return;
					for (i = 0; i < len; i++) {
					if (!arguments[i] || !arguments[i].match(/^[0-9]+:[0-9]{2}:[0-9]{2}$/)) continue;
						times = arguments[i].split(':');
						second = this.toSecond(times[0], times[1], times[2]);
						if ((!second && second !== 0)) continue;
						if (i === 0) {
							result = second;
						} else {
							result += second;
						}
					}
					return this.toTimeFormat(result);
			    },

			    // 減算
				sub : function() {
					var result, times, second, i,
						len = arguments.length;
					if (len === 0) return;

					for (i = 0; i < len; i++) {

						if (!arguments[i] || !arguments[i].match(/^[0-9]+:[0-9]{2}:[0-9]{2}$/)) continue;

						times = arguments[i].split(':');

						second = this.toSecond(times[0], times[1], times[2]);

						if (!second) continue;

						if (i === 0) {
							result = second;
						} else {
							result -= second;
						}
					}

					return this.toTimeFormat(result);
				},

			    // 乗算
				multiply : function() {
					var result, times, second, i,
						len = arguments.length;

					if (len === 0) return;

					for (i = 0; i < len; i++) {
						if (!arguments[i] || !arguments[i].match(/^[0-9]+:[0-9]{2}:[0-9]{2}$/)) continue;

						times = arguments[i].split(':');

						second = this.toSecond(times[0], times[1], times[2]);

						if (!second) continue;

						if (i === 0) {
							result = second;
						} else {
							result *= second;
						}
					}

					return this.toTimeFormat(result);
				},

				// 除算
				division : function() {
					var result, times, second, i,
						len = arguments.length;

					if (len === 0) return;

					for (i = 0; i < len; i++) {
						if (!arguments[i] || !arguments[i].match(/^[0-9]+:[0-9]{2}:[0-9]{2}$/)) continue;

						times = arguments[i].split(':');

						second = this.toSecond(times[0], times[1], times[2]);

						if (!second) continue;

						if (i === 0) {
			                result = second;
						} else {
							result /= second;
						}
					}

					return this.toTimeFormat(result);
				},

				// 時間を秒に変換
				toSecond : function(hour, minute, second) {
					if ((!hour && hour !== 0) || (!minute && minute !== 0) || (!second && second !== 0) ||
						hour === null || minute === null || second === null ||
						typeof hour === 'boolean' ||
						typeof minute === 'boolean' ||
						typeof second === 'boolean' ||
						typeof Number(hour) === 'NaN' ||
						typeof Number(minute) === 'NaN' ||
						typeof Number(second) === 'NaN') return;

					return (Number(hour) * 60 * 60) + (Number(minute) * 60) + Number(second);
				},

				// 秒を時間（hh:mm:ss）のフォーマットに変換
				toTimeFormat : function(fullSecond) {
					var hour, minute, second;

					if ((!fullSecond && fullSecond !== 0) || !String(fullSecond).match(/^[\-0-9][0-9]*?$/)) return;

					var paddingZero = function(n) {
						return (n < 10)  ? '0' + n : n;
					};

					hour   = Math.floor(Math.abs(fullSecond) / 3600);
					minute = Math.floor(Math.abs(fullSecond) % 3600 / 60);
					second = Math.floor(Math.abs(fullSecond) % 60);

					hour = paddingZero(hour);
					minute = paddingZero(minute);
					second = paddingZero(second);

					return ((fullSecond < 0) ? '-' : '') + hour + ':' + minute;
				}
			};
	</script>
</html>