# User Micro-Service

## Argument from cmd
Run an instance from command line
```shell script
$ cd /project-file
$ mvn spring-boot:run -Dspring-boot.run.arguments=--[instance name here]=[name you want]
[instance name] = spring.application.instance_id
[name you want] = myAppID
``` 

Run another instance from command line with port specified
```shell script
$ cd /project-file
$ mvn spring-boot:run -Dspring-boot.run.arguments=--[instance name here]=[name you want],--server.port=[custom port]
[instance name] = spring.application.instance_id
[name you want] = myAppID
```
