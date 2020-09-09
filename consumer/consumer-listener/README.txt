#Run the rabbit MQ with following command

docker run -d --name rabbitmq -p 5671:5671 -p 5672:5672 -p 15691:15691 -p 15692:15692 -p 25672:25672 -p 15672:15672 rabbitmq:management


#management console can be accessed at

http://localhost:15672/

