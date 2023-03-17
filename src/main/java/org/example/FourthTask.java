package org.example;

import java.util.Arrays;
import java.util.List;

public class FourthTask {
    public static Integer pairCountFirst(List<Integer> values, Integer target ){
        int counter = 0;
        for(int i = 0 ; i < values.size();i++){
            for(int j = i+1; j < values.size(); j++){
                if(target.equals(values.get(i) + values.get(j))){
                    counter++;
                }
            }
        }
        return  counter;
    }
    public static Long pairCountSecond(List<Integer> arr, Integer target){
        //Long count = values.stream().filter(it -> values.stream().filter(at -> at > it ).anyMatch(j -> j+it==target)).count();

        return arr.stream()
                .flatMap(i -> arr.stream()
                        .filter(j -> !i.equals(j) && i + j == target)
                        .map(j -> i + " + " + j + " = " + target))
                .count()/2;
    }
}
