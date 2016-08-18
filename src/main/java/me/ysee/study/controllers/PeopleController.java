package me.ysee.study.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by herosea on 16/8/17.
 */
@RestController
public class PeopleController {

    @RequestMapping("/people/{id}")
    public Person fetch(@PathVariable int id){
        return new Person("名字", true, id);
    }
}
