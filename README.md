# Big Data Technology Course


## Kafka Commands
- Create topic:
  - kafka-topics --zookeeper quickstart.cloudera:2181 --create --topic ***topicname*** --partitions 1 --replication-factor 1
- Delete topic:
  - kafka-topics --zookeeper quickstart.cloudera:2181 --topic ***topicname*** --delete
