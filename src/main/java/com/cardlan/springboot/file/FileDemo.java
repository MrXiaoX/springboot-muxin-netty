package com.cardlan.springboot.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        File file=new File("E:\\param\\springboot-muxin-netty\\src\\main\\resources\\config");

        System.out.println("获取绝对路径:"+file.getAbsolutePath());
        System.out.println("获取路径:"+file.getPath());
        System.out.println("获取名称:"+file.getName());
//        System.out.println("获取父路径:"+file.getParent());
//        System.out.println("获取绝对路径:"+file.length());
//        System.out.println("获取最后一次的修改时间，毫秒值:"+file.lastModified());
//        String[] list = file.list();
//        System.out.println(Arrays.toString(list));

        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
        long sum=0;
        for (File file1 : files) {
            sum+=file1.length();
        }
        System.out.println(sum);


//        System.out.println(file.isDirectory());
//        System.out.println(file.isFile());
//        System.out.println(file.canRead());
//        System.out.println(file.canWrite());
//        System.out.println(file.isHidden());

//        File file2=new File("E:\\param\\springboot-muxin-netty\\src\\main\\resources\\config\\demo.txt");
//        boolean newFile = file2.createNewFile();
//        System.out.println(newFile);


    }
}
