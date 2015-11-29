# Object Diagram Modeling #
Based on the objects defined in _Class Diagram_ you will begin to define the _Planning Problem_. This objects are instances of this classes.

The first step is select for this project from _itSIMPLE\_main screen, the_Planning Domain_option in the_Projects Manager_panel:_

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/inspector_object.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/inspector_object.png)

## _The Object Respository_ ##

The _Object Respository_ is where we will have instances of classes (_Objects_), so that the goal is to store all objects which will be used in the _Initial_ and _Goal_ states represented by _Objects Diagram_.

For create a new diagram you must do right click and select _Open Diagram_ option and will appear in the _Diagram View_ a tool bar with all components for modeling process:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/object_repositoy.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/object_repositoy.png)

### _Toolbox Elements and connectors_ ###

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/toolbarObject.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/toolbarObject.png)

An object (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/object.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/object.png)) is  a particular instance of a Class.

For create an _Object_ with _itSIMPLE_ tool, you must click on the _Object_ icon (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/object.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/object.png)) at the toolbar and choose on the _Diagram View Area_ where you want put it. After that you can define in _Object Properties_ panel, a _name_, select a class for which a _object_ is instance, and some brief description.

You can assigned values to Object's attributes in the _Object Properties_:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/property_object.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/property_object.png)

When you need to create several objects of the same type, you can use _Multi Object_ (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/multiobjects.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/multiobjects.png)) and will be appear a new panel for it:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/multiobjects_def.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/multiobjects_def.png)
Now you can choose the right class, a quantity of objects and a list of number for each objects. Beside you can define _object association_ between objects (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/association.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/association.png)).

So you can open the initial(goal) State written as Snapshot- init(goal). In the Additional properties panel displays all objects for adding in the initial or goal states.

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/panel_additional.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ObjectDiagram/panel_additional.png)

Now you can define a very essencial part of _Planning Problem_ through the initial and goal state with all objects involved in the real problem.

  * [Analysis](Analysis.md)