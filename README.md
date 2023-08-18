# kafka-producer
Creating producer/publisher event-driven architecture with micro-service single-database-per-service model using Kafka

# What is kafka
 - Kafka is messaging system.
 - Distributed streaming platform to process realtime data feeds fast and easy.
 - Uses pub/sub design pattern.
 - Kafka was originally developed by LinkedIn and LinkedIn donated the project to Apache to maintain thats why its called Apache Kafka.
   
# What is pub/sub design pattern
 - In real world scenario you can think of this in Radio station we are listening to them by subscribing in their frequency right and we get all the information they are saying similar in pub/sub where the Radio station is the Publisher and we the listeners are the Subscribers and the frequency is the Topic/Channel and they saying are the Mesaage/Data.

# Terminologies
 - Message = Data can anything like xml, json, string, yml etc...
 - Producer and Publisher are the same. sender of the event or message.
 - Consumer and Subscriber are the same. receiver of the event or message.
 - Event is some action on your application that are triggered like productSave and productDeleted etc... you get the point.
 - Topic, Channel, and Bucket are all the same. This is where the messsages/data suppose to go.

# What is event-driven architecture(EDA)
 - In my own understanding based on my research. Event driven architecture is used in distributed systems like microservices architecture to effectively distribute the data across different microservices. Achieving data consistency, loose coupling, single point of truth, and real time communications.

# Why do we need event-driven architecture in our microservices
 - So typically in our microservices we use HTTP calls in other microservice to communicate right nothing wrong with that but we should only use HTTP call in other microservice to the proccesses that user care about and the processes that user has direct relation to operate like checking his account balance you get the point imagine making a request every second just for notification. We all know HTTP call is expensive, threadblocking and also we don't want the user wait for our application perform all the task that he dont give a f*.. like monitoring, transaction, notifications, notification for other application, and CRUD operations across our microservices. This task we can execute asychronously with the help of Apache Kafka.
   
# What is event source
 - The entities that generates the data. For example: database, sensors, mobile apps, web apps, and any cloud services. Basically anything that generates data.

# What is event stream
 - Capturing data from different event sources.
 - Storing the event streams for later retrieval.
 - Keeping information at right time and in the right place.

# Why Kafka or Messaging Systems
 - Problem: Collecting all data is not easy as data is generated from various event sources in different formats
 - Solution: We use messaging systems to provide seamless data integration between distributed applications/mictoservices with the help of messages as data. and we dont need to directly communicate between microservices we just subscribe to a topic and we get the data.

# Basic event-driven workflow
 - When user interacts with our application, our application will send an API request to our microservice and our microservice will give a response intantly. But behind the scenes our API lets say for example our API is product service, our product service will create a topic to kafka and create an event or send a message/data to topic asynchronously and acts as a publisher. Now our other microservices that are related to product like monitoring, transaction, security, and user apis will listen to that topic created by product-service(publisher) if an event or message/data are being publish by publisher they recieve that event or message/data and they will perform their own logic in independent manner now acts as subcribers.

### Now enough in theoretical concepts we now proceed in practical examples.

# What is Zookeeper
- When we are starting kafka we first need zookeeper where the kafka will run zookeeper provides a platform for kafka server to run on.

# Kafka installation
 - Before starting these intallation process if some unexpected happen I provided some usefull links for debugging that you might encounter when setting this up. Make sure to check it.
 - Download the latest stable version of kafka binary download.
 - Extract the kafkaX.XX.X.XX.zip. // X represent the version
 - Rename the kafkaX.XX.X.XX to kafka.
 - Move the folder to C://kafka.
 - Change zookeeper.properties property that located in kafka/config/zookeeper.properties
```
 dataDir=c:/kafka/zookeeper-logs
```
- Change the server.properties property located in /kafka/config/server.properties
```
 log.dirs=c:/kafka/kafka-logs
```
- Copy the server.properties and zookeeper.properties then paste those two in /kafka/bin/windows.
- Open the cmd in C://kafka/bin/windows
- Start zookeper server
```
  zookeeper-server-start.bat zookeeper.properties
```
- Start kafka server
```
  kafka-server-start.bat server.properties
```
###### Note:
- Zookeeper server default port is 2181.
- Kafka server default port is 9092.
- Zookeeper must be started before kafka server.
- when you are using linux/mac use .sh files for windows user use .bat files.

# Kafka Producer
- Will have the serializer property.
- The one that will be using
```
KafkaTemplate.send()
```
- The one that will create the topic.
- The one that will be publishing/producing the message/data to topic.

# Kafka Consumer
- Will have the deserializer property.
- The one that will be using
```
@KafkaListener(topics={topicName}, groupId={groupId})
```
- The one that will subcribe to topic.
- The one that will have the group-id that acts as unique identifier of consumer.

###### Note:
- When dealing with serializing and deserializing for easy method make the field names the same. If field name are not the same use

```
@JsonProperty("producerObjectFieldName")
private Datatype consumerFieldName;
```

# What is KafkaTemplate 
 - KafkaTemplate is used to help your application to connect in kafka server and provides abstraction to Producer API of Kafka. Just like you use mysql-driver to connect in MySQL database. KafkaTemplate is provided by spring and usually be seen in producer applications to help create a event or send message/data in topic.

# What is @KafkaListener
- Used to easily subscribe to kafka topic created by producer. Method annotated with this will automatically executed when producer create a event or send a message/data to specified topic.

# [kafka-consumer](https://github.com/Elleined/kafka-consumer)
 
# Usefull links
 - Detailed explanation of Event-driven
 https://www.youtube.com/watch?v=X-JWP7E1xPc
 - Installation https://youtu.be/EUzH9khPYgs
 - WMIC not recognize https://www.itechtics.com/wmic-is-not-recognized-as-an-internal-or-external-command/?expand_article=1
 - Kafka server not starting and not returning anything https://stackoverflow.com/questions/45524750/kafka-server-not-returning-anything
 - Serialization and Deserializatiom issue https://stackoverflow.com/questions/70206790/how-to-map-types-using-properties-file-in-kafka
# Other github repo reference credits to
- https://github.com/RameshMF/springboot-kafka-course
# Yt videos
- https://www.youtube.com/live/VInk1_9vvCY?feature=share
- https://youtube.com/playlist?list=PLGRDMO4rOGcNLwoack4ZiTyewUcF6y6BU
