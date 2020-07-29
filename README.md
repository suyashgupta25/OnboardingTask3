# Todo Demo App

This is a multi-module project for spring boot integration with JSP. In this project, we demonstrate the CRUD operations for Todos, and it caches the data in the h2 database. 

## Installation

Import the project in the IntelliJ Idea and run the eureka-server first. Since its multiple module project you might need to change the working dirctory of the todo service module and to do that just Edit the Run Configuration of the todo module. There you will find the working directory field and then provide its value as path to todo module's root folder.

Run both the modules and then open [http://localhost:8100/todo/all](http://localhost:8100/todo/all) in the browser.
