package com.example.pulsartest;

import com.example.pulsartest.model.User;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.io.core.SourceContext;
import org.apache.pulsar.io.core.Source;


public class PojoSource implements Source<User>{
    
    @Override
    public void open(Map<String, Object> config, SourceContext sourceContext) {
    }
    
    private long counter = 0;

    @Override
    public Record<User> read() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PojoSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        Record<User> rec = new Record<User>() {
            
            private Long value = counter;

            @Override
            public Optional<String> getPartitionId() {
                return Optional.of("1"); 
            }
            
            @Override
            public Optional<Long> getRecordSequence() {
                return Optional.of(this.value); 
            }

            @Override
            public User getValue() {
                return new User("User"+Math.round(Math.random()*100), 
                        counter//, 
                        //new Coordinates(Math.round(Math.random()*100), Math.round(Math.random()*100))
                    );
            }
        };
        counter++;
        return rec;
    }

    @Override
    public void close() throws Exception {
    }
    
}