package my.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    
    @Value("${key1}")
    private String a;

}
