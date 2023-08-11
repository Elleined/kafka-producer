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
 - Topic and Channel are the same. This is where the Message will be available you know like this is where the message will travel just like the radio frequency where their information is travelling for us to hear it.

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
 - When user interacts with our application, our application will send an API request to our microservice and our microservice will give a response intantly. But behind the scene our API lets say for example our API is product service, our product service will create a topic to kafka and create an event or send a message/data to topic asynchronously and acts as a publisher. Now our other microservices that are related to product like monitoring, transaction, security, and user apis will listen to that topic created by publisher if an event or message/data are being publish in that topic and acts as subcribers and when they recieve that event or message/data they will perform their own logic in independent manner.
