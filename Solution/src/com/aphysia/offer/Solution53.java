package com.aphysia.offer;

public class Solution53 {
    public boolean isNumeric(String str) {
        int size = str.length();
        int index= 0 ;
        // 默认全部是false
        boolean hashNum=false ,hasE=false ,hasSign=false ,hasDot=false;
        // 跳过空格
        while(index<size&&str.charAt(index)==' '){
            index++;
        }
        while(index<size){
            while(index<size&&str.charAt(index)>='0'&& str.charAt(index)<='9'){
                index++;
                // 表示前面有数字
                hashNum = true;
            }
            // 到末尾直接跳出
            if(index==size){
                break;
            }
            char c = str.charAt(index);
            if(c=='e'||c=='E'){
                // 前面有E或者没有数字在前面
                if(hasE||!hashNum){
                    return false;
                }
                hasE = true;
                // 出现E了后面又可以出现数字了
                hashNum = false;
                hasSign = false;
                hasDot = false;
            }else if(c=='+'||c=='-'){
                if(hasSign||hashNum||hasDot){
                    return false;
                }
                hasSign = true;
            }else if(c=='.'){
                if(hasDot||hasE){
                    return false;
                }
                hasDot =true;
            }else if(c==' '){
                break;
            }else{
                return false;
            }
            index++;
        }        // 跳过空格
        while(index<size&&str.charAt(index)==' '){
            index++;
        }
        return hashNum &&index==size;
    }
}
