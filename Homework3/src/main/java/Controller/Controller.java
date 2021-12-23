package Controller;

import Exeptions.UserAlreadyExistException;
import Model.Model;
import Model.User;
import View.View;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void createUser() {
        try {
            User user =view.getUser();
            model.saveUser(user);
        }
        catch (UserAlreadyExistException e){
            System.out.println(e.getMessage());
            this.createUser();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Locale locale = new Locale("en");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        Controller c = new Controller(new Model(bundle), new View(bundle));
        c.createUser();
    }
}
