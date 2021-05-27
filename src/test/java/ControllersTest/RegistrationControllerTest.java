package ControllersTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.domain.User;
import ru.job4j.forum.storage.MessageStorage;
import ru.job4j.forum.storage.PostsStorage;
import ru.job4j.forum.storage.UsersStorage;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UsersStorage usersStorage;
    @Test
    public void testRegistrationGetDefault() throws Exception {
        this.mockMvc.perform(get("/rg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));

    }

    @Test
    public void whenCreatingUserHeExist() throws Exception {
        this.mockMvc.perform(post("/rg").param("username", "testuser").param("password", "pass"))
                .andDo(print());
        Assert.assertEquals(new User("testuser","pass"), usersStorage.findAll().iterator().next());
    }

}
