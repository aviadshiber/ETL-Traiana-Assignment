# ETL - Triana assignment
The platform is subscribed to multiple data feeds. Each feed is published by a different client to a dedicated Kafka topic. 
Client 1 uses XML and client 2 uses CSV. 
XML represent a single message whereas CSV represent multiple messages. 
The service required should read the messages from the 2 topics and for each message process it, transform to JSON and publish it to a single result topic. In case the message fails to parse, publish it to a kafka topic named “errors” (with the original content + error message). 
When the message is successfully parsed, transform the content to a JSON object. All input formats should be transformed to a single normalized JSON object. 
The solution is a service that pulls the messages from 2 kafka topics, processes them and publish a normalized JSON message/error JSON message.

## Components

 - xml producer - a dummy xml producer which generates every second a user in xml format to the output channel.
 - csv producer - a dummy csv producer which generates every second a user in csv format to the output channel.
 - converter-processor - a processor which takes the outputs from producers named *xml-topic,csv-topic* and transform the data to json on seperate channels & write it to a topic named *json-topic*. the errors are sent automatically to a DLQ. 
 
 ## Environment
  use data-flow environment to quick start:
  [https://github.com/aviadshiber/spring-dataflow-demo](https://github.com/aviadshiber/spring-dataflow-demo)
  
 - Register the apps as *csv-producer,xml-producer,xml-csv-to-json-converter* accordingly.

 
 ## Loading the stream
 in the project there is a stream.json file that can be loaded to spring-data-flow (**this must be done after registering the apps**).
 **Before deploying** - update the property of mongodb *uri* to your mongodb server.
 replace user,password,host with your own

    --uri=mongodb+srv://<user>:<password>@<host>/test?retryWrites=true&w=majority

The stream file will configure  two streams:
 1. xml-csv-stream
 2. mongodb sink
 and will plug them together.


*that it!
Deploy and enjoy!*