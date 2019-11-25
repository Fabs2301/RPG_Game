import javafx.scene.canvas.GraphicsContext;

public class PlayerController {

	int x;
	int y;
	private String facingDirection;

	LImages Image = new LImages();

	PlayerController(int x, int y, String facingDirection) {
		this.x = x;
		this.y = y;
		this.facingDirection = facingDirection;
	}

	public void draw(GraphicsContext ge) {
		switch (facingDirection) {
		case "mnorth":
			ge.drawImage(Image.player_move_north, x, y);
			break;
			
		case "meast":
			ge.drawImage(Image.player_move_east, x, y);
			break;

		case "msouth":
			ge.drawImage(Image.player_move_south, x, y);
			break;

		case "mwest":
			ge.drawImage(Image.player_move_west, x, y);
			break;
			
		case "snorth":
			ge.drawImage(Image.player_standing_north, x, y);
			break;
			
		case "seast":
			ge.drawImage(Image.player_standing_east, x, y);
			break;
			
		case "ssouth":
			ge.drawImage(Image.player_standing_south, x, y);
			break;
			
		case "swest":
			ge.drawImage(Image.player_standing_west, x, y);
			break;
			

		}
System.out.println(facingDirection);
	}

	public void move(int deltax, int deltay) {
		x = x + deltax;
		y = y + deltay;
	}

	public String getFacingDirection() {
		return facingDirection;
	}

	public void setFacingDirection(String facingDirection) {
		this.facingDirection = facingDirection;
	}
	
	
}
