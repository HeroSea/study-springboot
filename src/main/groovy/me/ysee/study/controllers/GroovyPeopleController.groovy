package me.ysee.study.controllers

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by herosea on 16/8/18.
 */
@RestController
@RequestMapping("/people2")
class GroovyPeopleController {

    @RequestMapping("/{id}")
    def fetch(@PathVariable int id){
        return new Person("问蜜", false, 3);
    }
}
