
import module.TestPoint;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


import static Util.FileUtil.FileWrite;
import static Util.FileUtil.readFile;

/**
 * Created by Sha0w on 2017/3/24.
 */
public class KnnDev {
    List<TestPoint> li ;
    @Before
    public void init() throws IOException {
        li = readFile("knn.txt");
    }
    @Test
    public void test(){
        StringBuffer sb = new StringBuffer();
        for (TestPoint tp : li) {
            sb.append(tp.toString() + "\r\n");
        }
        FileWrite(sb.toString(),"knn_new.txt");
    }
}
