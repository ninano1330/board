import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeon.board.config.ApplicationConfig;
//import org.junit.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ApplicationConfig.class})
public class JunitTest {
	@Test
	public void ttteeee() throws Exception{
		//Assert.assertEquals(1, 1);
		//
	}
}
