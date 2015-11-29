# _Use Case Diagram_ #

A _Use Case diagram_ of _itSIMPLE4.0_ project, captures _Use Cases_ and relationships among _Actors_ and the _system_. It describes the functional requirements of the system, the manner in which outside things (_Actors_) interact at the system boundary, and the response of the system.
Exemplo:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/cuexample.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/cuexample.png)

Select _Use Case diagram elements_ and _connectors_ of the _Use Case Diagram Tab_ (2:). You most before select _Use Case Diagram- choice in left panel_Manage projects_for the this project (1:):_

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/cuexample3.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/cuexample3.png)

## _Toolbox Elements and Connectors_ ##

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/toolbarCU.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/toolbarCU.png)

### Actor ###

An _Actor_ is a user of the _system_; user can mean a human user, a machine, or even another system or subsystem in the model. Anything that interacts with the system from the outside or system boundary is termed an _Actor_. Actors are typically associated with _Use Cases_.

For create an _Actor_ with _itSIMPLE_ tool, you must click on the _Actor_ icon (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/actor.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/actor.png)) at the toolbar and choose on the _Diagram View Area_ where you want put it.

According to the problem context, you can personalize actors, selecting different icons in the _Properties Object_ panel:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/ator1.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/ator1.png)

It is always useful to choose some [icon](Icons.md) to the actor, because this gives a better interpretation to your _Use Case Diagram_.

In the [Object Properties panel](BasicFuncionalities#Object_Properties.md) you can define some other properties like a _name_ and a _brief description_ of the actor.

### Use Case ###

A _Use Case_ is a _UML_ modeling element that describes how a user of the proposed system interacts with the system to perform a discrete unit of work. It describes and signifies a single interaction over time that has meaning for the end user (person, machine or other system), and is required to leave the system in a complete state: the interaction either completed or rolled back to the initial state.

For create an _Use Case_ with _itSIMPLE_ tool, you must click on the _Use Case_ icon (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/useCase1.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/useCase1.png)) at the toolbar and choose on the _Diagram View Area_ where you want put it.

In the [Object Properties panel](BasicFuncionalities#Object_Properties.md)  you can define some other properties:
  * Base tab: You can specify a _Name_ and _Description_ of this _Use Case_.
  * Contraints: After you have defined the base in the properties, you can specify the _Constraints_ of this Use Case. In the bottom section of this panel will appear four news tabs: ![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/constraintCU.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/constraintCU.png)
    1. The first tab (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/ucpre.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/ucpre.png)) is Pre-Conditions where you can define the pre-conditions of this use case. This constraint answers the question: What do I have to specify as pre-conditions for this use case to work?
    1. The second tab (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/help.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/help.png)) is Post-Conditions where you can define the post-conditions of this use case. This contraints answers the question: What do I have to specify as post-conditions, which will be the result of this use case.
    1. The third tab (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/ucinv.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/ucinv.png)) is for Invariants, where you can define some invariants of this use case. Invariant is a predicate that will always keep its truth value throughout a specific sequence of operations.
    1. And the last one tab ![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/uctemp.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/uctemp.png)) is for temporal constraints
  * Further Details tab: For specify additional information.
  * Flow of events tab: Flow of events is a part of the plan, which will be generated by a planner.

You can see a resume of the use case specification better in the _Information Panel_.

#### Association ####

An _Association_ (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/association.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/association.png)) refers to how individual use cases can be linked together based upon certain functionality.

For define an association with _itSIMPLE_ tool, you must first click on the actor where you want define the association and after click on the use case to complete the association.

### Dependency ###

In _UML_ modeling, a _dependency (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/dependency1.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/UseCase/dependency1.png)) relationship_ is a relationship in which changes to one model element (the supplier) impact another model element (the client).

For define an dependency with _itSIMPLE_ tool, you must first click on the actor where you want define it, and after click on the use case to complete the association.

  * [Class diagram](ModellingClassDiagram.md)
  * [State Machine Diagram](ModellingStateDiagram.md)
  * [UML Object (snapshot) Diagram](ModellingObject.md)