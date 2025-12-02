<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:pageTemplate pageTitle="Users">

    <div class="container mt-4">
        <h1 class="mb-4">Users</h1>

        <table class="table table-striped table-bordered align-middle shadow-sm">
            <thead class="table-dark">
            <tr>
                <th scope="col">Username</th>
                <th scope="col">Email</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty users}">
            <div class="alert alert-warning text-center mt-4">
                No users found.
            </div>
        </c:if>

    </div>

</t:pageTemplate>
