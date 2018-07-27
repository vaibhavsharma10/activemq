# activemq-starter-project

This is a simple Spring Boot Application which is connects to ActiveMQ server and it is also having Procuder and Consumer which can publish/consume on/from Queues/Topics.

This app can also be easily deployed to Heroku cloud

This application supports the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

## Running Locally

Make sure you have Java and Maven and Eclipse(preferred STS - Spring Tool Suite) installed.  

```sh
$ git clone <github-path of this application>
$ cd java-getting-started
$ mvn install
$ mvn eclipse:eclipse
```
In eclipse (STS) import this project and right click on the project and Run As Spring Boot Applciation, or you can create a war file and deploy it in tomcat as well.
Your app should now be running on [localhost:8080](http://localhost:8080/).

