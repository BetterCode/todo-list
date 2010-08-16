<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<h1>This are the tasks</h1>

<p style="padding: 23px; color:#55AA55">${message}</p>

<c:forEach items="${taskList}" var="task">
	<ul>
	  <li><h2>${task.title}</h2></li><br/>
	  <li><strong>Executor:</strong> ${task.executor}</li>
	  <li><strong>Description:</strong> ${task.descr}</li>
	  <li><strong>Created At:</strong> ${task.createdAt}</li>
	  <li><strong>Started At:</strong> ${task.startedAt}</li>
	  <li><strong>Finished At:</strong> ${task.finishedAt}</li>
	</ul><br/>
</c:forEach>