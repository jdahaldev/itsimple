# itSIMPLE PDDL Traslation #

_itSIMPLE_ integrates _PDDL_ representation to test models with general planners (automated planning techniques). _PDDL_ (Planning Domain Definition Language) is the standard specification language for planner inputs, _itSIMPLE_ integrates the capabilities of dealing with such language mainly in the model testing stage.

In order to perform model testing for verification and validation of the planning domain model, _itSIMPLE_ enables the user to represent UML models (holded in _XML_) in a _PDDL_ format. As highlighted before, the tool transforms the model into a XPDDL representation and then into a PDDL.

_itSIMPLE_ allows designers to deal with features from PDDL2.1 and PDDL3 such as general constraints and state trajectory constraints. _itSIMPLE_ do not deal with time constraints. itSIMPLE builds the domain and the problem specification in _PDDL_ separately. In order to build the PDDL specification to the domain, the tool extract types, predicates (attributes and associations) and functions (attributes) from the class diagram and the actions, as well as pre and postconditions from the OCL expression available at all state chart diagrams (some domain constraints are extract from associations rules).

You can click on _PDDL Translation_ tab in the toolbar translating your project: Planning Domain and Planning Problem (**1:**).

![https://itsimple.googlecode.com/svn/wiki/resources/images/PDDLTranslation/pddl_screen.png](https://itsimple.googlecode.com/svn/wiki/resources/images/PDDLTranslation/pddl_screen.png)

In the _Domain/Problem Selection_ (**2:**) panel  you can select a _Domain_ and for it\_Domain_select a problem for translate. Automatically will appear in_Domain/Problem_panel (**8:** and **9:**) a_PDDL_statements for this instances._

Before you select _Translate_ option (**4:**), you can specify a _PDDL_ Version in the panel _PDDL Version_ (**3:**) (between 2.1, 2.2, 3.0 and 3.1 version).

The _PDDL_ can be save with the _Save PDDL_ option (**5:**).


The OCL to PDDL translation process is based on the mapping between the two languages described in: [ocl2pddl](https://itsimple.googlecode.com/svn/wiki/resources/documentation/OCL2PDDLMapping.pdf)