package com.a97lynk.article;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDemoApplicationTests {

    RestTemplate res = new RestTemplateBuilder().build();

    @Test
    public void contextLoads() {
//        List list = res.getForEntity("http://localhost:8080/api/v1/articles", List.class).getBody();
//        list.stream().forEach(System.out::println);
    }

}
