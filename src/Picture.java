/* Arnav Jaiswal
 * give images to the block class
 */

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Picture {
	private Map<String, Image> images;

	public Picture() {
		images = new HashMap<>();

		images.put("dirt", new ImageIcon("resources/Dirt.png").getImage());
		images.put("steel", new ImageIcon("resources/Steel.png").getImage());
		images.put("stone", new ImageIcon("resources/Stone.png").getImage());
		images.put("crack1", new ImageIcon("resources/Crack-1.png").getImage());
		images.put("crack2", new ImageIcon("resources/Crack-2.png").getImage());
		images.put("crack3", new ImageIcon("resources/Crack-3.png").getImage());
		images.put("crack4", new ImageIcon("resources/Crack-4.png").getImage());
		images.put("crate", new ImageIcon("resources/Crate.png").getImage());
		images.put("ghost", new ImageIcon("resources/Ghost.png").getImage());
		images.put("pipe", new ImageIcon("resources/Pipe.png").getImage());
		// air, grass, and shop are intended to be null
	}

	public Image getImage(String name) {
		return images.get(name);
	}
}