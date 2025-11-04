<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:pageTemplate pageTitle="Cars">
    <div class="container text-center mt-4">
        <h1>Cars</h1>

        <!-- Header row -->
        <div class="row fw-bold border-bottom py-2">
            <div class="col">Identifier</div>
            <div class="col">Parking Spot</div>
            <div class="col">Owner</div>
        </div>

        <!-- Car 1 -->
        <div class="row py-2 border-bottom">
            <div class="col">B-123-XYZ</div>
            <div class="col">A12</div>
            <div class="col">John Doe</div>
        </div>

        <!-- Car 2 -->
        <div class="row py-2 border-bottom">
            <div class="col">CJ-45-MTR</div>
            <div class="col">B07</div>
            <div class="col">Maria Popescu</div>
        </div>

        <!-- Car 3 -->
        <div class="row py-2 border-bottom">
            <div class="col">SB-99-RXN</div>
            <div class="col">C02</div>
            <div class="col">Alex Ionescu</div>
        </div>
    </div>
    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
