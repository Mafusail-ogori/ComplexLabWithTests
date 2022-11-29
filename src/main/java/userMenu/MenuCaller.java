package userMenu;

import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

import static userMenu.Menu.wholeMenu;

public class MenuCaller {
    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        wholeMenu();
    }
}