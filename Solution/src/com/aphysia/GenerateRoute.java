package com.aphysia;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public class GenerateRoute {
    static String format ="    * [%s](/剑指OfferV2/%s)";
    String fileName = "/Users/xuwenhao/Nutstore Files/我的坚果云/codeSolution/剑指OfferV2";

    static String leetCode = "    * [%s](/leetcode/%s)";
    static String leetcodeName= "/Users/xuwenhao/Nutstore Files/我的坚果云/codeSolution/leetcode";

    static String coderFormat = "    * [%s](/程序员面试金典/%s)";
    static String coderName= "/Users/xuwenhao/Nutstore Files/我的坚果云/codeSolution/程序员面试金典";

    public static void main(String[] args) {
        folderMethod1(coderName,coderFormat);
    }
    public static void folderMethod1(String path,String format) {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        LinkedList<File> list = new LinkedList<>();

        if (file.exists()) {
            if (null == file.listFiles()) {
                return;
            }
            list.addAll(Arrays.asList(file.listFiles()));
            list.sort((l1,l2)->l1.getName().compareTo(l2.getName()));
            for (File file1:list){
                System.out.println(String.format(format,file1.getName().replace(".md",""),file1.getName()));
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹数量:" + folderNum + ",文件数量:" + fileNum);
    }
}
