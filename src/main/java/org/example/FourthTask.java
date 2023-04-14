package org.example;

import java.util.Arrays;
import java.util.List;

public class FourthTask {
    public static Integer pairCountFirst(List<Integer> values, Integer target ){
        int counter = 0;
        for(int iter = 0 ; iter < values.size();iter++){
            for(int positionForPair = iter+1; positionForPair < values.size(); positionForPair++){
                if(target.equals(values.get(iter) + values.get(positionForPair))){
                    counter++;
                }
            }
        }
        return  counter;
    }
    public static Long pairCountSecond(List<Integer> arr, Integer target){
        return arr.stream()
                .flatMap(elementOfArray -> arr.stream()
                        .filter(elementForPair -> !elementOfArray.equals(elementForPair) && elementOfArray + elementForPair == target)
                        .map(elementForPair -> elementOfArray + " + " + elementForPair + " = " + target))
                .count()/2;
    }
}
