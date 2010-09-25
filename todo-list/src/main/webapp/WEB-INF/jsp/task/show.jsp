<ul>
  <li>
  	<h2>${task.title}</h2>
  </li>
  <br/>
  <li><strong>Executor:</strong> ${task.executor}</li>
  <li><strong>Description:</strong> ${task.description}</li>
  <li>
  	<strong>Created At:</strong> 
  	<f:formatDate value="${task.createdAt}" type="DATE" pattern="dd/MM/yyyy hh:mm"/>
  </li>
  <c:if test="${task.started}">
	  <li>
	  	<strong>Started At:</strong> 
	  	<f:formatDate value="${task.startedAt}" type="DATE" pattern="dd/MM/yyyy hh:mm"/>
	  </li>
  </c:if>
  <c:if test="${task.finished}">
	  <li>
	  	<strong>Finished At:</strong> 
	  	<f:formatDate value="${task.finishedAt}" type="DATE" pattern="dd/MM/yyyy hh:mm"/>
	  </li>
  </c:if>
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