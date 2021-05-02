package ControllersTest;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import ru.job4j.forum.storage.MessageStorage;
import ru.job4j.forum.storage.PostsStorage;
import ru.job4j.forum.storage.UsersStorage;
@Profile("test")
@Configuration
public class DbConfigMock {
    @Bean
    @Primary
    public MessageStorage messageStorage() {
        return Mockito.mock(MessageStorage.class);
    }

    @Bean
    @Primary
    public PostsStorage postsStorage() {
        return Mockito.mock(PostsStorage.class);
    }

    @Bean
    @Primary
    public UsersStorage usersStorage() {
        return Mockito.mock(UsersStorage.class);
    }
}
