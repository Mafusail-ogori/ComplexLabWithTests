package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import user.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LogInTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    User user = new User("mafusaillo", "dan", "haha", "dpo.prots@gmail.com");

    @Mock
    String inputString =
            "mafusaillo" +
                    System.getProperty("line.separator") +
                    "haha";

    @Test
    @DisplayName("Log in should work")
    public void logInTest() throws IOException {
        userData.getUserData().add(user);
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        userData.logIn();
        assertEquals(1, userData.getUserData().size());
    }
}