<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<t:pageTemplate pageTitle="Cars">
    <div class="container mt-4">

        <h1 class="mb-4">Cars</h1>

        <form method="POST" action="${pageContext.request.contextPath}/Cars">

            <div class="mb-3 d-flex gap-2">
                <a href="${pageContext.request.contextPath}/AddCar" class="btn btn-primary btn-lg">
                    Add Car
                </a>

                <button class="btn btn-danger btn-lg" type="submit">
                    Delete Cars
                </button>
            </div>

            <div class="container text-center">
                <div class="row fw-bold border-bottom py-2">
                    <div class="col-auto"></div>
                    <div class="col">License Plate</div>
                    <div class="col">Parking Spot</div>
                    <div class="col">Owner</div>
                    <div class="col-auto">Actions</div>
                </div>

                <c:forEach var="car" items="${cars}">
                    <div class="row align-items-center py-2 border-bottom">

                        <div class="col-auto">
                            <input type="checkbox" name="car_ids" value="${car.id}">
                        </div>

                        <div class="col">
                                ${car.licensePlate}
                        </div>

                        <div class="col">
                                ${car.parkingSpot}
                        </div>

                        <div class="col">
                                ${car.ownerName}
                        </div>

                        <div class="col-auto">
                            <a class="btn btn-secondary"
                               href="${pageContext.request.contextPath}/EditCar?id=${car.id}">
                                Edit Car
                            </a>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </form>

        <p class="mt-4 fs-5 fw-bold">Free parking spots: ${freeSpots}</p>
    </div>
</t:pageTemplate>
