<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Catalog"/>
</jsp:include>
<hr>
<h1 align="center">CATALOG</h1>
<div align="center">
    <c:if test="${list.size() == 0}">
        <div align="center">There are no buses in the store</div>
    </c:if>
    <c:if test="${list.size() > 0}">
        <table border='2' cellspacing='0' cellpadding='2'>
            <c:set var="page" scope="page" value="WEB-INF/views/catalog.jsp"/>
            <caption>Buses in the store</caption>
            <tr>
                <th>№</th>
                <th>PRICE</th>
                <th>SEAZON</th>
                <th>MANUFACTURER</th>
                <th>DESCRIPTION</th>
                <th>PAGE</th>
                <th>CART</th>
                <th>COUNT</th>
            </tr>
            <c:forEach items="${list.values()}" var="product" varStatus="status">
                <c:set var="id" scope="session" value="${product.id}"/>
                <tr align="center">
                    <td>${status.index + 1}</td>
                    <td>${product.price}</td>
                    <td>${product.seazon.toString()}</td>
                    <td>${product.manufacturer.toString()}</td>
                    <td>${product.model} ${product.width}/${product.profile_height} ${product.radius}
                            ${product.data}</td>
                    <td>
                        <a href="product?id=${id}">Good page</a>
                    </td>
                    <td id="catalog">
                        <div>
                            <form action="cart" method='post'>
                                <input type='hidden' name='id' value='${id}'>
                                <input type='hidden' name='action' value='add'>
                                <input type='hidden' name='page' value='${page}'>
                                <button type='submit'>ADD</button>
                            </form>
                            <form action="cart" method='post'>
                                <input type='hidden' name='id' value='${id}'>
                                <input type='hidden' name='action' value='delete'>
                                <input type='hidden' name='page' value='${page}'>
                                <button type='submit'>DELETE</button>
                            </form>
                            <form action="cart" method='post'>
                                <input type='hidden' name='id' value='${id}'>
                                <input type='hidden' name='action' value='clearEntity'>
                                <input type='hidden' name='page' value='${page}'>
                                <button type='submit'>CLEAR</button>
                            </form>
                        </div>
                    </td>
                    <td>${cart.get(id)}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <div align="center">
        <div>CART:</div>
        <div>Count of goods: ${totalNumber}</div>
        <br>
        <div>Total summ: ${totalSumm} р.</div>
    </div>
    <form action="cart" method='post'>
        <input type='hidden' name='action' value='clear'>
        <input type='hidden' name='page' value='${page}'>
        <p align="center">
            <button type='submit'>Clear cart</button>
        </p>
    </form>
    <form action="contr" method='post'>
        <input type='hidden' name='action' value='logOut'>
        <input type='hidden' name='page' value='WEB-INF/views/authentification.jsp'>
        <p align="center">
            <button type='submit'>Exit</button>
        </p>
    </form>
</div>
<hr>
<jsp:include page="../views/footer.jsp"/>
