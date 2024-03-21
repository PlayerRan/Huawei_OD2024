package com.huawei.od2024.utils;
import java.io.*;
public class IOdealer{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String getStrInput(String str_input){
        try {
            str_input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str_input;
    }
    public static void pushStrOutput(String str_output){
        try {
            writer.write(str_output);
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int getIntegerInput(int input){
        try {
            input = Integer.parseInt(reader.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }

}
