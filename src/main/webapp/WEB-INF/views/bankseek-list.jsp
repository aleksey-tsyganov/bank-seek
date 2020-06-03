<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Банковские идентификационные коды</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">
            <form:form action="search" method="GET">
                <input type="text" name="keyword" placeholder="Введите Код территории">
                <button type="submit" value="Поиск">Поиск</button>
            </form:form>

            <input type="button" value="Добавить информацию"
                   onclick="window.location.href='showAddForm'; return false;"
                   class="add-button">

            <table>
                <tr>
                    <th>Код контроля</th>
                    <th>Код типа участника</th>
                    <th>Код пользователя системы</th>
                    <th>Код территории РФ</th>
                    <th>Индекс</th>
                    <th>Код типа населенного пункта</th>
                    <th>Населенный пункт</th>
                    <th>Адрес</th>
                    <th>БИК РКЦ</th>
                    <th>Наименование участника</th>
                    <th>БИК</th>
                    <th>Телефон</th>
                    <th>Рег. номер</th>
                    <th>ОКПО</th>
                    <th>Дата последнего изменения</th>
                    <th>Номер счета</th>
                    <th>Дата включения информации в ЭБД</th>
                    <th>Дата контроля</th>
                    <th>Действия</th>
                </tr>

                <c:forEach var="bankseek" items="${bankSeekList}">

                    <c:url var="updateLink" value="/bnkseek/showFormForUpdate">
                        <c:param name="bankVkey" value="${bankseek.vkey}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/bnkseek/delete">
                        <c:param name="bankVkey" value="${bankseek.vkey}"/>
                    </c:url>

                    <tr>
                        <td>${bankseek.real}</td>
                        <td>${bankseek.pzn}</td>
                        <td>${bankseek.uer}</td>
                        <td>${bankseek.rgn}</td>
                        <td>${bankseek.ind}</td>
                        <td>${bankseek.tnp}</td>
                        <td>${bankseek.nnp}</td>
                        <td>${bankseek.adr}</td>
                        <td>${bankseek.rkc}</td>
                        <td>${bankseek.namep}</td>
                        <td>${bankseek.newnum}</td>
                        <td>${bankseek.telef}</td>
                        <td>${bankseek.regn}</td>
                        <td>${bankseek.okpo}</td>
                        <td>${bankseek.dt_izm}</td>
                        <td>${bankseek.ksnp}</td>
                        <td>${bankseek.date_in}</td>
                        <td>${bankseek.date_ch}</td>

                        <td>
                            <a href="${updateLink}">Изменить</a>
                            |
                            <a href="${deleteLink}" onclick="if (!(confirm('Уверены что хотите удалить запись?'))) return false">Удалить</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>

        </div>

    </div>

</body>
</html>
