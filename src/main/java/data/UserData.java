//Receiver
package data;

import logger.Log;
import user.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static graphicsText.Graphics.*;

public class UserData {
    public List<User> getUserData() {
        return userData;
    }

    protected List<User> userData = new ArrayList<>();

    public boolean findSameEmailAddress(String emailAddress){
        for (User user: userData) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress)){
                return true;
            }
        }
        return false;
    }

    public boolean findSameNickName(String nickName) {
        for (User user : userData) {
            if (user.getUserName().equalsIgnoreCase(nickName)) {
                return true;
            }
        }
        return false;
    }

    public boolean findPassword(String password){
        for (User user : userData){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void signUp() throws IOException {
        FileWriter record = new FileWriter("C:\\Users\\Danylo\\ComplexLabWithTests\\src\\main\\resources\\signUpRecords.txt", true);
        System.out.println(signUpText);
        Scanner scanner = new Scanner(System.in);
        String nickName, userName, password, emailAddress;
        System.out.print("Enter nickname >> ");
        nickName = scanner.next();
        if (!findSameNickName(nickName)){
            record.append(nickName).append("\n");
            System.out.print("Enter your name >> ");
            userName = scanner.next();
            record.append(userName).append("\n");
            System.out.print("Enter password >> ");
            password = scanner.next();
            record.append(password).append("\n");
            System.out.print("Enter your emailAddress >> ");
            emailAddress = scanner.next();
            record.append(emailAddress).append("\n");
            userData.add(new User(nickName, userName, password, emailAddress));
        }
        else{
            System.out.println("This username is taken already!");
            signUp();
        }
        record.close();
    }
    public User findUser(String userInput, String password){
        for (var user : userData) {
            if ((user.getUserName().equalsIgnoreCase(userInput) || user.getEmailAddress().equalsIgnoreCase(userInput)) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public boolean accountExistsInFile(String userName) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Danylo\\ComplexLabWithTests\\src\\main\\resources\\signUpRecords.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()){
            if(scanner.nextLine().equalsIgnoreCase(userName)){
                return true;
            }
        }
        fileReader.close();
        return false;
    }

    public void deleteFromFile(String userName) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Danylo\\ComplexLabWithTests\\src\\main\\resources\\signUpRecords.txt");
        FileWriter fileWriter2 = new FileWriter("C:\\Users\\Danylo\\ComplexLabWithTests\\src\\main\\resources\\signUpRecords.txt", true);
        List<String> recordings = new ArrayList<>();
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()){
            recordings.add(scanner.next());
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\Danylo\\ComplexLabWithTests\\src\\main\\resources\\signUpRecords.txt");
        fileWriter.close();
        for (var i = 0; i < recordings.size(); i++) {
            if(recordings.get(i).equalsIgnoreCase(userName)){
                recordings.remove(i);
                recordings.remove(i);
                recordings.remove(i);
                recordings.remove(i);
            }
        }
        for (var recording : recordings) {
            fileWriter2.append(recording).append("\n");
        }
        fileReader.close();
        fileWriter2.close();
    }


    public void deleteAccount() throws IOException {
        System.out.println(deleteAccountText);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name, or email address of account you want to delete >> ");
        String userInput = scanner.next();
        if((findSameNickName(userInput) || findSameEmailAddress(userInput)) && accountExistsInFile(userInput)){
            System.out.print("Enter password >> ");
            String password = scanner.next();
            if (findPassword(password)){
                Log.logMail(findUser(userInput, password).getUserName() + " account was deleted");
                Log.logInfo(UserData.class, " account deleted");
                this.userData.remove(findUser(userInput, password));
                deleteFromFile(userInput);
                System.out.println("Deleted successfully!");
            }
            else{
                System.out.println("Incorrect password");
                Log.logInfo(UserData.class, "incorrect password detected");
            }
        }
        else{
            System.out.println("There is no such account in a storage!");
        }
    }

    public void logIn() throws IOException {
        System.out.println(logInText);
        String userInput, password;
        var scanner = new Scanner(System.in);
        System.out.print("Enter nickname or email address >> ");
        userInput = scanner.next();
        if(findSameNickName(userInput) || findSameEmailAddress(userInput)){
            System.out.print("Enter password >> ");
            password = scanner.next();
            if(findPassword(password)){
                System.out.println("Logged in successfully!");
            }
            else{
                System.out.println("Incorrect password! try again!");
                Log.logMail("Tried to enter an account with uncorect password");
                Log.logInfo(UserData.class, "incorrect password attempt");
                logIn();
            }
        }
        else{
            System.out.println("Looks like you are not registered yet, sign up first!");
            signUp();
        }
    }

    public void fileReading() throws IOException {
        FileReader getAccounts = new FileReader("C:\\Users\\Danylo\\ComplexLabWithTests\\src\\main\\resources\\signUpRecords.txt");
        Scanner scanner = new Scanner(getAccounts);
        while(scanner.hasNext()){
            userData.add(new User(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
        }
        getAccounts.close();
    }
}