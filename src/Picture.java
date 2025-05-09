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

		images.put("dirt", new ImageIcon("resources/images/Dirt.png").getImage());
		images.put("steel", new ImageIcon("resources/images/Steel.png").getImage());
		images.put("stone", new ImageIcon("resources/images/Stone.png").getImage());
		images.put("crack1", new ImageIcon("resources/images/Crack-1.png").getImage());
		images.put("crack2", new ImageIcon("resources/images/Crack-2.png").getImage());
		images.put("crack3", new ImageIcon("resources/images/Crack-3.png").getImage());
		images.put("crack4", new ImageIcon("resources/images/Crack-4.png").getImage());
		images.put("crate", new ImageIcon("resources/images/Crate.png").getImage());
		images.put("ghost", new ImageIcon("resources/images/Ghost.png").getImage());
		images.put("pipe", new ImageIcon("resources/images/Pipe.png").getImage());
		// air, grass, and shop are intended to be null
	}

	public Image getImage(String name) {
		return images.get(name);
	}
}