package KDTreeProvider;

import datastruct.KDTree;
import datastruct.KeyDuplicateException;
import datastruct.KeySizeException;
import module.TestPoint;

import java.io.*;
import java.util.List;

import static Util.FileUtil.readFile;


/**
 * Created by Sha0w on 2017/3/24.
 *
 */
public class getTree {
    private KDTree<TestPoint> getNormalKDTree(int k, String fileName) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        KDTree<TestPoint> kdTree = new KDTree<TestPoint>(k);
        String temp = "";
        String[] tempList;
        while ((temp = reader.readLine()) != null) {
            tempList = temp.split(",");
            if (tempList.length < 4) break;
            double lat = Double.parseDouble(tempList[0]);
            double lon = Double.parseDouble(tempList[1]);
            try {
                kdTree.insert(new double[]{lat, lon}, new TestPoint(lat,lon , tempList[2],tempList[3]));
            } catch (KeySizeException | KeyDuplicateException e) {
                e.printStackTrace();
            }
        }
        return kdTree;
    }

    public static KDTree<TestPoint> getInnerConfigNormalKDTree() throws IOException {
        return new getTree().getNormalKDTree(2, "knn.txt");
    }

    public static KDTree<TestPoint> getOutterConfigNormalKDTree(int k, String fileName) throws IOException {
        List<TestPoint> li = readFile(fileName);
        KDTree<TestPoint> kdTree = new KDTree<TestPoint>(k);
        for (TestPoint tp : li) {
            try {
                kdTree.insert(new double[]{tp.getLat(),tp.getLon()}, tp);
            } catch (KeySizeException | KeyDuplicateException e) {
                e.printStackTrace();
            }
        }
        return kdTree;
    }

}
