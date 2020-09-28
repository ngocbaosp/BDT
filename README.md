# Big Data Technology Course - Final Project
## 1. Presentation file: 
 ### 1.1 Presentation file
 - https://github.com/ngocbaosp/BDT/blob/master/BDT%20Final%20Project%20Presentation.pptx
 ### 1.2 Shell script file
 
 ### 1.3 Input and output samples
 - **Input Data**: Json data from Rest API ([view details](https://github.com/ngocbaosp/BDT/blob/master/Input-Output%20SampleData/Input/AppleSampleJsonData.json))
 ```
 {
    "symbol": "AAPL",
    "companyName": "Apple, Inc.",
    "primaryExchange": "DSANAQ",
    "calculationPrice": "close",
    "open": 113.16,
    "openTime": 1608657328800,
    "openSource": "icilffoa",
    "close": 114.64,
    "closeTime": 1607378962833,
    "closeSource": "ifioalcf",
    "high": 115.52,
    "highTime": 1674551301493,
    "highSource": "iteamdd pr ul1 c5yeinee",
    "low": 111.6,
    "lowTime": 1674894514840,
    "lowSource": "1ila ynudrce5ipee  dmte",
    "latestPrice": 117.03,
    "latestSource": "Close",
    "latestTime": "September 25, 2020",
    "latestUpdate": 1666447370496,
    "latestVolume": 155142026,
    "iexRealtimePrice": null,
    "iexRealtimeSize": null,
    "iexLastUpdated": null,
    "delayedPrice": 114.43,
    "delayedPriceTime": 1627030828981,
    "oddLotDelayedPrice": 113.524,
    "oddLotDelayedPriceTime": 1615316771996,
    "extendedPrice": 116.21,
    "extendedChange": -0.05,
    "extendedChangePercent": -0.00045,
    "extendedPriceTime": 1602512759793,
    "previousClose": 109.7,
    "previousVolume": 171248857,
    "change": 4.14,
    "changePercent": 0.03761,
    "volume": 156753104,
    "iexMarketPercent": null,
    "iexVolume": null,
    "avgTotalVolume": 200309306,
    "iexBidPrice": null,
    "iexBidSize": null,
    "iexAskPrice": null,
    "iexAskSize": null,
    "iexOpen": null,
    "iexOpenTime": null,
    "iexClose": 117.016,
    "iexCloseTime": 1667854864547,
    "marketCap": 1976465397879,
    "peRatio": 35.03,
    "week52High": 139.7,
    "week52Low": 53.33,
    "ytdChange": 0.56339,
    "lastTradeTime": 1646621093184,
    "isUSMarketOpen": false
}
 ```
 
 
 - **Output Data**: text file saved to HDFS from SparkStreaming
 ```
 1601256512713	,Apple. Inc.,ADQANS,113.86,1673865691896, 113.68,1630975979211,113.1, 1645291304565,112.97,1660513507838, 114.08, 1678817508998,2020-09-27T18:28:42.313,154748359, 111.64, 169324969, 4.24, 0.0389,151250957,201145427,1996789480828,34.6, 138.98, 54.33,0.55724, 1680652344160,AAPL, 1678817508998
1601256515010	,Apple. Inc.,SQDAAN,112.76,1663422810206, 116.18,1631718508194,114.06, 1601880981923,108.52,1659548237983, 113.13, 1654559432099,2020-09-27T18:28:42.318,153973635, 112.5, 174738384, 4.2, 0.0393,151216555,197632634,1993279832421,34.93, 142.88, 54.9,0.58119, 1607823054338,AAPL, 1654559432099
 ```
 
 
## 2. Data source (Restful API): 
 - ***IEX Cloud***: a platform that makes financial data and services accessible to everyone
 - IEX Cloud website: https://iexcloud.io/ 
 - IEX Cloud API doc: https://iexcloud.io/docs/api/
 - Test link (to view Json data): https://sandbox.iexapis.com/stable/stock/AAPL/quote?token=Tsk_2ec682f2ca234a04bb108023943ea5e8  
## 3. Project Folder Structure
- **[FinalProject](https://github.com/ngocbaosp/BDT/tree/master/FinalProject)**: folder contains all Java source codes in this solution (created from scratch)
  - ***[src/main/java/cs523/finalproject/](https://github.com/ngocbaosp/BDT/tree/master/FinalProject/src/main/java/cs523/finalproject)***: folder contains java classes 
    - **[Kafka](https://github.com/ngocbaosp/BDT/tree/master/FinalProject/src/main/java/cs523/finalproject/kafka)**: folder
      - ***StockProducer.java***: producer class to send StockInfo object to Kafka topic    
      - ***StockConsumer.java***: consumer class to receive StockInfo object from Kafka topic
      - ***SendStockRecordToKafkaTopic.java***: get data from Restful API, convert Json object to Java POJO object, then send a stockInfo record to kafka topic
      - ***Service***: folder contains related classes to get data from Rest API
      - ***model***: folder contains POJO classes
    - **[Spark](https://github.com/ngocbaosp/BDT/tree/master/FinalProject/src/main/java/cs523/finalproject/Spark)**: folder
      - ***StockSparkStreaming.java***: get data from Kafka topic, tranform the StockInfo object to the StockInfoDTO object (only fields related to StockDaily table in Hive) and save DStream directly to HDFS partition folder (underneath user/hive folder)

   - ***[RunnableJarFiles](https://github.com/ngocbaosp/BDT/tree/master/FinalProject/RunnableJarFiles)***:
     - ****producer.jar****: get data from RESTAPI (https://iexcloud.io/docs/api/), convert Json data to Java object, and send StockInfo object to Kafka topic
       - **Shell command**:
       ```
       java -jar '/home/cloudera/workspace/FinalProject/RunnableJarFiles/producer.jar' AAPLTest AAPL 30
       ```
       - **Arguments**: 


        | No       | Arg     | Description     | Sample value     |
        | :------------- | :----------: | -----------: | -----------: |
        |  1 | Topic Name   | Kafka topic name    | AAPLTest    |
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
        |  1 | Topic Name   | Kafka topic name    | AAPLTest    |
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
    
 
- [Documentation](https://github.com/ngocbaosp/BDT/tree/master/Documentation): contains some related documents, such as: 
  - Install Kafka.pptx: how to install Kafka on Cloudera quickstart VM  
  - Hive and PowerBI.pptx: install hive odbc connection for Power BI 
  - PowerBI: contains sample file created for this project that pulled data directly from Hive 
- Readme.md

## 4. Kafka
### 4.1 Kafka Commands
- Create topic:
  ```
  kafka-topics --zookeeper quickstart.cloudera:2181 --create --topic ***topicname*** --partitions 1 --replication-factor 1
  ```
- Delete topic:
  ```
  kafka-topics --zookeeper quickstart.cloudera:2181 --topic ***topicname*** --delete
  ```
### 4.2 Install Kafka 
- Quick guide: https://github.com/ngocbaosp/BDT/blob/master/Documentation/Install%20Kafka.pptx
- Ref: https://blog.clairvoyantsoft.com/installing-apache-kafka-on-clouderas-quickstart-vm-8245d8d0ebe5


## 5. Hive
### 5.1 Hive Commands
- Create stockDaily table:
  ```
   CREATE EXTERNAL TABLE StockDaily
   (
       Id STRING,
       companyName STRING,
       primaryExchange STRING,
       openPrice FLOAT,
       openTime BIGINT,
       closePrice FLOAT,
       closeTime BIGINT,
       highPrice FLOAT,
       highTime BIGINT,
       lowPrice FLOAT,
       lowTime BIGINT,
       latestPrice FLOAT,
       latestUpdate BIGINT,
       receiveDate STRING,
       latestVolume FLOAT,
       previousClosePrice FLOAT,
       previousVolume FLOAT,
       change FLOAT,
       changePercent FLOAT,
       volume FLOAT,
       avgTotalVolume FLOAT,
       marketCap FLOAT,
       peRatio FLOAT,
       week52High FLOAT,
       week52Low FLOAT,
       ytdChange FLOAT,
       lastTradeTime BIGINT   
   )
   PARTITIONED BY (symbol STRING)
   ROW FORMAT DELIMITED
      FIELDS TERMINATED BY ','
   LINES TERMINATED BY '\n'
   LOCATION '/user/hive/BDT/StockDaily';
  ```
- Create table partitions: create 3 sample partitons to stote data for Apple, Google, Microsoft stocks info.
  ```
  LOAD DATA INPATH
  '/user/cloudera/BDT/FinalProject/Stock/AAPLSampleData.txt'
  INTO TABLE stockdaily
  PARTITION (symbol='AAPL');

  LOAD DATA INPATH
  '/user/cloudera/BDT/FinalProject/Stock/GOOGLSampleData.txt'
  INTO TABLE stockdaily
  PARTITION (symbol='GOOGL');

  LOAD DATA INPATH
  '/user/cloudera/BDT/FinalProject/Stock/MSFTSampleData.txt'
  INTO TABLE stockdaily
  PARTITION (symbol='MSFT');

  ```
### 5.2 Hive ODBC for Reporting and PowerBI
   Configuring, installing and connecting Hive using ODBC 
 - https://towardsdatascience.com/connecting-apache-hive-to-microsoft-power-bi-d460e2278720
 - https://github.com/ngocbaosp/BDT/blob/master/Documentation/Hive%20and%20PowerBI.pptx

## 6. Power BI
 - Download and install PowerBI Desktop: https://powerbi.microsoft.com/en-us/downloads/

## 7. Maven Repositories (using in this project)
 - Kafka Client: https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
 - Sparkstreaming: https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
 - SparkStreamingKafka: https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka-0-10_2.12/3.0.1
## 8. Other useful references
- https://spark.apache.org/docs/latest/streaming-kafka-0-10-integration.html
- https://github.com/apache/spark/blob/v3.0.1/examples/src/main/java/org/apache/spark/examples/streaming/JavaDirectKafkaWordCount.java
