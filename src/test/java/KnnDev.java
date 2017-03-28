
import KDTreeProvider.getTree;
import datastruct.KDTree;
import datastruct.KeySizeException;
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
    KDTree<TestPoint> kdTree;
    @Before
    public void init() throws IOException {
        kdTree = getTree.getInnerConfigNormalKDTree();
    }
    @Test
    public void test() throws KeySizeException {
        System.out.print(kdTree.nearest(new double[]{39.932199,116.352526}).getCity());
    }
}
