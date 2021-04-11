package ControllersTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AllControllersGetMethodsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndexGetDefault() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    @Test
    public void testRegistrationGetDefault() throws Exception {
        this.mockMvc.perform(get("/rg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }
    @Test
    public void testTopicGetDefault() throws Exception {
        this.mockMvc.perform(get("/topic?topic=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic"));
    }
}
