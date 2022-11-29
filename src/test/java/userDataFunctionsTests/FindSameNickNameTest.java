package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import user.User;

import static org.junit.Assert.assertTrue;

public class FindSameNickNameTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    User user = new User("mafusaillo", "dan", "haha", "dpo.prots@gmail.com");

    @Test
    @DisplayName("Find same nickName should work!")
    public void findSameNickNameTest(){
        userData.getUserData().add(user);
        assertTrue(userData.findSameNickName("mafusaillo") && !userData.findSameNickName("mamma"));
    }

}
