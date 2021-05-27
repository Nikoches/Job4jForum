package ControllersTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MessageControlTest {
    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setAll() throws Exception {
        this.mockMvc.perform(post("/createpost")
                .param("Post_name", "Куплю ладу-грант. Дорого.")
                .param("Post_id", "1")
                .param("Post_desc", "from test"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        this.mockMvc.perform(post("/createMessage")
                .param("post_id", "1")
                .param("message_body", "test_body"));

    }
    @Test
    public void testMessageGetDefault() throws Exception {
        this.mockMvc.perform(get("/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

}
