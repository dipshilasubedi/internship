package com.example.RoutineCrudProject.core.payload;

public class GlobalResponseBuilder {
    private GlobalResponseBuilder(){

    }
    public static GlobalResponse buildSucessResponse(String message){
        return GlobalResponse.builder()
                .status(true)
                .message(message)
                .build();
    }
    public static GlobalResponse buildSucessResponseWithData(String message, Object object){
        return GlobalResponse.builder()
                .status(true)
                .message(message)
                .data(object)
                .build();
    }
}
