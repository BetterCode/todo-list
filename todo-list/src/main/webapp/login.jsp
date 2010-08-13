<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
</head>
<body onload='document.f.j_username.focus();'>
<h3>Entre com seu usuário e senha</h3>
<script>
$(document).ready(function(){
 <c:if test="${not empty param.login_error}">
      addError("Falha ao tentar logar, tente novamente.");
      //addError("Motivo: ${SPRING_SECURITY_LAST_EXCEPTION.message}");
      showError();
 </c:if>
});
</script>
<form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
<div class="main">
	<div class="divBoxDados">
    	<p class="tituloDiv">Login</p>
        <ul class="ulAlt">
        	<li class="liMaior">
        		<label style="float: left; width: 50px;">Usuário:</label>
        		<input type='text' name='j_username' value="<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>"/>
        	</li>
            <li class="liMaior">
            	<label style="float: left; width: 50px;">Senha:</label>
            	<input type='password' name='j_password' />
            </li>
            <li class="liMaior">
            	<input class="btEntrar" type="submit" />
            </li>
        </ul>
	</div>
</div>
</form>
</body>
</html>