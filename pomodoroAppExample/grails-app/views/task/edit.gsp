<!DOCTYPE html>
<html>
<head>
    <title>Pomodoro Task Manager</title>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="span-24 last">Pomodoro Task Manager</h1>
        <div class="span-24 width900">
            <div class="span-16 floatLeft">
                <h2>Edit Task</h2>
            </div>
            <div class="span-4 floatRight">
                <ul class="actions"><li><g:link resource="task" action="create">New Task</g:link></li></ul>
            </div>
        </div>
        <br/>
		<br/>
		<br/>
		<br/>
		<hr/>
        <div class="span-24 width900">
	       <table>
	       	<g:form controller="task" action="update">
	       		<g:hiddenField name="id" value="${task.id}" />
            	<label>Summary: </label>
	            <g:textField name="summary" value="${task.summary}" disabled="true"/><br/><br/>
	            <label>Details: </label>
	            <g:textArea name="details" rows="5" cols="40" value="${task.details}"/><br/><br/>
	            <label>Deadline: </label>
	            <g:datePicker name="deadline" value="${task.deadline}" precision="day" noSelection="['':'-Choose-']" relativeYears="[-2..7]"/><br/><br/>
	            <label>Status: </label>
	            <g:select name="status" from="${['Done', 'Open']}" value="${task.status}"/><br/><br/>
	            <label>Tags: </label>
	            <g:select name="tags" from="${tags}" optionKey="id" value="${task.tags}" multiple="true"/><br/><br/>
	            <g:actionSubmit value="Update"/>
        	</g:form>
	       </table>
        </div>
    </div>
</body>
</html>