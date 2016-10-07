<div class="task">
 <div class="task-header floatLeft width50p">
	<h3>${ task.summary }</h3>
 </div>
 <div class="status floatRight width50p alignRight">
 	<b>Status: </b><pomo:statusTask status="${ task.status }"/>
 </div>
 	<br/>
 	<br/>
 	<br/>
    <div><pomo:textToParagraphs>${ task.details }</pomo:textToParagraphs></div>
    <div class="floatLeft due">Due: <pomo:deadline date="${ task.deadline }"/></div>
    <div class="floatRight created">Created: <pomo:shortDate date="${ task.dateCreated }"/></div><br/><hr/>
    <div class="floatRight"><g:link resource="task" action="edit" params="[id: "${ task.id }"]">Edit</g:link></div>
    <div class="floatLeft">
    Tags:
    <g:each in="${task.tags}" var="tag">
        <g:link controller="tag" action="show" id="${tag.id}">${tag.name}</g:link>
    </g:each>
    </div>
</div>