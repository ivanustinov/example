<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Cart"/>
</jsp:include>
<hr>
<h1 align="center">CART</h1>
<c:set var="page" scope="page" value="WEB-INF/views/cart.jsp"/>
<div align="center">
    <%--<h4 align='center'>Login: ${user.login}</h4>--%>
    <%--<h4 align='center'>Role: ${user.role}</h4>--%>
    <c:if test="${cart.size() == 0}">
        <div align="center">There are no buses in the cart</div>
    </c:if>
    <c:if test="${cart.size() > 0}">
        <table align='center' border='2' cellspacing='0' cellpadding='2'>
            <caption>Buses in the cart</caption>
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
            <c:forEach items="${cart.keySet()}" var="id" varStatus="status">
                <c:set var="product" scope="session" value="${list.get(id)}"/>
                <tr align="center">
                    <td>${status.index + 1}</td>
                    <td>${product.price}</td>
                    <td>${product.seazon}</td>
                    <td>${product.manufacturer}</td>
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
        <p align="center">
            <button type='submit'>Exit</button>
        </p>
    </form>
</div>
<hr>
<jsp:include page="../views/footer.jsp"/>