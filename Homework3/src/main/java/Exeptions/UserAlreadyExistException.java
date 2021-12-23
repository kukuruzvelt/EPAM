package Exeptions;

public class UserAlreadyExistException extends Exception{
    private String nickname;
    public String getNickname(){return nickname;}
    public UserAlreadyExistException(String message, String nick){
        super(message);
        nickname=nick;
    }
}
