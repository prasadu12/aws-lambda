package com.techprimers.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.*;

import java.util.Collections;

public class LambdaJavaAPI implements RequestHandler<Object, GatewayResponse> {

    @Override
    public GatewayResponse handleRequest(Object object, Context context) {

        String message = "Hello from AWS LAMBDA DEMO...";
        Date current_Date = new Date();
        message= message +" /n Executed at  .."+ current_Date.toString();
        System.out.println(message);

        GatewayResponse response = new GatewayResponse(
                message,
                200,
                Collections.singletonMap("X-Powered-By", "TechPrimers"),
                false
        );
        return response;
    }
}
