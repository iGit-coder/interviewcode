import com.example.interfaces.TestInterface;
import com.example.tests.SortArgorithm;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        TestInterface ti = new SortArgorithm();
        ti.test();
    }
}
