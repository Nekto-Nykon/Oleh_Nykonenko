package org.example;

public class ThirdTask {
    public static Integer digital_root(Integer number){
        String num = number.toString();
        while (num.length()!=1){
            Integer sum = 0 ;
            for (int i = 0 ; i < num.length(); i++){
                sum += Character.getNumericValue(num.charAt(i));
            }
            num = sum.toString();
        }
        return Integer.valueOf(num);
    }
}
