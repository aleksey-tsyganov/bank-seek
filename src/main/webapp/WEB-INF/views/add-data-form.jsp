<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<title>Title</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-form-style.css">

</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Банковские идентификационные коды</h2>
		</div>
	</div>

	<div id="container">
		<h3>Форма добавления данных</h3>

		<form:form action="saveBankSeek" modelAttribute="bankSeek" method="POST">

			<form:hidden path="vkey"/>
			${message}
			<table>
				<tbody>
				<tr>
					<td><label>Код типа участника*:</label></td>
					<td><form:input path="uer" /></td>
				</tr>

				<tr>
					<td><label>Код территории РФ*:</label></td>
					<td><form:input path="rgn" /></td>
				<tr>
				<tr>
					<td><label>Наименование участника*:</label></td>
					<td><form:input path="namep" /></td>
				</tr>
				<tr>
					<td><label>Наименование участника расчетов для поиска в ЭБД*:</label></td>
					<td><form:input path="namen" /></td>
				</tr>
				<tr>
					<td><label>БИК*:</label></td>
					<td>
						<form:input path="newnum" />
					</td>
				</tr>
				<tr>
					<td><label>Срок прохождения документов*:</label></td>
					<td><form:input path="srok" /></td>
				</tr>
				<tr>
					<td><label>Дата последнего изменения записи*:</label></td>
					<td><form:input path="dtIzm" /></td>
				</tr>
				<tr>
					<td><label>Дата включения информации в ЭБД*:</label></td>
					<td><form:input path="dateIn" /></td>
				</tr>
				<tr>
					<td><label>Дата контроля:</label></td>
					<td>
						<form:input path="dateCh" />
					</td>
				</tr>
				<tr>
					<td><label>Код контроля:</label></td>
					<td><form:input path="real" /></td>
				</tr>
				<tr>
					<td><label>Код типа участника:</label></td>
					<td><form:input path="pzn" /></td>
				</tr>
				<tr>
					<td><label>Индекс:</label></td>
					<td><form:input path="ind" /></td>
				</tr>
				<tr>
					<td><label>Код типа населенного пункта:</label></td>
					<td><form:input path="tnp" /></td>
				</tr>
				<tr>
					<td><label>Населенный пункт:</label></td>
					<td><form:input path="nnp" /></td>
				</tr>
				<tr>
					<td><label>Адрес:</label></td>
					<td><form:input path="adr" /></td>
				</tr>
				<tr>
					<td><label>БИК РКЦ:</label></td>
					<td><form:input path="rkc" /></td>
				</tr>
				<tr>
					<td><label>Телефон:</label></td>
					<td><form:input path="telef" /></td>
				</tr>
				<tr>
					<td><label>ОКПО:</label></td>
					<td><form:input path="okpo" /></td>
				</tr>
				<tr>
					<td><label>Номер счета:</label></td>
					<td><form:input path="ksnp" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Сохранить" class="save" /></td>
				</tr>
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/bnkseek/list">Вернуться к списку</a>
		</p>

	</div>

</body>

</html>










