# Bootstrap Liferay Advanced Developer Environments(**BLADE**)

[![Build Status](https://travis-ci.org/rotty3000/blade.svg?branch=master)](https://travis-ci.org/rotty3000/blade)
[![Join the chat at https://gitter.im/rotty3000/blade](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/rotty3000/blade?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This small experiment aims to provide bootstrap project environments for all the major build tools in common use for Java projects so that Liferay development can start quickly and easily.



# Related build tools and frameworks 


## Build tools

The template projects are categorized based on the build tools,

* `gradle` - these are set of Liferay projects that can be bootstrapped on to `gradle` based development environment
* `liferay-gradle` - these are set of Liferay projects that can be bootstrapped on to `com.liferay.plugin`(a gradle plugin) based development environment
* `maven` - these are set of Liferay projects that can be bootstrapped on to `maven` development environment
* `bndtools` - these are set of Liferay projects that can be bootstrapped on to `bndtools` based development environment


### A note on BNDTools

There are 2 additional projects in the `/bndtools/` folder that you will need to build and publish the modules

* `/bndtools/cnf` - The Bndtools configuration project
* `/bndtools/blade.run` - A bndtools project which can push bundles into an osgi container and run them, need biz.aQute.remote.agent-X.X.X.jar deployed first.


## Frameworks

The projects also demonstrate how to use various frameworks like:

* Blueprint
* Declarative Services(**DS**)
* OSGI API


### A note on Blueprint

Liferay does not provide a blueprint implementation out of the box. To use the blueprint modules provided in blade, you must deploy a blueprint implementation such as [Apache Aries - Blueprint](http://aries.apache.org/modules/blueprint.html). Three bundles are needed:

* [Apache Aries Blueprint Bundle](http://mvnrepository.com/artifact/org.apache.aries.blueprint/org.apache.aries.blueprint/1.1.0)
* [Apache Aries Blueprint Annotation API](http://mvnrepository.com/artifact/org.apache.aries.blueprint/org.apache.aries.blueprint.annotation.api/1.0.1)
* [Apache Aries Proxy Bundle](http://mvnrepository.com/artifact/org.apache.aries.proxy/org.apache.aries.proxy/1.0.1)

Simply download the bundles from mvnrepository and drop them in your osgi/modules folder as usual before deploying blueprint bundles.



# Liferay extension points and template projects 


## `auth.pipeline.pre` 

__Extension point description__: 

__Template project description__: Uses Apache Shiro for hooking `auth.pipeline.pre`

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.authenticator.shiro](./bndtools/blade.authenticator.shiro)    |
| Gradle     | [./gradle/blade.authenticator.shiro](./gradle/blade.authenticator.shiro)        |
| Maven      | [./maven/blade.authenticator.shiro](./maven/blade.authenticator.shiro)          |


## `auth.failure` and `auth.max.failures`

__Extension point description__: 

__Template project description__: Demonstrates a hook for `auth.failure` and `auth.max.failures`

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.authfailure](./bndtools/blade.authfailure)    |
| Gradle     | [./gradle/blade.authfailure](./gradle/blade.authfailure)        |
| Maven      | [./maven/blade.authfailure](./maven/blade.authfailure)          |


## `ConfigurationAction`

__Extension point description__: 

__Template project description__: demonstrates integration point of `ConfigurationAction`

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |     |
| Gradle     | [./gradle/blade.configurationaction](./gradle/blade.configurationaction)        |
| Maven      | [./maven/blade.configurationaction](./maven/blade.configurationaction)          |


## Gogo command

__Extension point description__: 

__Template project description__: demonstrates felix gogo commands and consuming Liferay services through DS (Declarative Services)

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |     |
| Gradle     | [./gradle/blade.gogo](./gradle/blade.gogo)        |
| Maven      | [./maven/blade.gogo](./maven/blade.gogo)          |


## JSP hook

__Extension point description__: 

__Template project description__:  demonstrates a jsp hook for `login.jsp` in `com.liferay.login.web` bundle via fragment bundle.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.hook.jsp](./bndtools/blade.hook.jsp)        |
| Gradle     | [./gradle/blade.hook.jsp](./gradle/blade.hook.jsp)        |
| Maven      | [./maven/blade.hook.jsp](./maven/blade.hook.jsp)          |


## `IndexerPostProcessor`

__Extension point description__: 

__Template project description__:  demonstrates how to create custom IndexerPostProcessor.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |       |
| Gradle     | [./gradle/blade.indexerpostprocessor](./gradle/blade.indexerpostprocessor)      |
| Maven      | [./maven/blade.indexerpostprocessor](./maven/blade.indexerpostprocessor)        |


## `login.events.pre`

__Extension point description__: 

__Template project description__:  demonstrates a hook for `login.events.pre`.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |       |
| Gradle     | [./gradle/blade.lifecycle.loginpreaction](./gradle/blade.lifecycle.loginpreaction)      |
| Maven      | [./maven/blade.lifecycle.loginpreaction](./maven/blade.lifecycle.loginpreaction)        |


## `PollerProcessor`

__Extension point description__: 

__Template project description__:  demonstrates how to make a hook for `PollerProcessor`.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |       |
| Gradle     | [./gradle/blade.pollprocessor](./gradle/blade.pollprocessor)      |
| Maven      | [./maven/blade.pollprocessor](./maven/blade.pollprocessor)        |


## `MVCActionCommand`

__Extension point description__: 

__Template project description__:  Demonstrates extension point of `MVCActionCommand`. It integrates the action command named `greet` with portlet `greeter`.

To see how this example works, a portlet plugin with a portlet named **greeter** (`javax.portlet.name='greeter'`) is to be deployed.  The command adds a key `greeting_message` to Liferay SessionMessages, along with a session attribute `GREETER_MESSAGE`. You can independently deploy the bundle `blade.portlet.actioncommand` a.k.a refresh the bundle without the need to redeploy the Portlet plugin.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.portlet.actioncommand](./bndtools/blade.portlet.actioncommand)  |
| Gradle     | [./gradle/blade.portlet.actioncommand](./gradle/blade.portlet.actioncommand)      |
| Maven      | [./maven/blade.portlet.actioncommand](./maven/blade.portlet.actioncommand)        |


## Portlet 

__Extension point description__: 

Below are examples of buildeing portles using diferent frameworks: 


### Liferay MVC Portlet - using Blueprint framework

__Template project description__:  demonstrates how to use Blueprint framework for registering a portlet.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.portlet.blueprint](./bndtools/blade.portlet.blueprint)  |
| Gradle     | [./gradle/blade.portlet.blueprint](./gradle/blade.portlet.blueprint)      |
| Maven      | [./maven/blade.portlet.blueprint](./maven/blade.portlet.blueprint)        |


### Liferay MVC Portlet - using DS (Declarative Services) framework

__Template project description__:  demonstrates how to use DS (Declarative Services) framework for registering a portlet.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.portlet.ds](./bndtools/blade.portlet.ds)  |
| Gradle     | [./gradle/blade.portlet.ds](./gradle/blade.portlet.ds)      |
| Maven      | [./maven/blade.portlet.ds](./maven/blade.portlet.ds)        |


### Liferay MVC Portlet - using raw OSGI APIs

__Template project description__:  demonstrates how to use the raw OSGI APIs for registering a portlet.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.portlet.osgiapi](./bndtools/blade.portlet.osgiapi)  |
| Gradle     | [./gradle/blade.portlet.osgiapi](./gradle/blade.portlet.osgiapi)      |
| Maven      | [./maven/blade.portlet.osgiapi](./maven/blade.portlet.osgiapi)        |


### JSF Portlet - using DS (Declarative Services) framework

__Template project description__:  demonstrates how to use the DS (Declarative Services) for registering a JSF portlet

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |   |
| Gradle     |   |
| Maven      | [./maven/blade.jsf.portlet.ds](./maven/blade.jsf.portlet.ds)        |

### JSP Portlet 

__Extension point description__: 

__Template project description__:  demonstrates a simple jsp portlet.

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |  |
| Gradle     | [./gradle/blade.portlet.jsp](./gradle/blade.portlet.jsp)      |
| Maven      | [./maven/blade.portlet.jsp](./maven/blade.portlet.jsp)        |


## `PortletFilter`

__Extension point description__: 

__Template project description__:  demonstrates how to apply PortletFilters

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.portlet.filter](./bndtools/blade.portlet.filter)  |
| Gradle     | [./gradle/blade.portlet.filter](./gradle/blade.portlet.filter)      |
| Maven      | [./maven/blade.portlet.filter](./maven/blade.portlet.filter)        |


## `ServiceWrapper`

__Extension point description__: 

__Template project description__:  demonstrates how to wrap UserLocalService with custom UserLocalServiceWrapper

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  | [./bndtools/blade.service.hook.user](./bndtools/blade.service.hook.user)  |
| Gradle     | [./gradle/blade.service.hook.user](./gradle/blade.service.hook.user)      |
| Maven      | [./maven/blade.service.hook.user](./maven/blade.service.hook.user)        |


## Service Builder

__Extension point description__: 

__Template project description__:  demonstrates how to create a Service Builder project separated to 4 bundles: 

* api bundle for interface
* svc bundle for implementation
* test bundle for testing
* web bundle is a portlet calling generated services 

__Template projects links__:

| Build tool | subproject   | Link to project's source code                                                   |
| ---------- | ------------ | ------------------------------------------------------------------------------- |
| BND Tools  | API          | [./bndtools/blade.servicebuilder.api](./bndtools/blade.servicebuilder.api)  |
| BND Tools  | Service      | [./bndtools/blade.servicebuilder.svc](./bndtools/blade.servicebuilder.svc)  |
| BND Tools  | Test         | [./bndtools/blade.servicebuilder.test](./bndtools/blade.servicebuilder.test)  |
| BND Tools  | Web          | [./bndtools/blade.servicebuilder.web](./bndtools/blade.servicebuilder.web)  |
| Gradle     | API          | [./gradle/blade.servicebuilder.api](./gradle/blade.servicebuilder.api)  |
| Gradle     | Service      | [./gradle/blade.servicebuilder.svc](./gradle/blade.servicebuilder.svc)  |
| Gradle     | Test         | [./gradle/blade.servicebuilder.test](./gradle/blade.servicebuilder.test)  |
| Gradle     | Web          | [./gradle/blade.servicebuilder.web](./gradle/blade.servicebuilder.web)  |
| Maven      | All (parent) | [./maven/blade.servicebuilder](./maven/blade.servicebuilder)  |


## `StrutsAction`

__Extension point description__: 

__Template project description__:  demonstrates how to write StrutsAction

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |   |
| Gradle     | [./gradle/blade.strutsaction](./gradle/blade.strutsaction)      |
| Maven      | [./maven/blade.strutsaction](./maven/blade.strutsaction)        |


## `StrutsPortletAction`

__Extension point description__: 

__Template project description__:  demonstrates how to write StrutsPortletAction

__Template projects links__:

| Build tool | Link to project's source code                                                   |
| ---------- | ------------------------------------------------------------------------------- |
| BND Tools  |   |
| Gradle     | [./gradle/blade.strutsportletaction](./gradle/blade.strutsportletaction)      |
| Maven      | [./maven/blade.strutsportletaction](./maven/blade.strutsportletaction)        |



# Liferay extension points without template projects

This project still does not have template projects for the following extension points. We encourage you to contribute some!  

* TODO  
* TODO  
* TODO  



# License
[License](/LICENSE.txt)

# Contribution

These templates can be copied freely and contributions are welcome.

# References

[OSGI R5](http://www.osgi.org/Release5/HomePage)

[OSGI Compendium R5](http://www.osgi.org/Download/File?url=/download/r5/osgi.cmpn-5.0.0.pdf)

[Blueprint](http://www.eclipse.org/gemini/blueprint/)

[Bndtools](http://www.bndtools.org)
