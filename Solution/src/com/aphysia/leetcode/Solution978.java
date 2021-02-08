package com.aphysia.leetcode;

/**
 * @date 2021/2/8 14:24
 */
public class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        if(arr!=null){
            if(arr.length<=1){
                return arr.length;
            }else{
                int sum =1;
                int temp = 1;
                // 前面是等于，从当前开始
                int bigger = 0;
                for(int i=0;i<arr.length-1;i++){
                    if(bigger==0){
                        if(arr[i]>arr[i+1]){
                            bigger=-1;
                            temp++;
                        }else if(arr[i]<arr[i+1]){
                            bigger=1;
                            temp++;
                        }
                    } else if(bigger==1){
                        if(arr[i]>arr[i+1]){
                            bigger = -1;
                            temp++;
                        }else{
                            if(temp>sum){
                                sum=temp;
                            }
                            temp=2;
                            if(arr[i]==arr[i+1]){
                                bigger=0;
                                temp=1;
                            }
                        }
                    }else{
                        if(arr[i]<arr[i+1]){
                            bigger = 1;
                            temp++;
                        }else{
                            if(temp>sum){
                                sum=temp;
                            }
                            temp=2;
                            if(arr[i]==arr[i+1]){
                                bigger=0;
                                temp=1;
                            }
                        }
                    }
                }
                return Math.max(sum,temp);
            }
        }
        return 0;
    }
}
