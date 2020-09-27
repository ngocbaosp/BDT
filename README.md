# Big Data Technology Course - Final Project
## Presentation file: 
 - https://github.com/ngocbaosp/BDT/blob/master/BDT%20Final%20Project%20Presentation.pptx

## Project Folder Structure
- **FinalProject**: contains all Java source codes in this solution (created from scratch)
  - *** 
  - ***RunnableJarFiles***:
    - ****producer.jar****: get data from RESTAPI (https://iexcloud.io/docs/api/), convert Json data to Java object, and send StockInfo object to Kafka topic
    - ****stockSparkStreaming.jar****: 
     get data from Kafka topic, tranform the StockInfo object to the StockInfoDTO object (only fields related to StockDaily table in Hive) and save DStream directly to HDFS partition folder (underneath user/hive folder)   
    - ****comsumer.jar****: this is a sample consumer app, get data from Kafka topic and write to console window.
    
 
- Documentation: contains some related documents, such as: 
 - Install Kafka.pptx: how to install Kafka on Cloudera quickstart VM  
 - Hive and PowerBI.pptx: install hive odbc connection for Power BI 
 - PowerBI: contains sample file created for this project that pulled data directly from Hive 
- Readme.md


## Kafka
### Kafka Commands
- Create topic:
  - kafka-topics --zookeeper quickstart.cloudera:2181 --create --topic ***topicname*** --partitions 1 --replication-factor 1
- Delete topic:
  - kafka-topics --zookeeper quickstart.cloudera:2181 --topic ***topicname*** --delete
### Install Kafka 
- Quick guide: https://github.com/ngocbaosp/BDT/blob/master/Documentation/Install%20Kafka.pptx
- Ref: https://blog.clairvoyantsoft.com/installing-apache-kafka-on-clouderas-quickstart-vm-8245d8d0ebe5


## Power BI

## Other useful references
