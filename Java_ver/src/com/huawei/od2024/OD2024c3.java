package com.huawei.od2024;

import com.huawei.od2024.utils.IOdealer;

/**
 * 给定用户密码输入流ainput，输入流中字符<'表示退格，可以清除前一个输入的字符，请你编写程序，输出最终得到的密码字符，
 * 并判断密码是否满足如下的密码安全要求。
 * 密码安全要求如下:
 * 1.密码长度>=8
 * 2.密码至少需要包含1个大写字母
 * 3.密码至少需要包含1个小写字母
 * 4.密码至少需要包含1个数字
 * 5.密码至少需要包含1个字母和数字以外的非空白特殊字符
 * 注意空串退格后仍然为空串，且用户输入9的字符串不包含<'字符和空白字符
 * 输入描述
 * 用一行字符串表示a输入的用户数据，输入的字符串中“字符标识退格，用户输入的字符串不包含空白字符.
 * 输出描述
 * 输出经过程序处理后，输出的实际密码字符串，并输出改密码字符串是否满足密码安全要求。两者间由,分隔
 * 示例1
 * 输入
 * ABC<c89%000<
 * 输出
 * ABc89%00.true
 * 说明
 * 解释:多余的C和0由于退格被去除,最终用户输入的密码为ABc89%00，且满足密码安全要求，输出true
 */

public class OD2024c3 implements Runnable{
    public String str_input;
    public int count_big = 0;
    public int count_small = 0;
    public int count_num = 0;
    public int count_others = 0;

    int i = 0;
    int index = 0;
    String fin_passwd="";
    @Override
    public void run() {
        str_input = IOdealer.getStrInput(str_input);
        if(str_input.length()<8)    IOdealer.pushStrOutput("false"+"\n");
        for(i=0;i<str_input.length();i++){
            if(str_input.charAt(i)!='<'){
                fin_passwd += str_input.charAt(i);
                index+=1;
                if(Character.isDigit(str_input.charAt(i)))  count_num += 1;
                else if(Character.isUpperCase(str_input.charAt(i))) count_big += 1;
                else if(Character.isLowerCase(str_input.charAt(i))) count_small += 1;
                else if(str_input.charAt(i)!=' ')   count_others += 1;
            }else{
                if(index>0) index-=1;
                fin_passwd = index>0?fin_passwd.substring(0,index):fin_passwd;
            }
        }
        if(count_big>0 && count_small>0 && count_num>0 && count_others>0 && index>=8)   IOdealer.pushStrOutput(fin_passwd+",true"+"\n");
        else IOdealer.pushStrOutput("false"+"\n");
    }
}
