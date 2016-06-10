# Augmentra_Test
Interview test_Augmentra </br>

Technologies used: </br>
1 MVP Design Pattern:</br>
	1.1 It avoids to be loosely coupled with the models</br>
	1.2 Takes out logic from the view, thus allows to test without instrumentation</br>
	1.3 Allows us to divide app into three different layers</br>

2 Dagger Dependency Injection: </br>
2.1 Injected presenter </br>
2.2 Easy configuration of complex dependencies. </br>
There is an implicit order in which your objects are often created. Dagger 2 walks through the dependency graph and generates code that is both easy to understand and trace, while also saving you from writing the large amount of boilerplate code you would normally need to write by hand to obtain references and pass them to other objects as dependencies. It also helps simplify refactoring, since you can focus on what modules to build rather then focusing on the order in which they need to be created.
