package com.decode.decode.controller;

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
        System.out.println("first commit");
        System.out.println("second commit");
        System.out.println("third commit");
        System.out.println("fourth commit");
    }

}