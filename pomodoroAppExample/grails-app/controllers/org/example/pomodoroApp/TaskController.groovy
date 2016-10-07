package org.example.pomodoroApp

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;

class TaskController {
	//static scaffold = Task
	
	def index = {
		def tasks = Task.findAllByStatus("Open", [sort: "deadline", order: "asc"])
		def tags = Tag.list(sort:"name", order: "asc")	
		
		return[tasks: tasks, tags:tags]
	}
	
	def list = {
			def orderType = params.type.toString()
			def orderTag = params.tag.toString()
			def tasks = null
			def orderTitle = null
			
			
			if(!orderType.equals("null")){
				if(orderType.equals('Open')){
					tasks = Task.findAllByStatus("Open", [sort: "deadline", order: "asc"])
				}
				
				if(orderType.equals('Done')){
					tasks = Task.findAllByStatus("Done", [sort: "deadline", order: "asc"])
				}
				
				if(orderType.equals('All')){
					tasks = Task.list([sort: "deadline", order: "asc"])
				}
				
				orderTitle = "Order tasks by status: "+orderType
			}else{
				if(!orderTag.equals("null")){
					tasks = Task.withCriteria {
					  tags {
					    eq('name', orderTag)
					  }
					}
				}
				orderTitle = "Order tasks by tag: "+orderTag
			}
			
			def tags = Tag.list(sort:"name", order: "asc")
			
			return[tasks: tasks, tags:tags, orderType:orderType, orderTitle:orderTitle]
	}
	
	
	def create = {
		def tags = Tag.list(sort:"name", order: "asc")
		
		return[tags:tags]
	}
	
	def save = {
		def summary = params.summary
		def details = params.details
		def status = params.status
		def deadline = params.deadline
		def tags = params.tags
		
		def task = new Task(
			summary: summary,
			details: details,
			status: status,
			deadline: deadline,
			dateCreated: new Date()
			)
		
		for ( String tag : tags ) {
			task.addToTags(Tag.get(tag))
		}
		
		task.save(failOnError:true)
		redirect(action: "list", params: [type: "All"])
	}
	
	def update = {
		def id = params.id
		def task = Task.get(id)
		def details = params.details
		def status = params.status
		def deadline = params.deadline
		def tags = params.tags.toList()
		
		task.setDetails(details)
		task.setDeadline(deadline)
		task.setStatus(status)
		task.tags.clear()
		
		for ( String tag : tags ) {
			task.addToTags(Tag.get(tag))
		}
				
		task.save(failOnError:true)
		redirect(action: "list", params: [type: "All"])
	}
	
	
	def edit = {
		def tags = Tag.list(sort:"name", order: "asc")
		def id = params.id
		def task = Task.get(id)
		
		return[task: task, tags:tags]
	}
	
}

