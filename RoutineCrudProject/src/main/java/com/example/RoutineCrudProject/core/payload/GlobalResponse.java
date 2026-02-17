package com.example.RoutineCrudProject.core.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

//d     name   email        password          address
//1  Linda   linda@gmail.com   123             null
//id:1
//name:Linda
//email:linda@gmail,com
//password:123
//address:null->yo part null ako xa so @JsonInclude(JsonInclude.Include.NOT_NULL) le hatai dinxa
@JsonInclude(JsonInclude.Include.NON_NULL)
//yo class le xae response kasto format ma dine vane ra k dine
public class GlobalResponse {
    // yo response le xae tala ko part haru dinxa
    private boolean status; //kunae pani API garera kam successful hunxa vane true dinxa viceversa
    private String message; // SUCCESSFULL message pathauxa
    private Object data; //get garne kheri kunae data aauxa tyo data response ko format ma hunxa so tae data dinxa

}
