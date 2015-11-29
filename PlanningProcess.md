# Planning Process #

You can click on _Planning_ tab in the toolbar (**1:**) to analyze, verify and validate your plan.

![https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_screen.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_screen.png)


After that, you can expand the project in the Projects Manager panel and  choose and  expand  in the problem Domain a problem (**2:**).

![https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_planners.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_planners.png)

There is some planner versions for _Windows_ and _Linux_ Operating System (**3:**).
You can select a planner and optionally click in the option (**4:**) for specify for each planner some parameters in the _Planner Setting Configurations_:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_setconfig.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_setconfig.png)

Finally will generate a Plan (**5:**) based on your modeling: Classes, State Machine, and Objects in the Plan view panel (![https://my-project-probando.googlecode.com/svn/planning_engine.png](https://my-project-probando.googlecode.com/svn/planning_engine.png)).

![https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_plan.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_plan.png)

Clicking on the _Result_ tab (**7:**), all information about a problem solution can be viewed in a report at the _Plan Information_ panel (**6:**): Name Project, Domain, Problem, Planner and some statistics and so on.

In the problem context, are involved some variables that can be selected to be tracked.
Click in the tab _Variables Tracking_ (**8:**), will appear a panel with all problem variables (**9:**) and you can choose some of this  variables for each object  declared in the initial phases of the process:

![https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_var.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_var.png)

Beside you can analyze this variables through a diagram click in the option _Draw Chart_ (**10:**) and will be visualized in the panel _Chart_ (**11:**)

You can generate a movie based on the Plan click on _Movie Maker_ tab (**11:**). Both images (Left and Right windows) can be fit on the screen using _Zoom In_ and _Zoom Out_ options (**12:**).

If you prefer, you can either see the left or the right window clicking on(**18:**).

![https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_movie.png](https://itsimple.googlecode.com/svn/wiki/resources/images/Planning/planning_movie.png)

Left Window (**13:**)demonstrates the  _Preconditions_ of the Operator according to the Plan and Right Window (**14:**) demonstrates the Effects of the Operator according to the Plan. Look at the link green and the attribute _clear_ and _empty_ (with false value) of the _Hand_ and _Block_ class respectively (**16:**). In the left window this link doesn't exist and these attributes have Zero as true as value. This demonstrates which are effects of a given Operator in the problem.

Either you can navigate by clicking on the _Forward_ option to analyze the changes or come back in the Plan Navigation clicking on the _Backward_ option (**17:**).

  * [itSIMPLE PDDL Translation](PDDL.md)