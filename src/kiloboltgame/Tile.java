package kiloboltgame;

import java.awt.Image;

public class Tile {

	private int tileX;
	private int tileY;
	private int speedX;
	private int type;
	
	public Image tileImage;
	
	private Robot robot = StartingClass.getRobot();
	
	private Background bg = StartingClass.getBg1();
	
	public Tile( int x, int y, int typeInt ) {
		
		tileX = x * 40;
		tileY = y * 40;
		
		type = typeInt;
		
		if( type == 5 ) {
			tileImage = StartingClass.tiledirt;
		}
		else if( type == 8 ) {
			tileImage = StartingClass.tilegrassTop;
		}
		else if( type == 4 ) {
			tileImage = StartingClass.tilegrassLeft;
		}
		else if( type == 6 ) {
			tileImage = StartingClass.tilegrassRight;
		}
		else if( type == 2 ) {
			tileImage = StartingClass.tilegrassBot;
		}
	}
	
	public void update() {
		
		speedX = bg.getSpeedX() * 5;
		tileX += speedX;
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Image getTileImage() {
		return tileImage;
	}

	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}
}
