<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<jsp:include page="../WEB-INF/components/header.jsp"/>   
<body> 
    <h1 class="text-center">Lista de logeos a la pagina</h1>

<c:forEach items="${listaLogins}" var="login">
    <div class="card">
        <h5 class="card-header">Numero de id: ${login.id}</h5>
        <div class="card-body">
        <p>Fecha de Inicio de sesion: ${login.dia} ${login.hora}</p>
        </div>
    </div>
</c:forEach>
</body>
<jsp:include page="../WEB-INF/components/footer.jsp"/>


</html>