<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>

<h1>This are the tasks</h1>

<p style="text-align:right"><a id="newTask" href="#" >New Task</a></p>

<p style="padding: 23px; color:#55AA55">${message}</p>

<div id="create" style="display:none">
	<h2>Create a new Task</h2>
	<br/>
	<form id="createForm">
		<ul class="ulForm">
			<li>
				<label for="title">Title:</label> 
				<input type="text" id="title" name="title" />
			</li>
			<li>
				<label for="executor">Executor:</label> 
				<input type="text" id="executor" name="executor" />
			</li>
			<li>
				<label for="description">Description:</label> 
				<textarea id="description" name="description" rows="5" cols="17"></textarea>
			</li>
			<li>
				<a id="createAction" href="#">Create</a>
			</li>
		</ul>
	</form>
</div>

<div id="taskList">
	<c:forEach items="${taskList}" var="task">
		<ul id="task${task.id}">
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
		  	<a style="color:#5A5" task_id="${task.id}" id="start" href="#">start</a> 
		  </c:if>
		  <c:if test="${not task.finished}">
		  	|
		 	<a style="color:#A55" task_id="${task.id}" id="finish" href="#">finish</a>
		 	|
		  </c:if>
		 	<br/>
		  </div>
		</ul><br/>
	</c:forEach>
</div>

<script>
	$('#newTask').click(function(){
		$('#create').slideDown();
	});
	
	$('#createAction').click(function(){
		$.post('create', $('#createForm').serialize(), function(data){
			 $("#taskList").html(data + $("#taskList").html());
		});
	});
	
	$('#taskList').delegate('#start', 'click', function(){
		var task_id = $(this).attr('task_id')
		$.post('start', {id : task_id}, function(data){
			var task = "#task" + task_id;
			$(task).html(data);
		})
	});
	
	$('#taskList').delegate('#finish', 'click', function(){
		var task_id = $(this).attr('task_id')
		$.post('finish', {id : task_id}, function(data){
			var task = "#task" + task_id;
			$(task).html(data);
		})
	});
</script>