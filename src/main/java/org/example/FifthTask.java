package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FifthTask {
        public static String upOrder(String s ){
                s = s.toUpperCase();
                List<String> names = List.of(s.split(";"));
                List<Guest> guests = new ArrayList<>();
                for(String name: names){
                        String[] splitedStr = name.split(":");
                        guests.add(new Guest(splitedStr[0], splitedStr[1]));
                }
                List<Guest> sortedGuests = guests.stream().sorted().collect(Collectors.toList());
                StringBuilder stringBuilder = new StringBuilder();
                for(Guest guest: sortedGuests){
                        stringBuilder.append("(");
                        stringBuilder.append(guest.getLastName());
                        stringBuilder.append(", ");
                        stringBuilder.append(guest.getFirstName());
                        stringBuilder.append(")");
                }
                return stringBuilder.toString();

        }

        static class Guest implements Comparable<Guest>{
                private String firstName;
                private String lastName;
                public String getFirstName(){
                        return this.firstName;
                }
                public String getLastName(){
                        return this.lastName;
                }
                public void setFirstName(String newFirstName){
                        this.firstName = newFirstName;
                }
                public void setLastName(String newLastName){
                        this.lastName = newLastName;
                }
                Guest(String fName, String lName){
                        this.firstName = fName;
                        this.lastName = lName;
                }

                @Override
                public int compareTo(Guest obj) {
                        if (lastName.compareTo(obj.getLastName()) > 0){
                                return 1 ;
                        }
                        if (lastName.compareTo(obj.getLastName()) < 0){
                                return -1;
                        }
                        return firstName.compareTo(obj.getFirstName());
                }
        }
}
