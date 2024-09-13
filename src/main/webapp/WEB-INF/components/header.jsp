<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/estilos.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Document</title>
</head>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
    <div>
        <ul  class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Municipio Carlos Ortiz</a>
            </li>
            <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/contactos.jsp">Lista de Contactos</a>
            </li>
            <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/loggers">Lista de logeos</a>
            </li>
        </ul>
    </div>
    <div class="d-flex" role="search">
        <a class="nav-link active" href="${pageContext.request.contextPath}/login" >Log In <i class="bi bi-person"></i></a>
        <a> | </a>
        <a class="nav-link active" href="${pageContext.request.contextPath}/logout">Log out <i class="bi bi-person"></i></a>
    </div>
    </div>
</nav>    
