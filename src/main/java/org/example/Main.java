package org.example;


import java.io.IOException;

/**
 * 1 STEP
 * GET /calculate?operand1=11&operator=*&operand=55
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}