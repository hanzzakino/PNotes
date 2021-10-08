import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class PNEditorUI {
	
	Scene SCENE;
	MenuBar menu_bar;
		Menu file;
			MenuItem _new;
			MenuItem _open;
			SeparatorMenuItem _sep1;
			MenuItem _save;
			MenuItem _save_as;
			SeparatorMenuItem _sep2;
			MenuItem _exit;
		Menu edit;
			RadioMenuItem _wrap;
	TextArea text_area;
	HBox status_bar;
		Label lines;
	
	public PNEditorUI(){
		AnchorPane pane = new AnchorPane();
		
		menu_bar = new MenuBar();
		menu_bar.setPrefSize(600, 25);
		menu_bar.setLayoutX(0);menu_bar.setLayoutY(0);
		menu_bar.setId("menu-bar");
		AnchorPane.setTopAnchor(menu_bar, 0.0);
		AnchorPane.setLeftAnchor(menu_bar, 0.0);
		AnchorPane.setRightAnchor(menu_bar, 0.0);
		
		file = new Menu("File");
		edit = new Menu("Edit");
		
		
		_new = new MenuItem("New");
		_new.setAccelerator(KeyCombination.keyCombination("CTRL+N"));
		_open = new MenuItem("Open");
		_open.setAccelerator(KeyCombination.keyCombination("CTRL+O"));
		_sep1 = new SeparatorMenuItem();
		_save = new MenuItem("Save");
		_save.setAccelerator(KeyCombination.keyCombination("CTRL+S"));
		_save_as = new MenuItem("Save as");
		_save_as.setAccelerator(KeyCombination.keyCombination("CTRL+SHIFT+S"));
		_sep2 = new SeparatorMenuItem();
		_exit = new MenuItem("Exit");
		
		file.getItems().addAll(_new,_open,_sep1,_save,_save_as,_sep2,_exit);
		
		_wrap = new RadioMenuItem("Word wrap");
		
		edit.getItems().addAll(_wrap);
		
		menu_bar.getMenus().addAll(file,edit);
		
		pane.getChildren().add(menu_bar);
		
		text_area = new TextArea();
		text_area.setPrefSize(600, 355);
		text_area.setLayoutX(0);text_area.setLayoutY(25);
		AnchorPane.setTopAnchor(text_area, 25.0);
		AnchorPane.setLeftAnchor(text_area, 0.0);
		AnchorPane.setRightAnchor(text_area, 0.0);
		AnchorPane.setBottomAnchor(text_area, 20.0);
		pane.getChildren().add(text_area);
		
		
		lines = new Label("Path : ");
		status_bar = new HBox();
		status_bar.setPrefSize(600, 20);
		status_bar.setLayoutX(0);status_bar.setLayoutY(380);
		status_bar.setId("status-bar");
		status_bar.setAlignment(Pos.CENTER_LEFT);
		status_bar.getChildren().add(lines);
		AnchorPane.setLeftAnchor(status_bar, 0.0);
		AnchorPane.setRightAnchor(status_bar, 0.0);
		AnchorPane.setBottomAnchor(status_bar, 0.0);
		pane.getChildren().add(status_bar);
		
		
		
		SCENE = new Scene(pane,600,400);
		SCENE.getStylesheets().add(Controller.class.getResource("PStyle.css").toExternalForm());
		
	}
	
	

}
