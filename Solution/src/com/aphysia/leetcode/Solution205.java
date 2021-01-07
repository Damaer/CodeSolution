package com.aphysia.leetcode;

import java.util.HashMap;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null||s.length()!=t.length()){
            return false;
        }
        int length = s.length();
        HashMap<Character,Character> relations = new HashMap<>();
        for(int i= 0 ;i<s.length();i++){
            char c = s.charAt(i);
            char e = t.charAt(i);
            Character str = relations.get(c);
            if(str==null){
                if(relations.containsValue(e)){
                    return false;
                }
                relations.put(c,e);
            }else{
                if(str.charValue()!=e){
                    return false;
                }
            }
        }
        return true;
    }
}
