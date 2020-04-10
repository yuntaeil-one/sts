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




//������Ʈ 
google.charts.load('current', {'packages':['corechart']}); 
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var data = new google.visualization.DataTable();

    data.addColumn('string','�ڻ�');
    data.addColumn('number','�ݾ�');

    var chart = new google.visualization.PieChart(document.getElementById('myChart'));

    var opt = {
            'title':'�ڻ� ����',
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
		<p align="center" style="font-size: 50px;">���� �ڻ� ��Ȳ</p>
		<div align="right">
			<a href="/account/create"><button type="button" class="btn btn-primary">Create</button></a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>�ڻ� ����</th>
					<th>�ݾ�</th>
					<th>���¼�</th>
					<th>���ڱݾ�</th>
					<th>�������</th>
					<th>��������</th>
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