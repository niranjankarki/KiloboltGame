package kiloboltgame;

import java.util.ArrayList;

public class Robot {

	final int JUMPSPEED = -15;
	final int MOVESPEED = 5;

	private int centerX = 100;
	private int centerY = 377;

	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	private boolean readyToFire = true;

	private static Background bg1 = StartingClass.getBg1();
	private static Background bg2 = StartingClass.getBg2();

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	private int speedX = 0;
	private int speedY = 0;
	
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX( int centerX ) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY( int centerY ) {
		this.centerY = centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public void setJumped( boolean jumped ) {
		this.jumped = jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX( int speedX ) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY( int speedY ) {
		this.speedY = speedY;
	}
	
	public boolean isDucked() {
		return ducked;
	}

	public void setDucked( boolean ducked ) {
		this.ducked = ducked;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight( boolean movingRight ) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft( boolean movingLeft ) {
		this.movingLeft = movingLeft;
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void update() {

		// moves character or scrolls background accordingly
		if( speedX < 0 ) {

			centerX += speedX;
		}

		if( speedX == 0 || speedX < 0 ) {

			bg1.setSpeedX( 0 );
			bg2.setSpeedX( 0 );

			System.out.println( "Do not scroll the background" );
		}

		if( centerX <= 200 && speedX > 0 ) {

			centerX += speedX;
		}

		if ( speedX > 0 && centerX > 200 ){

			bg1.setSpeedX( -MOVESPEED / 5 );
			bg2.setSpeedX( -MOVESPEED / 5 );
		}		

		// updates Y position
		centerY += speedY;

		// handles jumping
		if( jumped == true ) {

			speedY += 1;
		}

		// prevents going beyond X coordinate of 0
		if( centerX + speedX <= 60 ) {

			centerX = 61;
		}
	}

	public void moveRight() {

		if ( ducked == false ) {
			speedX = MOVESPEED;
		}
	}

	public void moveLeft() {

		if ( ducked == false ) {
			speedX = -MOVESPEED;
		}
	}

	public void stopRight() {

		setMovingRight( false );
		stop();
	}

	public void stopLeft() {

		setMovingLeft(false);
		stop();
	}

	private void stop() {

		if ( isMovingRight() == false && isMovingLeft() == false ) {
			speedX = 0;
		}

		if ( isMovingRight() == false && isMovingLeft() == true ) {
			moveLeft();
		}

		if ( isMovingRight() == true && isMovingLeft() == false ) {
			moveRight();
		}
	}

	public void jump() {

		if ( jumped == false ) {

			speedY = JUMPSPEED;
			jumped = true;
		}
	}
	
	public void shoot() {
		
		if( readyToFire ) {
			
			Projectile p = new Projectile( centerX + 50, centerY - 25 );
			projectiles.add( p );
		}
	}

}
