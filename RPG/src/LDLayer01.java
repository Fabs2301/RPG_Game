import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;

public class LDLayer01 {

	final LImages Images = new LImages();

	public int setMap = 1;
	private int x = 0;
	private int y = 0;

	private int offsetx = 0;
	private int offsety = -128;

	private boolean scroolable = true;

	LDLayer01() {

	}

	public void draw(GraphicsContext ge) throws IOException {
		
			String filedef = "C:\\Users\\Fabs\\eclipse-workspace\\RPG\\src\\maps\\map"+setMap+"_layer01.csv";
			File file = new File(filedef);

			try {
				Scanner inputStream = new Scanner(file);
				while (inputStream.hasNextLine()) {
					String data = inputStream.nextLine();
					String[] dataStr = data.split(",");
					for (int i = 0; i < dataStr.length; i++) {
						Images.chooseTile(x, y, dataStr[i], ge);
						x = x + 128;
					}
					y = y + 128;
					if (scroolable == true) {
						x = offsetx;
					} else {
						x = 0;
					}

				}

				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (scroolable == true) {
				y = offsety;
			} else {
				y = 0;
			}

			System.out.println("(Offset x:"+offsetx+"| offset y:"+offsety+"");
			
		

	}

	public void test(int deltax, int deltay) {

		offsetx = offsetx + deltax;
		offsety = offsety + deltay;
	}

	public boolean isScroolable() {
		return scroolable;
	}

	public void setScroolable(boolean scroolable) {
		this.scroolable = scroolable;
	}

}
