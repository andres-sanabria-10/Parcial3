package com.example.Parcial3.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    static public ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObject){
        Map<String,Object> map = new HashMap<>();
        map.put("massagge",message);
        map.put("status",status);
        map.put("data",responseObject);

        return new ResponseEntity<Object>(map,status);
    }
}
