package com.example.fileupload.util;

import java.io.*;

public class FileCopy {

    /**
     * 直接用string类型的路径不便于递归调用。
     * 因为string转file容易，file转string还要调用方法。
     * <p>
     * destFile 要怎么往下一层传递？要怎么变？就好想是为积分一样，因变量需要有一个函数刻画。
     * 用的是File的一个特殊构造器：File(parent, child)
     * <p>
     * 这个例子很好，体现了File类中一些API的应用场景。
     * <p>
     * 递归程序也好写，因为最外层是个分支结构，用于说明在不同的情形下要干什么。
     *
     * @param srcFile  源文件夹
     * @param destFile 目标文件夹
     */
    public static void copy(File srcFile, File destFile) {


        if (!srcFile.exists()) { // 被拷贝的对象是否是一个有效路径
            return;
        }

//        if (!destFile.exists()) {
//            boolean b = destFile.mkdir();  // 为什么不能放在外面？因为destFile有可能是一个文件，这就不需要新建文件夹了。
//            System.out.println(b);
//        }

        if (srcFile.isDirectory()) {

            if (!destFile.exists()) {
                // 如果不创建文件夹，copy过来的文件就没有放置的地方。
                // 每次只下一层，所以不需要mkdirs
                boolean b = destFile.mkdir();
                System.out.println(b);
            }

            File[] files = srcFile.listFiles(); // 起到扫描文件的效果。list()方法返回的是文件名的String[]。
            for (File child : files) {
//                if (child.isDirectory()) { // 每次进入copy函数就会讨论，所以这里不必讨论。
                // 创建子目录，child必须是string类型.
                // child一定得是相对于父路径的路径。而不能是绝对路径。
                // 否则就与destFile不兼容了。因为这个child是属于srcFile的。
                // 而相对路径其实就是文件夹的名字！
                File src = new File(srcFile, child.getName());
                File dest = new File(destFile, child.getName());
                copy(src, dest);
//                }
            }

        } else { // else里面其实写的是具体的业务逻辑，会变化。if里面是不变的，用于遍历文件夹。

            // else里面的代码就是一个双流对接，文件的读写。实际工作用用个FileUtil即可，代码太长。
            // 定义双流
            InputStream is = null;
            FileOutputStream os = null;

            try {
                is = new FileInputStream(srcFile);
                os = new FileOutputStream(destFile);
                // 读取准备：缓存，实际字节数
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    // 同样参数的read方法其实并没有用。而在write里面确实必须。
                    os.write(buffer, 0, length);
                }
            } catch (IOException e) {

                e.printStackTrace();

            } finally {
                // 标准关流：判断非空，捕获异常
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
