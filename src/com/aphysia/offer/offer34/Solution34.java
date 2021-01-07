package com.aphysia.offer.offer34;

import com.sun.jdi.IntegerValue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution34 {
    public static void main(String[] args) {
        System.out.println(new Character('z').charValue()-'a');
        System.out.println(new Character('z').charValue()-'A');
        System.out.println(new Character('Z').charValue()-'A');
         int result = FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
         System.out.println(result);
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] nums = new int[58];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'A';
            if (nums[index] >= 0) {
                nums[index] = 999999999;
            } else {
                nums[index] = i;
            }
        }
        int index = 999999999;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1 && nums[i] != 999999999) {
                index = Math.min(index,nums[i]);
            }
        }
        return index==999999999?-1:index;
    }
    public static int FirstNotRepeatingChar1(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c, 999999999);
            }else{
                hashMap.put(c,i);
            }
        }
        Map.Entry<Character,Integer> entry = hashMap.entrySet().stream().filter(e->e.getValue()!=999999999).findFirst().orElse(null);
        if(entry==null){
            return -1;
        }else{
            return entry.getValue();
        }
    }
}
