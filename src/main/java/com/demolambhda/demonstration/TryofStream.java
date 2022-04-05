package com.demolambhda.demonstration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions.SumFunction;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.SUM;


public class TryofStream {
    public static void main(String[] args) {
        int[] sal= {38,65,66,90,12,56};        
    List<Integer> empSal=new ArrayList<Integer>();
    empSal=Arrays.stream(sal).boxed().toList();
    List<Integer> sList=empSal.stream().filter(((t) -> t>=50)).map(t->t+10).toList();
    System.out.println(empSal);
    System.out.println(sList);
    empSal.stream().filter(((t) -> t>=50)).forEach(System.out::println);
    OptionalDouble avg= empSal.stream().mapToInt(t->t.intValue()).average();
    int sum=empSal.stream().mapToInt(t->t.intValue()).sum();
    System.out.println(avg + "::"+ sum); 
    

    }
}
