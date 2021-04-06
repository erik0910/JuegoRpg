package Clases;

public class Tiles {

	private String code;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

	public Tiles() {
		super();
	}

	public Tiles(String code, boolean up, boolean down, boolean left, boolean right) {
		super();
		this.code = code;
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}
