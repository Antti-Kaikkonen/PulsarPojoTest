A POJO generating pulsar source connector and a transforming function for testing purposes. Created to test avro encoding with POJO objects: https://github.com/apache/pulsar/issues/5503#issuecomment-590032460

### 0 Build
```
mvn install
```

### 1 Create POJO source with avro encoding
```
./pulsar-admin sources create --name pojo-source --destinationTopicName users --source-type pojo_source --schema-type 'avro'
```
### 2 Create function
```
./bin/pulsar-admin functions create \
  --jar blockchain-functions/PulsarPOJOFunction-1.0-SNAPSHOT-jar-with-dependencies.jar \
  --classname com.example.pulsartest.PojoFunction \
  --name pojo-function \
  --inputs user \
  --output user2
```
