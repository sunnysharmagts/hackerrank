package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunny on 12/7/17.
 */
public class PasswordCracker {

    private static final String WRONG_PASSWORD = "WRONG PASSWORD";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int testCases = scanner.nextInt();
        PasswordCracker passwordCracker = new PasswordCracker();
        for(int i = 0; i < testCases; i++){
            int passwordListSize = scanner.nextInt();
            List<String> passwordList = new ArrayList<>();
            for(int j = 0; j < passwordListSize; j++){
                passwordList.add(scanner.next());
            }
            String password = scanner.next();
            System.out.println(passwordCracker.checkPassword(passwordList, password));
        }
        scanner.close();
    }

    public String checkPassword(List<String> passwordList, String password){
        String finalPassword = null;
        if(password == null || passwordList.isEmpty()){
            finalPassword = WRONG_PASSWORD;
            return finalPassword;
        }
        if(passwordList.contains(password)){
            finalPassword = password;
        }else{
            List<String> list = new ArrayList<String>();
            checkPassword(passwordList, password, new StringBuilder(), 0, list);
            if(list == null || list.isEmpty()){
                finalPassword = WRONG_PASSWORD;
            }
        }

        return finalPassword;
    }

    public boolean checkPassword(List<String> passwordList, String originalPassword, StringBuilder password, int index, List<String> list){
        if(index >= originalPassword.length()){
            if(passwordList.contains(password.toString())){
                list.add(password.toString());
                System.out.println("Got: "+password);
                password = new StringBuilder();
            }
        }

        for(int i = 0; i < originalPassword.length(); i++){
            password.append(originalPassword.charAt(i));
            System.out.println(password);
            checkPassword(passwordList, originalPassword, password, index+1, list);
            password.setLength(password.length() - 1);
        }
        return false;
    }

    /*public StringBuilder checkPassword(List<String> passwordList, String originalPassword, StringBuilder password, int index, List<String> list){
        if(index > passwordList.size()){
            return null;
        }

        if(isPasswordValid(list, originalPassword)){
            return password;
        }
        if(password.length() > originalPassword.length()){
            return null;
        }

        for(int i = 0; i < originalPassword.length(); i++){
            password.append(originalPassword.charAt(i));
            if(checkPassword(passwordList, originalPassword, password, index, ))
        }
        return null;
    }*/

    /*private boolean isPasswordValid(List<String> password, String originalPassword){
        if(password.isEmpty()){
            return false;
        }
        List<String> temp = new ArrayList<>(password);
        int count = 0;
        String tempPassword = originalPassword;
        while(!temp.isEmpty()){
            String value = temp.get(count);
            if(!tempPassword.contains(value)){
                return false;
            }else{
                temp.remove(count);
                tempPassword = tempPassword.replace(value, "");
            }
        }
        return temp.isEmpty() && tempPassword.isEmpty();
    }*/
}
