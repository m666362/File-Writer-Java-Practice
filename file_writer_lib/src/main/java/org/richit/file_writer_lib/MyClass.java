package org.richit.file_writer_lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyClass {

    static String dot = "----------------";
    private static void startProgramme() {
        String start = "Programme started";
        System.out.println("");
        System.out.println(dot+start+dot);
        System.out.println("");
    }
    public static void endProgramme(){

        String end = "Programme ended";
        System.out.println("");
        System.out.println(dot+end+dot);
        System.out.println();
    }
    public static void main(String[] args) {

        startProgramme();

        writeFile();
        readFile();

        endProgramme();
    }

    private static void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader( new File( "Test.txt" ) ) )){

            while (bufferedReader.ready()){
                System.out.println( bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found : "+ e.toString());
        } catch (IOException e) {
            System.out.println("File cant be read : "+ e.toString());
        }
    }

    private static void writeFile() {

        try (BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( new File( "Test.txt" ) ) )){

            bufferedWriter.write( "This is line no. 1\n" );
            bufferedWriter.newLine();
            bufferedWriter.write( "This is line no. 12\n" );
            bufferedWriter.newLine();
            bufferedWriter.write( "This is line no. 3" );
        } catch (IOException e) {
            System.out.println("File not written: " + e.toString());
        }
    }


}
