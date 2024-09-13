<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<jsp:include page="../WEB-INF/components/header.jsp"/>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
            padding-bottom: 50px;
        }
        .container-form {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            padding: 30px 15%;
            width: 70%;
            margin-bottom: 30px;
        }
        .btn-primary {
            width: 20%;
        }
    </style>
</head>

<body>
<div class="formcenter">
    <div class="container container-form">
        <form action="${pageContext.request.contextPath}/form" method="post">
            <div class="mb-3">
                <label for="Detalle" class="form-label">Detalle</label>
                <textarea class="form-control" id="Detalle" name="Detalle" rows="3"></textarea>
            </div>
            <div class="mb-3">
                <label for="Direccion" class="form-label">Direccion</label>
                <input type="text" class="form-control" id="Direccion" name="Direccion">
            </div>
            <div class="mb-3">
                <select id="inputState" name="tipoReclamo" class="form-select">
                    <option>PLUVIAL</option>
                    <option>ARBOLADO</option>
                    <option>ILUMINACION</option>
                    <option>LIMPIEZA</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBMbv9tI1VgFJdoTHtXsovbs4X-ntWoYMk&libraries=places"></script>
<script src="./js/autocompletado.js"></script>
</body>
<jsp:include page="../WEB-INF/components/footer.jsp"/>
</html>
