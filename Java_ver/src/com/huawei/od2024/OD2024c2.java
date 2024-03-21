package com.huawei.od2024;
import java.util.*;
import java.io.*;
import com.huawei.od2024.utils.IOdealer;
public class OD2024c2 implements Runnable{
    /**
     * 将一个CSV格式的数据文件a中包含有单元格引用的内容替换为对应单元格内容的实际值.
     * 逗号分离值(Csv)逗号分隔值，csv格式的数据文件使用逗号作为分隔符a将各单位的内容进行分隔。
     * 输入描述
     * 1.输入只有一行数据，用逗号分隔每个单元格，行尾没有逗号.最多26个单元格，对应编号A-Z.
     * 2.每个单元格的内容包含字母和数字，以及使用<>分隔的单元格引用，例如：<A>表示引用第一个单元的值。
     * 3.每个单元格的内容，在替换前和替换后均不超过100个字符.
     * 5.引用单元格的位置不受限制，运行排在后面的单元格被排在前面的单元格引用.
     * 6.不存在循环引用Q的情况，比如下面这种场景是不存在的：
     * A单元格：ACD<B>8u
     * B单元格：Kay<A>dzqo
     * 7.不存在多重<>的情况，一个单元格只能引用一个其他单元格.比如下面这种场景是不存在的：
     * 单元格：aCd8u
     * B单元格：kaydzqo
     * C单元格：y<<A><B>>d
     * 输出描述：
     * 输出所有单元格展开的内容，单元格之间用逗号分隔.处理过程中出现错误时，输出字符串“-1”表示出错.
     * 示例1
     * 输入1，2<A>00
     * 输出1,2100
     * 说明
     * 第二个单元中有对A单元的引用，A单元格的值为1，替换时，将A单元的内容替代<A>的位置，并和其他内容合并.
     * 示例2
     * 输入<B>12，1
     * 输出
     * 112，1
     * 说明
     * 第一个单元中有对B单元的引用，B单元格的值为1，替换时，将第二个数据单元的内容替代<B>的位置，并和其他内容合并。
     */
    public static String[] cells;
//    BufferedReader reader_002 = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter writer_002 = new BufferedWriter(new OutputStreamWriter(System.out));
    public String str_input;
    public String str_output;
//    public IOdealer io = new IOdealer();

    @Override
    public void run(){
        str_input = IOdealer.getStrInput(str_input);
        cells = str_input.split(",");
        for (int i=0;i<cells.length;i++){
            if(!change(cells[i],i)){
                IOdealer.pushStrOutput("-1"+"\n");
                return;
            }
        }
        for (int i=0;i<cells.length;i++){
            IOdealer.pushStrOutput(cells[i]);
            if(i!=cells.length-1)   IOdealer.pushStrOutput(",");
        }
        IOdealer.pushStrOutput("\n");
//        IOdealer.pushStrOutput("答案为："+str_output+"\n");
    }

    public boolean change(String str_cur,int index){
        int r1 = str_cur.indexOf("<"); //取"<?>"作为子串，r1为左坐标
        int r2 = str_cur.indexOf(">"); //r2为右坐标

        if(r1==-1 && r2==-1)  return true;
        else if (r1==-1 || r2==-1)  return false; //'<' or '>' only
        else if(r1>r2 || r2-r1!=2)  return false; // >  <

        char target = str_cur.substring(r1+1,r2).charAt(0); //取<?>内部字母
        char cur = (char)(index+'A');
        if(!(cur>='A'&& cur<='Z'))  return false; //出界
        if(cur==target) return false;   //暂时没看懂啥意思
        int r_target = target-'A';  //字母对26取余
        if(!change(cells[r_target],r_target))   return false;
        String temp_result = "";
        temp_result += str_cur.substring(0,r1);
        temp_result += cells[r_target];
        temp_result += str_cur.substring(r2+1);
        cells[index] = temp_result;

        return true;
    }
}
