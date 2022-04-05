package com.demolambhda.demonstration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
public class PlayingList {
  public static void main(String[] args) {
      
  
    String[] myStr={"hello","India","","Pakistan","bhutan","Nepal", ""};
    List<String> list=Arrays.asList(myStr);
    System.out.println(list);
   list.stream().filter((t) -> t.startsWith("I")).forEach((t)-> System.out.println(" Items Starting from 'I' :" + t));
//    Comparator<String> comparator= Comparator.comparing(list);
   Collections.reverse(list);
   System.out.println(list);
   Stream<String> stream1Stream=list.stream().filter((t)->t.startsWith("h"));
   System.out.println(stream1Stream);
  boolean test= list.stream().anyMatch(t-> t.equalsIgnoreCase("iTndia"));
  System.out.println(test);
  System.out.println(list.stream().filter((t)->t.startsWith("I")).findAny().orElseGet(() -> "  Hello No Found AnyThing"));

List list2= list.isEmpty()|| list==null ? null : list;

System.out.println(list2);

}  
}
