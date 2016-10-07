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
                <h2>Create Task</h2>
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
	       	<g:form controller="task" action="save">
            	<label>Summary: </label>
	            <g:textField name="summary"/><br/><br/>
	            <label>Details: </label>
	            <g:textArea name="details" rows="5" cols="40"/><br/><br/>
	            <label>Deadline: </label>
	            <g:datePicker name="deadline" value="${new Date()}" precision="day" noSelection="['':'-Choose-']" relativeYears="[-2..7]"/><br/><br/>
	            <label>Status: </label>
	            <g:select name="status" from="${['Done', 'Open']}" value="${status}"/><br/><br/>
	            <label>Tags: </label>
	            <g:select name="tags" from="${tags}" optionKey="id" value="" multiple="true"/><br/><br/>
	            <g:actionSubmit value="Save"/>
        	</g:form>
	       </table>
        </div>
    </div>
</body>
</html>