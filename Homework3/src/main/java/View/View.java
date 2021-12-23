package View;

import Model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    private String surnamePattern;
    private String nicknamePattern;
    private BufferedReader bufferedReader ;
    private ResourceBundle bundle;

    public View(ResourceBundle bundle) {
        this.bundle = bundle;
        this.surnamePattern = bundle.getString("surnamePattern.regexp");
        this.nicknamePattern = bundle.getString("nicknamePattern.regexp");
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public User getUser() throws IOException {
        System.out.println(bundle.getString("enter_surname"));
        String surname = bufferedReader.readLine();
        Pattern pattern = Pattern.compile(surnamePattern);
        Matcher matcher = pattern.matcher(surname);
        if(!matcher.matches()){
            throw new IOException(bundle.getString("wrong_surname"));
        }

        System.out.println(bundle.getString("enter_nickname"));
        String nickname = bufferedReader.readLine();
        pattern = Pattern.compile(nicknamePattern);
        matcher = pattern.matcher(nickname);
        if(!matcher.matches()){
            throw new IOException(bundle.getString("wrong_nickname"));
        }

        return new User(surname, nickname);
    }

}
