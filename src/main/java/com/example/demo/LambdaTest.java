package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @program: bootdemo
 * @description:
 * @author: linxiaojiu
 * @create: 2018/9/25
 **/
public class LambdaTest {

//    public static void main(String[] args) {
//
//    }

    public static void main(String[] args) {
        File[] hiddenFiles1 = new File(".").listFiles((File f)->f.isHidden());
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
//
        List<String> names2 = new ArrayList<String>();
        names2.add("Runoob");
        names2.add("Google");
        names2.add("Taobao");
        names2.add("Baidu");
        names2.add("Sina");
//
//
        LambdaTest tester = new LambdaTest();
        System.out.println("使用 Java 7 语法: ");

        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");

        tester.sortUsingJava8(names2);
        System.out.println(names2);
//
        System.out.println(JSON.toJSONString(names2));
        Optional<String> any = names2.stream().findFirst();
        if(any.isPresent()){
            System.out.println("Optional:"+any.get());
        }
//
        Map<String, List<String>> map = names2.stream().collect(Collectors.groupingBy(x -> x));
        Optional<String> any2 = names2.stream().filter((String str) -> "Google".equals(str)).findAny();

        List<String> collect1 = names2.stream().parallel().filter((str) -> "Google".equals(str)).collect(Collectors.toList());
//        long count = names2.stream().filter((String str) -> "Google".equals(str)).count();
//        System.out.println("collect"+collect);
//        System.out.println("count"+count);


        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );

        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );


//        int a = 3;
//        Arrays.asList( "a", "b", "d" ).forEach( e -> {
//            a = 4;
//            System.out.print( e );
//            System.out.print( e );
//        } );

        List l = new ArrayList();
        l.add(new Person("aa","11"));
        l.add(new Person("bb","11"));
        l.add(new Person("aa","13"));
        l.add(new Person("cc","14"));
        l.add(new Person("cc","14"));
        Map<String, List<Person>> collect =(Map<String, List<Person>>) l.stream().collect(Collectors.groupingBy((Person p) -> p.getName()));
        System.out.println(JSON.toJSONString(collect));

    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (String s1, String s2) -> {return s1.compareTo(s2);});
    }
}

class Person{
    private String name;
    private String age;

    Person(String name,String age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

