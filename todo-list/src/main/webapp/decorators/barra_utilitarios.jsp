<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div id="loadBarAjax" class="divLoad" style="display: none;">
	<img style="margin-top: 3px;" src="images/carregando.gif" />
	<span id="loadMessage" class="loadBarAjaxText"> Carregando...</span>
</div>

<div class="content_barra_utilitarios">
  <div class="barra_utilitarios">
    <ul class="acessos">
      <li>VRaptor é foda</li>
    </ul>
    <ul class="sac">
      <security:authorize ifAnyGranted="ROLE_USER" >
        <security:authentication property="name"/> | 
      	<a id="loginTop" href="${pageContext.request.contextPath}/j_spring_security_logout">Sair</a>
      </security:authorize>
      <security:authorize ifNotGranted="ROLE_USER" >
      	<a id="loginTop" href="${pageContext.request.contextPath}/restricted">Entrar</a>
      </security:authorize>
    </ul>
  </div>
</div>