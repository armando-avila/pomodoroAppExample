import org.example.pomodoroApp.Tag
import org.example.pomodoroApp.Task

class BootStrap {

    def init = { servletContext ->
		def workTag = new Tag(name:"Work").save(failOnError: true)
		def homeworkTag = new Tag(name:"Homework").save(failOnError: true)
		def dogTag = new Tag(name:"Dog").save(failOnError: true)
		
		def task1 = new Task(
			summary: "Task #1",
			details: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam lacinia a justo ac tristique. Proin et fermentum nulla. Suspendisse interdum sit amet arcu quis tempor. Nam vitae consectetur nulla, id molestie metus. Sed sit amet tristique arcu. Aliquam condimentum congue efficitur. Morbi pretium congue orci nec euismod. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam purus ante, pulvinar venenatis aliquet vel, commodo a risus. Nunc sed nibh eu orci rutrum molestie et ultricies arcu. Donec id odio eget metus mollis tempus vel nec nulla. Nullam vitae lacus eget justo sodales blandit a id neque. Nam mattis ligula lorem, eget facilisis velit malesuada in. Donec feugiat metus non feugiat faucibus. Cras varius, leo vel pharetra pellentesque, augue risus molestie arcu, vel consectetur ante orci sed felis. Etiam eget maximus purus.",
			status: "Open",
			deadline: new Date()-5,
			dateCreated: new Date()
			)
		
		task1.addToTags(workTag).save(failOnError:true)
		task1.addToTags(dogTag).save(failOnError:true)
		
		
		def task2 = new Task(
			summary: "Task #2",
			details: "Donec nisi libero, tincidunt dapibus tristique nec, sodales ut arcu. Phasellus leo erat, aliquam id fermentum ut, posuere at ipsum. Mauris fringilla nisi in venenatis interdum. Morbi suscipit rutrum nisi ut commodo. Nam eu accumsan ex. Cras eleifend orci nec tortor tempus blandit. Vivamus consequat molestie consectetur. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi consequat egestas velit eu sollicitudin. Nulla vitae augue tellus. Donec a mi dolor. Aliquam sit amet est orci. Maecenas sagittis mattis est vitae condimentum. Phasellus mattis cursus tellus sed dictum. ",
			status: "Open",
			deadline: new Date(),
			dateCreated: new Date()
			)
		
		task2.addToTags(homeworkTag).save(failOnError:true)
		task2.addToTags(dogTag).save(failOnError:true)
		
		def task3 = new Task(
			summary: "Task #3",
			details: """\
						Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \

						Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \
						Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.""",
			status: "Open",
			deadline: new Date()+3,
			dateCreated: new Date(2006,1,1)
			)
		
		task3.addToTags(workTag).save(failOnError:true)
		
		def task4 = new Task(
			summary: "Task #4",
			details: """\
						Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \
						Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.""",
			status: "Done",
			deadline: new Date()+4,
			dateCreated: new Date(2009,1,1)
			)
		
		task4.addToTags(dogTag).save(failOnError:true)
    }
	
    def destroy = {
    }
}
