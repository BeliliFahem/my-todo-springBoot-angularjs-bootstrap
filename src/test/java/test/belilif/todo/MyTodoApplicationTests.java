package test.belilif.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import test.belilif.todo.MyTodoApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyTodoApplication.class)
@WebAppConfiguration
public class MyTodoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
