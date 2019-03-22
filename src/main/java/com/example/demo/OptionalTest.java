package com.example.demo;

import java.util.Optional;

/**
 * @program: bootdemo
 * @description:
 * @author: linxiaojiu
 * @create: 2018/9/30
 **/
public class OptionalTest {

    public static void main(String[] args) {
        Optional< String > fullName = Optional.ofNullable( "aaaa");
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
//        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElseGet(()->"Hey Stranger!" ) );


//        Optional< String > fullName = Optional.of( null );
//        System.out.println( "Full Name is set? " + fullName.isPresent() );
//        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
//        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
//        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElseGet(()->"Hey Stranger!" ) );
    }
}
