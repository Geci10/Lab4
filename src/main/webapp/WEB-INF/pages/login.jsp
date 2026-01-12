<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Login">

    <c:if test="${message != null}">
        <div class="alert alert-warning" role="alert">
                ${message}
        </div>
    </c:if>

    <form class="form-signin" method="POST" action="j_security_check">

        <h1 class="h3 mb-3 fw-normal">Sign in</h1>

        <label for="username" class="form-label">Username</label>
        <input type="text" id="username" name="j_username"
               class="form-control" placeholder="Username" required autofocus>

        <label for="password" class="form-label mt-3">Password</label>
        <input type="password" id="password" name="j_password"
               class="form-control" placeholder="Password" required>

        <button class="btn btn-lg btn-primary btn-block mt-4" type="submit">
            Sign in
        </button>
    </form>

</t:pageTemplate>
