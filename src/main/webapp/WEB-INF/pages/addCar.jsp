<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Add Car">
    <div class="container mt-4">
        <h1 class="mb-4">Add Car</h1>

        <!-- FORM -->
        <form class="needs-validation" novalidate
              method="POST"
              action="${pageContext.request.contextPath}/AddCar">

            <!-- License plate -->
            <div class="row mb-3">
                <div class="col-md-6 mb-3">
                    <label for="license_plate" class="form-label">License Plate</label>
                    <input type="text"
                           class="form-control"
                           id="license_plate"
                           name="license_plate"
                           required>
                    <div class="invalid-feedback">
                        License Plate is required.
                    </div>
                </div>
            </div>

            <!-- Parking spot -->
            <div class="row mb-3">
                <div class="col-md-6 mb-3">
                    <label for="parking_spot" class="form-label">Parking Spot</label>
                    <input type="text"
                           class="form-control"
                           id="parking_spot"
                           name="parking_spot"
                           required>
                    <div class="invalid-feedback">
                        Parking Spot is required.
                    </div>
                </div>
            </div>

            <!-- Owner dropdown -->
            <div class="row mb-4">
                <div class="col-md-6 mb-3">
                    <label for="owner_id" class="form-label">Owner</label>
                    <select class="form-select" id="owner_id" name="owner_id" required>
                        <option value="">Choose...</option>

                        <!-- options will be filled from servlet -->
                        <c:forEach var="user" items="${users}">
                            <option value="${user.id}">${user.username}</option>
                        </c:forEach>
                    </select>
                    <div class="invalid-feedback">
                        Please select an owner.
                    </div>
                </div>
            </div>

            <!-- Save button -->
            <button class="btn btn-primary btn-lg" type="submit">Save</button>
        </form>
    </div>
</t:pageTemplate>
