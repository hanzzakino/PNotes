import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller extends Application{
	
	PNEditorUI editor = new PNEditorUI();
	Stage window;
	FileChooser file_ = new FileChooser();
	File file;
	Text txt;
	
	
	@Override
	public void start(Stage mainStage) throws IOException{
		this.window = mainStage;
		
		FileChooser.ExtensionFilter extFilterALLL = new FileChooser.ExtensionFilter("All Files","*.*");
		FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("Text File",".txt");
		file_.getExtensionFilters().addAll(extFilterALLL,extFilterTXT);
		
		UI_EVENTS();
		window.setScene(editor.SCENE);
		window.setTitle("PNote Editor");
		window.show();
	}
	
	public void UI_EVENTS(){
		
		editor._wrap.setOnAction(event -> {
			if(editor._wrap.isSelected()){
				editor.text_area.setWrapText(true);
			} else {
				editor.text_area.setWrapText(false);
			}
		});
		
		editor._save.setOnAction(event -> {
			if(file != null){
				saveTextFile(editor.text_area.getText());
			} else {
				editor._save_as.fire();
			}
			if(file != null){
				window.setTitle("PNote Editor - "+file.getName());
				editor.lines.setText("Path : "+file.getAbsolutePath());
				System.gc();
			}
		});
		editor._save_as.setOnAction(event -> {
			file = file_.showSaveDialog(window);
			if(file != null){
			saveTextFile(editor.text_area.getText());
			window.setTitle("PNote Editor - "+file.getName());
			editor.lines.setText("Path : "+file.getAbsolutePath());
			System.gc();
			}
		});
		editor._open.setOnAction(event -> {
			file = file_.showOpenDialog(window);
			if(file != null){
			window.setTitle("PNote Editor - "+file.getName());
			editor.text_area.setText(getTextFromFile());
			editor.lines.setText("Path : "+file.getAbsolutePath());
			System.gc();
			}
		});
		editor._new.setOnAction(event -> {
			file = new File("New.txt");
			if(file != null){
			window.setTitle("PNote Editor - "+file.getName());
			editor.text_area.setText(getTextFromFile());
			editor.lines.setText("Path : "+file.getAbsolutePath());
			System.gc();
			}
		});
		editor._exit.setOnAction(event -> {
			window.close();
		});

	}	
	
	
	
	public void saveTextFile(String content){
		try{
			PrintWriter writer = new PrintWriter(file); //Initialize writer object
			writer.println(content);
			writer.close();
		} catch(IOException ioe) {}
		
	}
	
	public String getTextFromFile(){
		String content  = "";
		try{
		Scanner fileScan = new Scanner(file);
		while(fileScan.hasNextLine()){
			content += fileScan.nextLine() + "\n";
		}
		fileScan.close();
		} catch(IOException e){}

		
		return content;
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
