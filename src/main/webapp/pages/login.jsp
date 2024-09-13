<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/estilos.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Login</title>
</head>
<body class="body-login">
    
<c:if test="${hayError}">
    <div class="container mt-3 p-3 bg-danger text-light">
        <h2>${mensajeError}</h2>
    </div>
</c:if>

<div class="login">
    <!--Formulario-->
    <h3 class="text-center">¡Bienvenido!</h3>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <!--input Usuario-->
        <div class="form-group">
            <label class="form-label" for="user">Usuario</label>
            <input class="form-control" type="text" id="user" name="user" required>
        </div>
        
        <!--input Contraseña-->
        <div class="form-group">
            <label class="form-label" for="password">Contraseña</label>
            <input class="form-control" type="password" id="password" name="password" required>
        </div>
        
        <!--Boton de recuérdame-->
        <div class="form-group">
            <input class="form-check-input" type="checkbox" id="check">
            <label class="form-check-label" for="check">Recuérdame</label> 
        </div>
        
        <!-- Campo oculto para la redirección de origen -->
        <input type="hidden" name="origen" value="${param.origen}">

        <input class="btn btn-success w-100" type="submit" value="Login">
    </form>
    <!-- Campo oculto para la redirección después del inicio de sesión -->
    <input type="hidden" name="redirect" value="index.jsp">

    <p class="mb-0 text-center"><a href="#" class="text-decoration-none">Olvidé mi contraseña</a></p>
    <p class="mb-0 text-center">¿No estás registrado? <a href="#" class="text-decoration-none">Registrarme</a></p>
</div>

<jsp:include page="../WEB-INF/components/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
