<h1>Create a new Task</h1>
<br/>
<form action="createTask" method="post">
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
		<input type="submit" value="Create"/>
	</li>
</ul>
</form>

