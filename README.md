# Docker_springboot_mysql
Dockerize Springboot+MySQL App
--------step by step-----
1.  create Dockerfile(capital D) on the root file:

    FROM openjdk:latest
    ADD target/docker_app_name.jar docker_app_name.jar
    EXPOSE <port_number>
    ENTRYPOINT ["java","-jar",docker_app_name.jar"]
    
2. build docker image : $ docker build -t docker_app_name.jar .
3. get docker my sql from docker hub (if mysql not available) :  $ docker pull mysql
4. create docker network :  $ docker create network test_net
    --> check if the network has been created : $ docker network ls
4. Run DB :   $ docker run 
              --name mysql_name 
              --network test_net 
              -e MYSQL_ROOT_PASSWORD=password 
              -e MYSQL_DATABASE=test 
              -d mysql:latest

    --name should match with mysql_name on the application properties file :
    spring.datasource.url=jdbc:mysql://mysql_name:3306/test?serverTimezone=UTC
5. check if mysql is Running :  $ docker ps (will show all the running container and container ID) 
6. interact with DB:  $ docker exec -t <mysql_container_ID> mysql -uroot -p 
    -->enter password
7. RUn the App :   $ docker run -p 9090:8080 
                      --name docker_app_name.jar 
                      --network test_net 
                      -d docker_app_name.jar:latest
8. check if the server is running on the port 9090 :  $ docker logs <container_id> -f
9. Stop the container : $    docker stop <container_id>

  
    
