package commandTests;

import command.LogInCommand;
import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import user.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LogInCommandTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    User user = new User("mafusaillo", "dan", "haha");

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
        new LogInCommand(userData).execute();
        assertEquals(1, userData.getUserData().size());
    }
}