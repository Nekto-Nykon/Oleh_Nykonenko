package org.example;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SeventhTask {
    public static String convertIntegerToIP(Long value){
        String binaryValue = StringUtils.leftPad(Long.toBinaryString(value), 32, '0');

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Integer.parseInt(binaryValue.substring(0,8), 2));
        stringBuilder.append(".");
        stringBuilder.append(Integer.parseInt(binaryValue.substring(8,16), 2));
        stringBuilder.append(".");
        stringBuilder.append(Integer.parseInt(binaryValue.substring(16,24), 2));
        stringBuilder.append(".");
        stringBuilder.append(Integer.parseInt(binaryValue.substring(24,32), 2));
        return stringBuilder.toString();
    }
}
