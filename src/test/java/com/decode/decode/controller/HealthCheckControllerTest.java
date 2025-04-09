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
        System.out.println("git change ");
        System.out.println("first commit");
        System.out.println("git second commit");
        System.out.println("now will do rebase");
    }

}