import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    private String surnamePattern = "[A-Z][a-z]+";
    private String nicknamePattern = "[A-Za-z0-9]+";
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public String getSurname() throws IOException {
        System.out.println("Enter your surname:");
        String surname = bufferedReader.readLine();
        Pattern pattern = Pattern.compile(surnamePattern);
        Matcher matcher = pattern.matcher(surname);
        if(!matcher.matches()){
            throw new IOException();
        }
        return surname;
    }

    public String getNickname() throws IOException {
        System.out.println("Enter your nickname:");
        String nickname = bufferedReader.readLine();
        Pattern pattern = Pattern.compile(nicknamePattern);
        Matcher matcher = pattern.matcher(nickname);
        if(!matcher.matches()){
            throw new IOException();
        }
        return nickname;
    }
}
