package org.example;

import org.example.mybatis.Mybatis;
import org.example.t.MySqlTest;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "MyBatisTest" );
        Mybatis mybatis = new Mybatis();
        mybatis.selectAllBrand();
        mybatis.selectById();
    }
}
