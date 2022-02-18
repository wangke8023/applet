import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangke
 * @description:这是一个测试程序
 * @date 2021/06/25
 */
@SpringBootTest
public class study {
	@Test
	public void test1(){
		ApplicationContext context = new AnnotationConfigApplicationContext();
	}
}
