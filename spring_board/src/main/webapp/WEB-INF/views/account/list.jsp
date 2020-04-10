<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	callAjax();
});


function callAjax() {

$.ajax({
	type : "post",
	url : "/account/api/ExchangeRate",
	data : {},
	success : function(obj) {
		var data = JSON.parse(obj);
	
	}, error : function(xhr, status, error) {
		alert("ERROR");
		}
	
	});

}




//구글차트 
google.charts.load('current', {'packages':['corechart']}); 
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var data = new google.visualization.DataTable();

    data.addColumn('string','자산');
    data.addColumn('number','금액');

    var chart = new google.visualization.PieChart(document.getElementById('myChart'));

    var opt = {
            'title':'자산 구분',
            'width':500,
            'height':500,
            pieSliceText:'label',
            bar : {
	            groupWidth : '50%'
            },
            legend:'bottom' 
    };
    
    <c:forEach items="${accountMap}" var="item" varStatus="loop">
    	data.addRow(['${item.key}', ${item.value}]);	
    	chart.draw(data,opt);
    </c:forEach>
}

</script>
	
</head>
<body>
	<div class="container">
		<p align="center" style="font-size: 50px;">나의 자산 현황</p>
		<div align="right">
			<a href="/account/create"><button type="button" class="btn btn-primary">Create</button></a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>자산 구분</th>
					<th>금액</th>
					<th>계좌수</th>
					<th>투자금액</th>
					<th>등록일자</th>
					<th>수정일자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="account" items="${accountList}">
					<tr>
						<td>${account.type}</td>
						<td>
							<a href="/account/update/${account.type}"><fmt:formatNumber value="${account.balance}" pattern="#,###" /></a>
						</td>
						<td>${account.balanceCnt}</td>
						<td>${account.balance} * ${account.balanceCnt}</td>
						<td>${account.create_dt}</td>
						<td>${account.update_dt}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="myChart" align="center"></div>
</body>
</html>