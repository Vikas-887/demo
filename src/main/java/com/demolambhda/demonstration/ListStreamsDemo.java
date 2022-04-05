package com.demolambhda.demonstration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;

public class ListStreamsDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("locker1", "my123");
        map.put("locker2", "my223");
        map.put("alocker3", "my323");
        map.put("socker4", "my423");
        System.out.println(map.entrySet().stream().sorted());

        //  Converting Map to List using streams
        List<Entry<String,String>> nList=map.entrySet().stream().toList();

        // Converting map to list and also filtering values
        List<Entry<String,String>> nnList=map.entrySet().stream().filter((key)->key.getKey()
        .startsWith("s")).toList();
            System.out.println(nList);
            System.out.println(nnList);
        // Converting array to list in java 8
        int[] sal= {38,65,66,90,12,56};
        List<Integer> iList= Arrays.stream(sal).boxed().toList();  // java 8 method
            System.out.println(iList);
        List<Integer> newList=iList.stream().map((t)-> t + 10).toList();
        List<Integer> nxtList=newList.stream().filter((t)->t>70).toList();
            System.out.println(newList);
            System.out.println(nxtList);
        



    }
}
