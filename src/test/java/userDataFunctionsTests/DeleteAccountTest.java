package userDataFunctionsTests;

import command.DeleteAccountCommand;
import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import user.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DeleteAccountTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    User user = new User("mafusaillo", "dan", "haha", "dpo.prots@gmail.com");

    @Mock
    String userAnswer = "mafusaillo" +
            System.getProperty("line.separator") +
            "haha";

    @Test
    @DisplayName("Delete account should work properly")
    public void deleteAccountTest() throws IOException {
        userData.getUserData().add(user);
        System.setIn(new ByteArrayInputStream(userAnswer.getBytes()));
        userData.deleteAccount();
        assertEquals(0, userData.getUserData().size());
    }
}