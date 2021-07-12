import com.example.interfaces.TestInterface;
import com.example.tests.SortArgorithm;
import com.example.tests.TreeArgorithm;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // TestInterface ti = new SortArgorithm();
        TestInterface ti = new TreeArgorithm();
        ti.test();//终于成功了！
    }
}
