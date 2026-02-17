package com.example.RoutineCrudProject.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// config folder ma @Configuration annotation rakhinxa
//@Configuartion vaneko server chalen bitikae yo class configure garne ho(rules haru define gareko hunxa)
@Configuration

public class ModelMapperConfig {
    @Bean
    //Converting Request → Entity
//Converting Entity → Response
   public ModelMapper modelMapper(){
       ModelMapper modelMapper=new ModelMapper();
       modelMapper.getConfiguration()
               //yo part le chai name  + datatype dubai milnu parxa vanxa
               //Ele chai kunai pani value jun aauxa ni convert garne bela ma
               // ani tesko datatype pani same hunu parxa ani name pani same nai hunu parxa
               //StudentRequest.name  → StudentEntity.name yo milxa kina ki name ra name
               // xa convert garne bela ani data type ni string xa
               //StudentRequest.studentName  → StudentEntity.name yo mildaina studentName
               // lai convert gardai xa tara entity ma name banako xa so name vaena error falxa
               .setMatchingStrategy(MatchingStrategies.STRICT)
               //esle chai kunai value null aako xa vane telai ignore gardinxa
               .setSkipNullEnabled(true)
               // Without Deep Copy
               //Both students may share the same course object.
               //If one changes the course name → it changes for both students.
               //With Deep Copy
               //Each student gets their own separate course
               .setDeepCopyEnabled(true);
       return modelMapper;
   }
}
