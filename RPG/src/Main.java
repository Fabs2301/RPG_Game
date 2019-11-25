import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<KeyEvent> {

	int heigth = 1080;
	int width = 1920;

	final LImages Images = new LImages();
	final LDLayer01 Map = new LDLayer01();
	final LDLayer02 Layer02 = new LDLayer02();
	final PlayerController Controlller = new PlayerController((width / 2 - 49), (heigth / 2) - 126, "ssouth");
	Scene sc;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	int speed = 5;

	boolean camerScrool = true;

	public static void main(String args[]) {
		Application.launch();
	}

	public void start(final Stage primaryStage) throws Exception {

		primaryStage.setTitle("The Legend of ...");
		// primaryStage.getIcons().add();

		Group root = new Group();
		final Canvas canvas = new Canvas(width, heigth);
		canvas.setFocusTraversable(true);
		
		canvas.setOnKeyPressed(this);
		root.getChildren().add(canvas);
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(this);
		
		sc = new Scene(root, Color.BLACK);
		primaryStage.setScene(sc);
		

		primaryStage.show();
		
		primaryStage.setFullScreen(true);

		new AnimationTimer() {

			@Override
			public void handle(long currentNanoTime) {
				try {
					// Screenblanking:
					canvas.getGraphicsContext2D().clearRect(0, 0, primaryStage.getWidth(), primaryStage.getHeight());
					
				

					Map.draw(canvas.getGraphicsContext2D());
					Controlller.draw(canvas.getGraphicsContext2D());
					Layer02.draw(canvas.getGraphicsContext2D());
					
					if (left == true) {
						if (Map.isScroolable() == true) {
							Map.test(speed, 0);
							Layer02.test(speed, 0);
							Controlller.setFacingDirection("mwest");
						} else {
							Controlller.move(-speed, 0);
							Controlller.setFacingDirection("mwest");
						}
					}

					if (right == true) {
						if (Map.isScroolable() == true) {
							Map.test(-speed, 0);
							Layer02.test(-speed, 0);
							Controlller.setFacingDirection("meast");
						} else {
							Controlller.move(speed, 0);
							Controlller.setFacingDirection("meast");
						}
					}

					if (down == true) {
						if (Map.isScroolable() == true) {
							Map.test(0, -speed);
							Layer02.test(0, -speed);
							Controlller.setFacingDirection("msouth");
						} else {
							Controlller.move(0, speed);
							Controlller.setFacingDirection("msouth");
						}
					}

					if (up == true) {
						if (Map.isScroolable() == true) {
							Map.test(0, speed);
							Layer02.test(0, speed);
							Controlller.setFacingDirection("mnorth");
						} else {
							Controlller.move(0, -speed);
							Controlller.setFacingDirection("mnorth");
						}
					}
						
						

					if(up == false && Controlller.getFacingDirection().equals("mnorth")) {
						Controlller.setFacingDirection("snorth");
					}else if(right == false && Controlller.getFacingDirection().equals("meast")) {
						Controlller.setFacingDirection("seast");
					}else if(down == false && Controlller.getFacingDirection().equals("msouth")) {
						Controlller.setFacingDirection("ssouth");
					}else if(left == false && Controlller.getFacingDirection().equals("mwest")) {
						Controlller.setFacingDirection("swest");
					}
					
					Map.setScroolable(camerScrool);
					Layer02.setScroolable(camerScrool);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}.start();

		sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) { // don't use toString here!!!
					right = true;
				} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					left = true;
				} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					down = true;
				} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					up = true;
				} else if (event.getCode() == KeyCode.SHIFT) {
					speed = 9;
				}
			}
		});

		sc.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) { // don't use toString here!!!
					right = false;
				} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					left = false;
				} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					down = false;
				} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					up = false;
				} else if (event.getCode() == KeyCode.SHIFT) {
					speed = 5;
				}
			}
		});
	}

	@Override
	public void handle(KeyEvent event) {
		// TODO Auto-generated method stub

	}
}
