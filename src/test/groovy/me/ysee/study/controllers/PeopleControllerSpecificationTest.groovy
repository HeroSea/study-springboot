package me.ysee.study.controllers

import me.ysee.study.StudySpringbootApplication
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.core.IsEqual.equalTo
import static org.hamcrest.Matchers.containsString

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by herosea on 16/8/18.
 * 参考 http://www.jianshu.com/p/f1e354d382cd
 *
 * 名字Test结尾, mvn test 才默认会执行
 */
@SpringBootTest
class PeopleControllerSpecificationTest extends Specification {

    @Shared
    boolean sharedSetupDone = false;
    @Shared
    private MockMvc mockMvc;

    void setup() {
        if (!sharedSetupDone){
            mockMvc = MockMvcBuilders.standaloneSetup(new PeopleController()).build();
            sharedSetupDone = true;
        }
    }

    def "Index"() {
        when:
        def result = mockMvc.perform(get("/people").accept(MediaType.APPLICATION_JSON))

        then:
        result.andExpect(status().isOk())
        result.andExpect(content().string(containsString("用户1")))
    }

    def "Fetch"() {
        when:
        def result = mockMvc.perform(get("/people/${id}").accept(MediaType.APPLICATION_JSON))

        then:
        result.andExpect(status().isOk())
        result.andExpect(content().string(equalTo(json)))

        where:
        id  | json
        100 | "{\"name\":\"名字\",\"sex\":true,\"age\":100}"
        110 | "{\"name\":\"名字\",\"sex\":true,\"age\":110}"
    }
}
