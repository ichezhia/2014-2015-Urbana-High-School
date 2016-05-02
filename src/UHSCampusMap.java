import javax.swing.ImageIcon;

public class UHSCampusMap extends UHSMap {
	
	private static final String imageFile = "src/images/campus.png";
	private static final int incrementSpeed = 5;
	
	private static final int startX = 0;
	private static final int startY = 0;
	
	public UHSCampusMap() {
		super(new ImageIcon(imageFile).getImage(), startX, startY);
	}

	@Override
	public String getImageFile() {
		return imageFile;
	}

	@Override
	protected int getPixelIncrement() {
		return incrementSpeed;
	}
}


