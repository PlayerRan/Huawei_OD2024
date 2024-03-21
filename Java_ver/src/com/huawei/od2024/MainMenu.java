package com.huawei.od2024;

import java.io.*;
public class MainMenu {
    public static void main(String [] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int choice;

        writer.write("菜单选项:\n");
        writer.write("程序1:\n");
        writer.write("程序2:\n");
        writer.write("程序3:\n");
        writer.write("程序4:\n");
        writer.flush();

        choice = Integer.parseInt(reader.readLine());

        switch (choice){
            case 1:
                break;
            case 2:
                new Thread(new OD2024c2()).run();
                break;
            case 3:
                new Thread(new OD2024c3()).run();
                break;
            case 4:
                new Thread(new OD2024c4()).run();
                break;
            case 0:
                writer.write("程序退出\n");
                break;
        }
    }
}
