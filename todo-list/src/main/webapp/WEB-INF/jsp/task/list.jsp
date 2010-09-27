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
		<%@ include file="show.jsp"%>
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
	
	$('#taskList').delegate("a[id^='start'],a[id^='finish']", 'click', function(){
		var task = $(this).attr('id').split('_')
		$.post(task[0], {id : task[1]}, function(data){
			$("#task" + task[1]).html(data);
		})
	});
</script>