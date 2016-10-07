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
                <h2>Tasks</h2>
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
	        <dl class="sidebar">
                <dt>Show</dt>
                <dd>
                    <ul>
                        <li><g:link resource="task" action="list" params="[type: "Open"]">Open</g:link></li>
                        <li><g:link resource="task" action="list" params="[type: "Done"]">Done</g:link></li>
                        <li><g:link resource="task" action="list" params="[type: "All"]">All</g:link></li>
                    </ul>
                </dd>
                <dt>Tags</dt>
                <dd>
                    <ul>
                    <g:each in="${tags}" var="tag">
                        <li><g:link resource="task" action="list" params="[tag: "${tag.name}"]">${tag.name}</g:link></li>
                    </g:each>
                    </ul>
                </dd>
            </dl>
        </div>
    </div>
</body>
</html>