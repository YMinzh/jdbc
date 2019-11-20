package com.company;

import com.company.dao.*;
import com.company.entity.Person;

import java.util.Scanner;

public class Main {
    static Util util = new Util();
    static Scanner sc = new Scanner(System.in);

    public static String myAdd(){
        String result;
        System.out.println("输入添加的姓名");
        String name = sc.next();
        System.out.println("请输入电话号码");
        String reg = "^1[3456789]\\d{9}$";
        sc = new Scanner(System.in);
        String phone = sc.next();
        if(!phone.matches(reg)){
            return "电话号码错误";
        }
        Person per = new Person(name,phone);
        result = util.add(per);
        return result;
    }
    public static String myDelete(){
        String result;
        System.out.println("输入删除的姓名");
        String name = sc.next();
        Person per = new Person(name,null);
        result = util.delete(per);
        return result;
    }
    public static String myChange(){
        String result;
        System.out.println("输入更改的姓名");
        String name = sc.next();
        System.out.println("请输入更改后的电话号码");
        String reg = "^1[3456789]\\d{9}$";
        sc = new Scanner(System.in);
        String phone = sc.next();
        if(!phone.matches(reg)){
            return "电话号码错误";
        }
        Person per = new Person(name,phone);
        result = util.change(per);
        return result;
    }
    public static String mySelect(){
        String result;
        System.out.println("输入查询的的姓名  all表示所有人");
        String name = sc.next();
        Person per = new Person(name,null);
        result = util.select(per);
        return result;
    }
    public static void main(String[] args){
        out:while(true) {
            System.out.println("请选择你要的操作");
            System.out.println("1代表添加  2代表删除  3代表更改  4代表查询  0代表退出");
            Scanner sc = new Scanner(System.in);
            var topChoose = sc.next();
            String result = "";
            switch (topChoose){
                case "1":
                    result = myAdd();
                    break;
                case "2":
                    result = myDelete();
                    break;
                case "3":
                    result = myChange();
                    break;
                case "4":
                    result = mySelect();
                    break;
                case "0":
                    break out;
                default:
                    result = ("输入有误  请重新输入 ");
                    break;
            }
            System.out.println(result);
        }
    }
}
