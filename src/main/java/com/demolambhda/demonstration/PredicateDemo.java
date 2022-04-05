package com.demolambhda.demonstration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class PredicateDemo {
    
   
    public static void main(String[] args) {
        Predicate<Integer> predicate = t -> t%2==0;
        //System.out.println(predicate.test((long) 453332));
        
        Supplier<String> supplier=()-> " Hello Suppliers Found as No Show";
        //System.out.println("\n"+ supplier.get());
        List<String> list=Arrays.asList();
        List<Integer> list2=Arrays.asList(12, 33, 76);
        System.out.println(list.stream().findAny().orElseGet(supplier));
        list2.stream().filter(t -> t%3==0).forEach((t)-> System.out.println(" Printing :" + t));
        list2.stream().filter(t -> t%4==0).forEach((t)-> System.out.println(" Four :" + t));
        list2.stream().filter(predicate).forEach((t)-> System.out.println(" Printing :" + t));
        List<Integer> list3= list2.stream().filter(t-> t%2==0).collect(Collectors.toList());
        System.out.println(list3);
    }
    
}
