package com.example.pulsartest;

import com.example.pulsartest.model.User;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class PojoFunction implements Function<User, User> {

    @Override
    public User process(User user, Context cntxt) throws Exception {
        //user.
        user.setName(user.getName()+"!!!");
        return user;
    }
    
}
