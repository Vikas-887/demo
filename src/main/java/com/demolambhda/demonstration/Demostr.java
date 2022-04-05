package com.demolambhda.demonstration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demostr {
    public static void main(String[] args) {
        //  String Reverse program
        String str="MAM";
        StringBuilder builder=new StringBuilder();
        builder.append(str);
        builder.reverse();
        String newstString=builder.toString();
        System.out.println(newstString);
        if (str.equalsIgnoreCase(newstString))
            System.out.println("Palindrome");

        String str1 = "A quick brown fox ,jumped ,over ,the  grass eating lazy fox";
          
        // split the string by comma
        String[] strParts = str1.split(",");
          
        // convert array to the List using asList method
        List<String> listParts = Arrays.asList((strParts));
       List<String> listPartsNewList = listParts.stream().map((t) -> t.toLowerCase()).toList();
          
        // create HashSet from the List using constructor
        HashSet<String> hsetFromString = new HashSet<String>( listParts );
        Set<String> newSet=listParts.stream().collect(Collectors.toSet());
          
        System.out.println("HashSet contains: " + hsetFromString);
        System.out.println(newSet); 
        System.out.println(listPartsNewList);
 
        Set<Character> cSet=new HashSet<>();
        for(int i=0; i<str1.length();i++) {
            if (Character.isLetter(str1.charAt(i)))
            cSet.add(Character.toUpperCase(str1.charAt(i)));
        }

        System.out.println(cSet.size() +" :"+  cSet);
    }
}
