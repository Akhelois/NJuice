package dashboard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Application implements EventHandler<ActionEvent> {
	
	BorderPane container;
	MenuBar landingPage;
	Menu dashboardMenu;
	MenuItem login, register;
	Scene scene;
	GridPane formContainer;
	
	Label usernameLbl, passwordLbl;
	TextField usernameTf;
	PasswordField passwordPf;
	
	public void init() {
		container = new BorderPane();
		scene = new Scene(container, 600, 600);
		landingPage = new MenuBar();
		dashboardMenu = new Menu("Dashboard");
		login = new MenuItem("Login");
		register = new MenuItem("Register");
	}
	
	public void position() {
		landingPage.getMenus().add(dashboardMenu);
		dashboardMenu.getItems().add(login);
		dashboardMenu.getItems().add(register);
		
		container.setTop(landingPage);
		container.setCenter(formContainer);
	}
	
	public void addAction() {
    	register.setOnAction(this);
    	login.setOnAction(this);
    }
	
	public Login() {
		init();
		position();
		addAction();
	}

	@Override
	public void start(Stage arg0) throws Exception {

		arg0.setTitle("Login");
		arg0.setScene(scene);
		arg0.show();
		
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(arg0.getSource() == register) {
			Stage curr = (Stage) landingPage.getScene().getWindow();
			curr.close();
			
			Stage next = new Stage();
			try {
				new Register().start(next);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
