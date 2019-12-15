# Deploying on Docker Swarm

Run below commands on Manager node:

1. Deploy hotel application to Swarm:
`docker stack deploy -c hotel-stack.yaml hotel-app`

2. Make sure everything worked by listing hotel service:
`docker service ls`

to constantly watch service startup on docker swarm:
`watch docker service ls`

3. Open a browser and send request to gateway-service at port 8088

4. To check services registered in Eureka see port 8761

5. Once satisfied, tear down hotel application
`docker stack rm hotel-app`