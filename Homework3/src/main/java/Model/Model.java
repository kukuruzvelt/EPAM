package Model;

import java.util.ArrayList;
import java.util.ResourceBundle;

import Exeptions.UserAlreadyExistException;
import Model.User;

public class Model {
    private ArrayList<User> users = new ArrayList<>();
    private ResourceBundle bundle;

    public Model(ResourceBundle bundle) {
        this.bundle = bundle;
        users.add(new User("first", "1a"));
        users.add(new User("second", "2b"));
    }

    public void saveUser(User user) throws UserAlreadyExistException {
        for (User us : users) {
            if (us.getNickname().equals(user.getNickname())){
                throw new UserAlreadyExistException(bundle.getString("user_already_exist"), user.getNickname());
            }
        }
        users.add(user);
    }

}



