package me.ysee.study.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by herosea on 16/8/17.
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Person> index(){
        return Arrays.asList(new Person("用户1", true, 1000),
                new Person("用户2", false, 2000));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person fetch(@PathVariable int id){
        return new Person("名字", true, id);
    }
}
