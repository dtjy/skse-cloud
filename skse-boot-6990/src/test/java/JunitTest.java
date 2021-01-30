import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author skse
 * @date 2021/1/30 12:06
 */
public class JunitTest {

    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }

    @After
    public void after(){
        System.out.println("after");
    }
}
