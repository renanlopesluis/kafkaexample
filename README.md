# kafkaexample
Just a simple Kafka Example along with Springboot

This project has aims to give someone a simple notion of Kafka consumer/producer and how to do this on springboot.

<br/>

**Features**
This kafka implementation was developed by using Java language and Springboot as its framework. Some features are very important to be said, such as:
<br/>
- Clean Code;
- Simplicity;
- Concepts Separation.

<br/>

**How to use this API**
The Api has just a simple POJO named User, and this User has just two attributes such as name and age.
You may use this API by 3 ways:
- by using the same API for messages production and consumption
  - Accessing the url _localhost:8080/kafka/produce/{name}/{age} , you should provide a name and an age and then trigger the request which will produce a message and consume it then. 
- by using API for message production and creating a consumer on terminal for message consumption
- by creating a producer on terminal and consuming the message on the API

<br/>

**Make Sure**
- Apache Zookeeper should be installed and started on machine;
- Apache Kafka should be installed and started on machine;

<br/>

**Possible Improvements**
- Adding Predicates to sift messages
- Adding Converters for a better JSON to a specific Object serialization
