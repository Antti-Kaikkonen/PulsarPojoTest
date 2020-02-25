##Pulsar POJO function
A pulsar function for testing purposes. Appends "!!!" to user name.

### Create
./bin/pulsar-admin functions create \
  --jar blockchain-functions/PulsarPOJOFunction-1.0-SNAPSHOT-jar-with-dependencies.jar \
  --classname com.example.pulsartest.PojoFunction \
  --name pojo-function \
  --inputs user \
  --output user2

