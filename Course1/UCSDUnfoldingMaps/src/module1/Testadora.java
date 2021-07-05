package module1;
import processing.core.*;

public class Testadora extends PApplet {
	private String URL = "http://...jpg";
	private PImage backgroundImg;
	
	public void setup() {
		size(200,200);
		backgroundImg = loadImage(URL, "jpg");
	}


	public void draw() {
		// Body not shown
	}
}
