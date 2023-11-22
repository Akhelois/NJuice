package dashboard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Register extends Application implements EventHandler<ActionEvent> {
	
	BorderPane container;
	MenuBar landingPage;
	Menu dashboardMenu;
	MenuItem login, register;
	Scene scene;
	GridPane formContainer;
	
	TextField usernameTxt;
	PasswordField passwordTxt;
	CheckBox check;
	
	Label title, njuice, username, password;
	
	Button registerBtn;
	
	public void init() {
		
		container = new BorderPane();
		scene = new Scene(container, 600, 600);
		landingPage = new MenuBar();
		dashboardMenu = new Menu("Dashboard");
		login = new MenuItem("Login");
		register = new MenuItem("Register");
		
		usernameTxt = new TextField();
		passwordTxt = new PasswordField();
		
		check = new CheckBox("I agree to the terms and conditions of NJuice");
		
		title = new Label("Register");
		njuice = new Label("NJuice");
		username = new Label("Username");
		password = new Label("Password");
		
		registerBtn = new Button("Register");
		
		formContainer = new GridPane();
		
	}
	
	public void position() {
		title.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 32px;");
		njuice.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		
		formContainer.add(title, 0, 0);
		formContainer.add(njuice, 0, 1);
		
		formContainer.add(username, 0, 2);
		formContainer.add(usernameTxt, 0, 3);
		
		formContainer.add(password, 0, 4);
		formContainer.add(passwordTxt, 0, 5);
		
		formContainer.add(check, 0, 6, 2, 1);
		formContainer.add(registerBtn, 0, 7);
		
		landingPage.getMenus().add(dashboardMenu);
		dashboardMenu.getItems().add(login);
		dashboardMenu.getItems().add(register);
		
		container.setTop(landingPage);
		container.setCenter(formContainer);
		
		formContainer.setAlignment(Pos.CENTER);
		
		title.setAlignment(Pos.CENTER);
		registerBtn.setAlignment(Pos.CENTER);
		
		usernameTxt.setPrefWidth(300);
		passwordTxt.setPrefWidth(300);
		registerBtn.setPadding(new Insets(5));
		registerBtn.setPrefWidth(80);
		
		formContainer.setVgap(15);
		formContainer.setHgap(15);
		
	}
	
	public void addAction() {
    	register.setOnAction(this);
    	login.setOnAction(this);
    }

	public Register() {
		
		init();
		position();
		addAction();

	}

	@Override
	public void start(Stage arg0) throws Exception {

		arg0.setTitle("Register");
		arg0.setScene(scene);
		arg0.show();
		
	}

	@Override
	public void handle(ActionEvent arg0) {

		if (arg0.getSource() == login) {
			Stage curr = (Stage) landingPage.getScene().getWindow();
            curr.close();
			
			Stage next = new Stage();
			try {
				new Login().start(next);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
