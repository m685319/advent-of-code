package com.example.aoc;

import com.example.aoc.day01.Day01;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java -jar ... <day>");
            return;
        }
        switch (args[0]) {
            case "1": Day01.run(); break;
            //case "2": Day02.run(); break;

            default: System.out.println("Unknown day: " + args[0]);
        }
    }
}
