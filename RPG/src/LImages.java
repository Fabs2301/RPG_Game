import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class LImages {

	
	public Image test2 = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\titleBackground.jpg"));
	public Image grass = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\grass.png"));
	public Image stone = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone.png"));
	public Image stone_bottom = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_bottom.png"));
	public Image stone_top = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_top.png"));
	public Image stone_left = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_left.png"));
	public Image stone_right = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_right.png"));
	public Image stone_corner_leftbottom = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_corner_leftbottom.png"));
	public Image stone_corner_rightbottom = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_corner_rightbottom.png"));
	public Image stone_corner_lefttop = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_corner_lefttop.png"));
	public Image stone_corner_righttop = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\stone_corner_righttop.png"));
	
	
	
	
//Layer 02:	
	public Image fountain = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\fountain.png"));
	public Image bench = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\bench.png"));
	public Image lantern = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\lantern.gif"));

	
	
	
	
//Layer 03 (Player):
	public Image player_standing_north = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_standing_north.png"));
	public Image player_standing_east = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_standing_east.png"));
	public Image player_standing_south = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_standing_south.png"));
	public Image  player_standing_west = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_standing_west.png"));
	public Image player_move_north = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_move_north.gif"));
	public Image player_move_east = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_move_east.gif"));
	public Image player_move_south = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_move_south.gif"));
	public Image  player_move_west = new Image(LImages.class.getClassLoader().getResourceAsStream("\\Images\\player_move_west.gif"));
	
	
	
	public void chooseTile(int x, int y, String tileName, GraphicsContext ge) {
		
		tileName = tileName.toLowerCase();
		
		switch (tileName) {
		
		case "grs":
			ge.drawImage(grass, x, y);
			break;
		case "sto":
			ge.drawImage(stone, x, y);
			break;
		case "slb":
			ge.drawImage(stone_corner_leftbottom, x, y);
			break;
		case "slt":
			ge.drawImage(stone_corner_lefttop, x, y);
			break;
		case "srb":
			ge.drawImage(stone_corner_rightbottom, x, y);
			break;
		case "srt":
			ge.drawImage(stone_corner_righttop, x, y);
			break;
		case "stb":
			ge.drawImage(stone_bottom, x, y);
			break;
		case "stt":
			ge.drawImage(stone_top, x, y);
			break;
		case "stl":
			ge.drawImage(stone_left, x, y);
			break;
		case "str":
			ge.drawImage(stone_right, x, y);
			break;
		case "ftd":
			ge.drawImage(fountain, x, y);
			break;
		case "bnc":
			ge.drawImage(bench, x, y);
			break;
		case "lan":
			ge.drawImage(lantern, x, y);
			break;
		}
	}
}
