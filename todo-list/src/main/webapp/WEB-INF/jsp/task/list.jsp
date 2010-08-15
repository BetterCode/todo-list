<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<c:forEach items="${taskList}" var="task">
	<ul>
	  <li>${task.title}</li>
	  <li>${task.descr}</li>
	  <li>${task.executor}</li>
	  <li>${task.createdAt}</li>
	  <li>${task.startedAt}</li>
	  <li>${task.finishedAt}</li>
	</ul>
</c:forEach>