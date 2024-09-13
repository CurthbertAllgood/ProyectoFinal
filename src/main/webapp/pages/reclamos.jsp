<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<jsp:include page="../WEB-INF/components/header.jsp"/>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1 class="text-center">Esta es su lista de Reclamos</h1>

<c:forEach items="${listaReclamos}" var="reclamo">
    <div class="card">
        <h5 class="card-header">Reclamo numero: ${reclamo.id}</h5>
        <div class="card-body">
            <p>Descripcion: ${reclamo.descripcion}</p>
        <p>Fecha de Creacion: ${reclamo.fechaCreacion}</p>
        <p>La resolucion del reclamo es: ${reclamo.detalle}</p>
        <p>Categoria: ${reclamo.categoria}</p>
        <p>ID Persona: ${reclamo.idPersona}</p>
        <a href="#" class="btn btn-danger">Cancelar Reclamo</a>
        </div>
    </div>
</c:forEach>
</body>
<jsp:include page="../WEB-INF/components/footer.jsp"/>
</html>