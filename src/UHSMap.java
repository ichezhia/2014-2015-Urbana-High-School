import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class UHSMap {
	
	private Image mapImage;
	private int startX;
	private int startY;
	private BufferedImage bufferedImage;
	
	public UHSMap(Image mapImage, int startX, int startY) {
		this.mapImage = mapImage;
		this.startX = startX;
		this.startY = startY;
		try {
			bufferedImage = ImageIO.read(new File(getImageFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getMapImage() {
		return mapImage;
	}
	public void setMapImage (Image mapImage) {
		this.mapImage = mapImage;
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	
	protected abstract String getImageFile();
	
	protected abstract int getPixelIncrement();
}






