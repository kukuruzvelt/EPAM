import java.io.IOException;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void createUser() {
        try {
            String surname = view.getSurname();
            String nickname = view.getNickname();
        }
        catch (IOException e){
            System.out.println("ERROR");
        }
    }

    public static void main(String[] args) {
        Controller c = new Controller(new Model(), new View());
        c.createUser();
    }
}
