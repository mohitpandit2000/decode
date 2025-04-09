package com.decode.decode.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class HealthCheckControllerTest {
    @BeforeAll
    public static void init(){
        System.out.println("hello");
    }
    @BeforeEach
    public void initialize(){
        System.out.println("initialization");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("after the test");
    }

}
