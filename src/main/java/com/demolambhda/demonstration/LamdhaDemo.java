package com.demolambhda.demonstration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.lang.*;

public class LamdhaDemo  {

    
    public static void main(String[] args) {
       
        // Consumer<String> consumer=new LamdhaDemo();
        Consumer<String> consumer2=(t)->  { System.out.println("\n\n Hello Data "+ t +" \n\n" + t );
                                            System.out.println("Hello This is another Line os Consumer");
    };
        // consumer.accept("12");
        consumer2.accept("vikas Kumar Sahu");
        String[] str= { "vikas", "avinash", "Mohan","nishant","vishal","akash"};
        List<String> list= Arrays.asList(str);
        List<String> list2=list.stream().filter(t-> t.startsWith("a") || t.startsWith("v")).collect(Collectors.toList());
        System.out.println(list2);

       if(!"teststring".equalsIgnoreCase(list.get(1))){ System.out.println("tested");}
        str[1].equalsIgnoreCase("anotherString");
        //String[] anothStrings= new String[list.size()];

        
       
    }

    @Override
    public String toString() {
        return "Hello This is for Testing";
    }

    // @Override
    // public void accept(String t) {
    //     // TODO Auto-generated method stub
    //     System.out.println("   \n\n\n\n value " + t +"\n\n\n");
        
    }
    

