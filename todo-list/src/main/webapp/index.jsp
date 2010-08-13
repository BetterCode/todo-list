<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Teste</title>
	</head>
	<body>
		<h1>Kyros Prot�tipo VRaptor</h1>
		<div class="main">
			<div class="box">
				<h3>Cadastro Simples</h3>
				<span class="img">
					<img src="images/banner_nossos_planos.jpg" />
				</span>
				<p>		
					Cadastro Simples.		
				</p>
				<a class="vejaMais" href="<c:url value="/plan/list"/>">Acessar</a> 
			</div>
			<div class="box">
				<h3>�rea Restrita</h3>
				<span class="img">
					<img src="images/banner_painel_controle.jpg" />
				</span>
				<p>
					Voc� precisa estar logado para acessar.
				</p>
				<a class="vejaMais" href="${pageContext.request.contextPath}/restricted">Acessar</a> 
			</div>
		</div>
	</body>
</html>