import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UHSSecondFloorMap extends UHSMap {
	
	private static final String imageFile = "src/images/secondFloor.png";
	private static final int incrementSpeed = 1;
	
	private static final int startX = -384;
	private static final int startY = 192;
	
	public UHSSecondFloorMap() {
		super(new ImageIcon(imageFile).getImage(), startX, startY);
	}

	@Override
	public BufferedImage getBufferedImage() {
		BufferedImage retVal = null;
		try {
			retVal = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return retVal;
	}
	
	@Override
	protected String getImageFile() {
		return imageFile;
	}

	@Override
	protected int getPixelIncrement() {
		return incrementSpeed;
	}	
}


