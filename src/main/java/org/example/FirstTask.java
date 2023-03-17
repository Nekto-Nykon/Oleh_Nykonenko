package org.example;

import java.util.List;

public class FirstTask {
    public static void getIntegersFromList(List<Object> list ){
        List <Object> result = list.stream().filter(it -> Integer.class.isInstance(it))
                .toList();
        for (Object obj : result) {
            System.out.println(obj);
        }

    }
}
