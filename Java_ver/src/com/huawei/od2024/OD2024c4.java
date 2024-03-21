package com.huawei.od2024;

import com.huawei.od2024.utils.IOdealer;

import java.util.*;

public class OD2024c4 implements Runnable{
//    public String l1;

    public class Employee implements Comparable<Employee>{
        int id;
        int score;
        public Employee(int id,int score){
            this.id = id;
            this.score = score;
        }
        @Override
        public int compareTo(Employee o){
            return Integer.compare(this.score,o.score);
        }
    }

    @Override
    public void run() {

        int count = IOdealer.getIntegerInput(0);   //List长度
        List<Employee> employeeList = new ArrayList<>();
        List<int[]> pairs = new ArrayList<>();
        int min_val = 300;  //可允许的最大差值

        HashMap<Integer,List<Integer>> score_map = new HashMap<>();
        for (int i = 0;i<count;i++){
            String oneLine = IOdealer.getStrInput(null);
            String[] onePair = oneLine.split(" ");
            int id_temp = Integer.parseInt(onePair[0]);
            int score_temp = Integer.parseInt(onePair[1]);

            score_map.computeIfAbsent(score_temp, k -> new ArrayList<>()).add(id_temp);
            employeeList.add(new Employee(id_temp, score_temp));
        }
    }
}
