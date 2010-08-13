<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="content-language" content="pt-br" />
	
	<meta name="robots" content="index,follow" />
	<meta name="rating" content="general" />
	
	<title><decorator:title default="Kyros Protótipo"/></title>	
	
	<link href="<%=request.getContextPath()%>/styles/ctbc.css" rel="stylesheet" type="text/css" media="screen">
	<link href="<%=request.getContextPath()%>/styles/estilos.css" rel="stylesheet" type="text/css" media="screen">
	
	<!-- DWR Utils -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/dwrutils.js"></script>
	
	<!-- JQuery and JQuery Plugins -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskedinput-1.2.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.numeric.pack.js"></script>
	
	<!--[if lte IE 6]>        
		<style type="text/css">body { behavior:url(js/csshover.htc)}</style>
	<![endif]-->
	
	<script type="text/javascript">
	$(document).ready(function(){
		$(window).ajaxStart(function() {
			$("#loadBarAjax").slideDown();
		});
		$(window).ajaxStop(function() {
			$("#loadBarAjax").fadeOut();
		});
		
		$(document).click(function() {
			$("errorWrap").fadeOut();
		});
	});

	function clearError() {
		$("#errorMessages").html("");
	}
	function showError(message) {
		if(typeof(message) != 'undefined') {
			$("#errorMessages").html("<li>" + message + "</li>");
		}
		$(".errorWrap").fadeIn();
	}
	function addError(message) {
		$("#errorMessages").each(function() {
			$(this).html($(this).html() + ("<li>" + message + "</li>"));
		});
	}
	</script>
</head>

<body>
	<%@ include file="barra_utilitarios.jsp" %>
	
	<div class="wrap">
		<%@ include file="header.jsp" %>		
		<%@ include file="menu.jsp" %>		

		<%@ include file="menuLeft.jsp" %>
		<div class="contentWrap">
			<decorator:body />
		</div>
		<div class="errorWrap" style="display: none;" onclick="javascript:$('.errorWrap').fadeOut();">
			<div class="errorBox">
				<div class="errorBoxTop"></div>
				<div class="errorBoxCenter">
					<h4 class="erroBoxTitulo">Foram detectados os seguintes erros:</h4>
					<ul id="errorMessages">
					</ul>
					<br>
					<h4 class="erroBoxTitulo">Clique para continuar.</h4>
				</div>
				<div class="errorBoxBottom"></div>
			</div>
		</div>
		
		<div style="clear: both;"></div>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>