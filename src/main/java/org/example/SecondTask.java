package org.example;

public class SecondTask {
    public static String first_non_repeating_letter(String str){
       String lowerStr = str.toLowerCase();
       for (int i = 0; i < lowerStr.length(); i++){
           int count = 0;
           for (int j = 0 ; j < lowerStr.length(); j++){
               if(lowerStr.charAt(i) == lowerStr.charAt(j))
                   count++;
           }
           if (count == 0){
               return String.valueOf(str.charAt(i));
           }
       }
       return "";

    }
}
