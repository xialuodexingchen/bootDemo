package com.example.demo;

/**
 * @program: bootdemo
 * @description:
 * @author: linxiaojiu
 * @create: 2018/9/30
 **/
public class LambdaTest2 {



    public static void main(String[] args) {


        Test test =new Test();
        test.test(new MyInterface() {
            @Override
            public void test() {
                System.out.println("重写");
            }
        });
        test.test(new MyClass());
        test.test(new MyClass2());

        test.test(()-> {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("lambda");
        });


        //        MyInterface myInterface = new MyInterface() {
//            @Override
//            public void test() {
//                System.out.println("重写");
//            }
//        };
//
//        MyInterface myInterface1 =()-> System.out.println("lambda");
//
//        MyInterface myInterface2 =new MyClass();
//        MyInterface myInterface3 =new MyClass2();
//
//        myInterface.test();
//        myInterface1.test();
//        myInterface2.test();
//        myInterface3.test();
    }



}
@FunctionalInterface
interface MyInterface{
    void test();
}

class MyClass implements MyInterface{

    @Override
    public void test() {
        System.out.println("myClass");
    }
}
class MyClass2 implements MyInterface{

    @Override
    public void test() {
        System.out.println("myClass2");
    }
}

class Test{
    public void test(MyInterface myInterface){
        myInterface.test();
    }
}
