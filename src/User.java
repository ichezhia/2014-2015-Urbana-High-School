import java.awt.Image;
import javax.swing.ImageIcon;

public class User {
	private String shirtColor;
	private Image upImage;
	private Image downImage;
	private Image leftImage;
	private Image rightImage;
	
	public User(String shirtColor) {
		System.out.println("the user class is reached:  " + shirtColor);
		this.shirtColor = shirtColor.toLowerCase();
		upImage = new ImageIcon("src/images/person/" + shirtColor + "Up.png").getImage();
		downImage = new ImageIcon("src/images/person/" + shirtColor + "Down.png").getImage();
		leftImage = new ImageIcon("src/images/person/" + shirtColor + "Left.png").getImage();
		rightImage = new ImageIcon("src/images/person/" + shirtColor + "Right.png").getImage();	
	}
	
	public String getShirtColor () {
		return shirtColor;
	}
	
	public void setShirtColor (String shirtColor) {
		this.shirtColor = shirtColor;
	}

	public Image getUpImage() {
		return upImage;
	}

	public void setUpImage(Image upImage) {
		this.upImage = upImage;
	}

	public Image getDownImage() {
		return downImage;
	}

	public void setDownImage(Image downImage) {
		this.downImage = downImage;
	}

	public Image getLeftImage() {
		return leftImage;
	}

	public void setLeftImage(Image leftImage) {
		this.leftImage = leftImage;
	}

	public Image getRightImage() {
		return rightImage;
	}

	public void setRightImage(Image rightImage) {
		this.rightImage = rightImage;
	}
}