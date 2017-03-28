package Util;


import module.TestPoint;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sha0w on 2017/2/27.
 */
public class FileUtil {
    private static String outputpath = "./src/main/resources/output";
    public static void FileWrite(String message, String filename) {
        File f = new File(outputpath + "/" + filename);
        if (!f.exists()) {
            try {
                boolean newFile = f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedOutputStream bufferedOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(f);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(message.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> fileRead(String FileName, String split) throws FileNotFoundException {
        File f = new File(outputpath + "/" + FileName);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        List<String> temp = new LinkedList<>();
        FileInputStream in = null;
        Charset cs = Charset.forName ("UTF-8");
        try {
            in = new FileInputStream(f);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            FileChannel fcIn = in.getChannel();
            // FileInputStream:从文件系统中的某个文件中获得输入字节。
            in = new FileInputStream(f);
            while (true) {
                buffer.clear();
                int r = fcIn.read(buffer);
                if (r == -1) {
                    break;
                }
                buffer.flip();
                String[] bufferResult = cs.decode(buffer).toString().split(split);
                Collections.addAll(temp, bufferResult);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return temp;
    }

    public static List<TestPoint> readFile(String fileName) throws IOException {
        List<TestPoint> ret = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(outputpath + "/" + fileName));
        String temp = "";
        String[] tempList;
        while ((temp = br.readLine()) != null) {
            tempList = temp.split(",");
            ret.add(new TestPoint(Double.parseDouble(tempList[0]) + 0.05, Double.parseDouble(tempList[1]) + 0.05, tempList[2],tempList[3]));
        }
        return ret;
    }
}
