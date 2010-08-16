<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<h1>This are the tasks</h1>

<p style="padding: 23px; color:#55AA55">${message}</p>

<c:forEach items="${taskList}" var="task">
	<ul>
	  <li>
	  	<h2>${task.title}</h2>
	  </li>
	  <br/>
	  <li><strong>Executor:</strong> ${task.executor}</li>
	  <li><strong>Description:</strong> ${task.descr}</li>
	  <li>
	  	<strong>Created At:</strong> 
	  	<f:formatDate value="${task.createdAt}" type="DATE" pattern="dd/MM/yyyy"/>
	  </li>
	  <li>
	  	<strong>Started At:</strong> 
	  	<f:formatDate value="${task.startedAt}" type="DATE" pattern="dd/MM/yyyy"/>
	  </li>
	  <li>
	  	<strong>Finished At:</strong> 
	  	<f:formatDate value="${task.finishedAt}" type="DATE" pattern="dd/MM/yyyy"/>
	  </li>
	  <div style="padding:5px">
	  <c:if test="${not task.started}">
	    |
	  	<a style="color:#5A5" href="start?id=${task.id}">start</a> 
	  </c:if>
	  <c:if test="${not task.finished}">
	  	|
	 	<a style="color:#A55" href="finish?id=${task.id}">finish</a>
	 	|
	  </c:if>
	 	<br/>
	  </div>
	</ul><br/>
</c:forEach>