# _Class diagram_ #

The _Class diagram_ of _itSIMPLE4.0_ captures the logical structure of the system; the _Classes_ and things that make up the model. It is a static model,  escribing what exists and what _attributes_ and _behavior_ it has, rather than how something is done. _Generalizations_  and _Associations_ are all valuable in reflecting inheritance, composition or usage, and connections, respectively.


![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/dclasse1.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/dclasse1.png)

## _Toolbox Elements_ ##

![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/toolbarDC.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/toolbarDC.png)

### Class ###

A _Class_ is a representation of objects that reflects their structure and behavior within the system. It is a template from which actual running instances are created.
A _Class_ can have attributes (data) and methods (operations or behavior) and classes can inherit characteristics from parent Classes and delegate behavior to other Classes.
Class models usually describe the logical structure of the system and are the building blocks from which components are built.

  * According _OMG UML Specification_: the main purpose of a _class_ is to specify a classification of objects and to specify the features that characterize the structure and behavior of those objects. _Objects_ of a _class_ must contain values for each attribute that is a member of that _class_, in accordance with the characteristics of the _attribute_, for example its type and multiplicity.

For create a _Class_ with _itSIMPLE_ tool, you must click on the _Class_ icon (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/Class.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/Class.png)) at the toolbar and choose on the _Diagram View Area_ where you want put it.

In the [Object Properties panel](BasicFuncionalities#Object_Properties.md)  you can define some other properties of this class:

  * Base tab: You can specify a _Name_ and _Description_ and choose some [icon](Icons1.md) for this _Class_
  * Attributes tab: For define some attributes  (name, type and a initial value). Will appear other three bottom tabs (_New attribute_ : ![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/new.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/new.png), _Delete Selected Attribute_ : ![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/delete.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/delete.png) and _Edit Selected Attribute_ :![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/edit.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/edit.png) ) : ![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/attributeClasse.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/attributeClasse.png)
  * Operator tab: When you create a new operator, you can define its properties:![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/operator_properties.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/operator_properties.png)
  * Additional: For specify the stereotype of class (agent or utility)
  * Constraints: For specify some constraints.

### Enumeration ###

An _Enumeration_ (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/Class.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/Class.png)) is a data type, whose instances can be any of a number of user-defined enumeration literals. It is possible to extend the set of applicable enumeration literals in other packages or profiles.

  * According _OMG UML Specification_: an enumeration is a data type whose values are enumerated in the model as enumeration literals.

### Class Association ###

An _Association_ (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/association.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/association.png)) implies two model elements have a _relationship_, usually implemented as an instance variable in one _Class_. The connector can include _named roles_ at each end, _multiplicity_, _direction_ and _constraints_. _Association_ is the general main relationship type between elements.
To connect more than two elements in an association, you can use the _N-Ary_ Association element.

  * According _OMG UML Specification_: an _association_ specifies a semantic relationship that can occur between typed instances. It has at least two ends represented by properties, each of which is connected to the type of the end. More than one end of the association may have the same type. An end property of an association that is owned by an end class or that is a navigable owned end of the association indicates that the association is navigable from the opposite ends; otherwise, the association is not navigable from the opposite ends.

For define an association with _itSIMPLE_ tool, you must first click on one _class_ where you want define the association and after click on the other _class_ to complete the association.

In the [Object Properties panel](BasicFuncionalities#Object_Properties.md)  you can define some other properties of this association:

  * Base Tab: For define a name and a brief description for this association.
  * Role A and Role B Tabs: Role is at each association end and it works as a predicate in a modeling (must have a name, navigation, a type and multiplicity).
    1. Additional: For specify the changeability (changeable, addOnly and frozen)
    1. Constraints: For specify some constraints.

### Generalization ###

A _Generalization_ (![https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/generalization.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Modeling/ClassDiagram/generalization.png)) is used to indicate inheritance between classes. Drawn from the specific classifier to a general classifier, the
generalize implication is that the source inherits the target's characteristics.

  * According _OMG UML Specification_: a _generalization_ is a taxonomic relationship between a more general classifier and a more specific classifier. Each instance of the specific classifier is also an indirect instance of the general classifier. Thus, the specific classifier inherits the features of the more general classifier.

For define an generalization with _itSIMPLE_ tool, you must first click on the class where you want define the association and after click on the other class to complete the association.

  * [Use case diagram](ModellingUseCase.md)
  * [State Machine Diagram](ModellingStateDiagram.md)
  * [UML Object (snapshot) Diagram](ModellingObject.md)