package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import user.User;

import static org.junit.Assert.assertTrue;

public class FindSamePasswordTest {
    @Mock
    UserData userData = new UserData();;

    @Mock
    User user = new User("mafusaillo", "dan", "haha", "dpo.prots@gmail.com");

    @Test
    @DisplayName("Find Same password should work")
    public void findSamePasswordTest(){
        userData.getUserData().add(user);
        assertTrue(userData.findPassword("haha") && !userData.findPassword("bobo"));
    }
}
