package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class PersonController {
    @Autowired
    PersonRepository people;
@RequestMapping("/people")
   ResponseEntity< Person> createPerson(@RequestBody Person p){
        return new  ResponseEntity<>(people.save(p), HttpStatus.CREATED);
    }
@RequestMapping("/people/{id}")
ResponseEntity< Person> getPerson(@PathVariable Long id){
    return new  ResponseEntity<>(people.findOne(id), HttpStatus.OK);
//        return people.findOne(id);
    }
    @RequestMapping("/people")
    ResponseEntity<List<Person>> getPersonList(){
    List<Person> personList = new ArrayList<>();
       people.findAll().forEach(personList::add);
//       if(personList.isEmpty()){
//           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//       }
    return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @RequestMapping("/people/{id}")
    Person updatePerson(@RequestBody Person p){
        return null;
    }
    @RequestMapping("/people/{id}")
    void deletePerson(@PathVariable Long id){

    }
}
