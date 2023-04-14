package org.example;

public class ThirdTask {
    public static Integer digital_root(Integer number){
        Integer sum = 0;
        while(number != 0){
            sum += number % 10;
            number /= 10;
        }
        if (sum < 10){
            return sum;
        }
        return digital_root(sum);
    }
}
