# Big Data Technology Course - Final Project
## 1. Presentation file: 
 - https://github.com/ngocbaosp/BDT/blob/master/BDT%20Final%20Project%20Presentation.pptx
 
## 2. Data source (Restful API): 
 - ***IEX Cloude***: a platform that makes financial data and services accessible to everyone
 - IEX Cloude website: https://iexcloud.io/ 
 - IEX Cloude API doc: https://iexcloud.io/docs/api/
 - Test link (to view Json data): https://sandbox.iexapis.com/stable/stock/AAPL/quote?token=Tsk_2ec682f2ca234a04bb108023943ea5e8  
## 3. Project Folder Structure
- **[FinalProject](https://github.com/ngocbaosp/BDT/tree/master/FinalProject)**: contains all Java source codes in this solution (created from scratch)
  - ***[src/main/java/cs523/finalproject/](https://github.com/ngocbaosp/BDT/tree/master/FinalProject/src/main/java/cs523/finalproject)***: java classes 
   - **Kafka**:
     - StockProducer.java: a producer to send StockInfo object to Kafka topic    
     - StockConsumer.java: a consumer to receive StockInfo object from Kafka topic
     - SendStockRecordToKafkaTopic.java: get data from Restful API, convert Json object to Java POJO object, then send a stockInfo record to kafka topic
     - Service: classes related to get data from Rest API
     - model: POJO classes
   - **Spark**:
     - StockSparkStreaming.java: get data from Kafka topic, tranform the StockInfo object to the StockInfoDTO object (only fields related to StockDaily table in Hive) and save DStream directly to HDFS partition folder (underneath user/hive folder)
    
  - ***[RunnableJarFiles](https://github.com/ngocbaosp/BDT/tree/master/FinalProject/RunnableJarFiles)***:
    - ****producer.jar****: get data from RESTAPI (https://iexcloud.io/docs/api/), convert Json data to Java object, and send StockInfo object to Kafka topic
      - **Shell command**:
      ```
      java -jar '/home/cloudera/workspace/FinalProject/RunnableJarFiles/producer.jar' AAPLTest AAPL 30
      ```
      - **Arguments**: 


       | No       | Arg     | Description     | Sample value     |
       | :------------- | :----------: | -----------: | -----------: |
       |  1 | Topic Name   | Kafka topic name    | StockTest    |
       | 2   | Symbol | Stock ticker/symbol | AAPL: Apple Inc, GOOGL: Google Inc    |
       | 3   | Duration | Timer Duration (seconds)| 5    |
       | 4   | token | IEX API token| Bao's token    |
       | 5   | apiURL | IEX API URL| https://sandbox.iexapis.com/stable/stock    | 

    
    - ****stockSparkStreaming.jar****: 
     get data from Kafka topic, tranform the StockInfo object to the StockInfoDTO object (only fields related to StockDaily table in Hive) and save DStream directly to HDFS partition folder (underneath user/hive folder)   
      - **Shell command**:
      ```
      java -jar '/home/cloudera/workspace/FinalProject/RunnableJarFiles/stockSparkStreaming.jar' AAPLTest AAPL 10 /user/hive/BDT/StockDaily
      ```
      - **Arguments**: 


       | No       | Arg     | Description     | Sample value     |
       | :------------- | :----------: | -----------: | -----------: |
       |  1 | Topic Name   | Kafka topic name    | StockTest    |
       | 2   | Symbol | Stock ticker/symbol | AAPL: Apple Inc, GOOGL: Google Inc    |
       | 3   | Duration | Timer Duration (seconds)| 10    |
       | 4   | hdfs path | hdfs folder related to hive table| /user/hive/BDT/StockDaily    |
     
    - ****comsumer.jar****: this is a sample consumer app, get data from Kafka topic and write to console window.
      - **Shell command**:
      ```
      java -jar '/home/cloudera/workspace/FinalProject/RunnableJarFiles/consumer.jar' AAPLTest
      ```
      - **Arguments**: 


       | No       | Arg     | Description     | Sample value     |
       | :------------- | :----------: | -----------: | -----------: |
       |  1 | Topic Name   | Kafka topic name    | StockTest    |
    
 
- Documentation: contains some related documents, such as: 
  - Install Kafka.pptx: how to install Kafka on Cloudera quickstart VM  
  - Hive and PowerBI.pptx: install hive odbc connection for Power BI 
  - PowerBI: contains sample file created for this project that pulled data directly from Hive 
- Readme.md

## 4. Kafka
### 4.1 Kafka Commands
- Create topic:
  - kafka-topics --zookeeper quickstart.cloudera:2181 --create --topic ***topicname*** --partitions 1 --replication-factor 1
- Delete topic:
  - kafka-topics --zookeeper quickstart.cloudera:2181 --topic ***topicname*** --delete
### 4.2 Install Kafka 
- Quick guide: https://github.com/ngocbaosp/BDT/blob/master/Documentation/Install%20Kafka.pptx
- Ref: https://blog.clairvoyantsoft.com/installing-apache-kafka-on-clouderas-quickstart-vm-8245d8d0ebe5


## 5. Hive


## 6. Power BI
 - Download and install PowerBI Desktop: https://powerbi.microsoft.com/en-us/downloads/

## 7. Other useful references
