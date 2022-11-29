package commandTests;

import command.SignUpCommand;
import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SignUpCommandTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    String inputString =
            "mafusaillo" +
                    System.getProperty("line.separator") +
                    "dan" +
                    System.getProperty("line.separator") +
                    "haha" +
                    System.getProperty("line.separator") +
                    "dpo.prots@gmail.com";

    @Test
    @DisplayName("Sign up should work")
    public void signUpTest() throws IOException {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        new SignUpCommand(userData).execute();
        assertEquals(1, userData.getUserData().size());
    }
}
