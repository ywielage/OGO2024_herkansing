import java.awt.*;

/** <p>Style stands for Indent, Color, Font and Leading.</p>
 * <p>The link between a style number and a item level is hard-linked:
 * in Slide the style is grabbed for an item
 * with a style number the same as the item level.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class StyleFactory {
	private static StyleInfo[] styles; // de styles
		public static void createStyles() {
			styles = new StyleInfo[5];
			styles[0] = new StyleInfo(0, Color.RED, 48, 20);
			styles[1] = new StyleInfo(20, Color.blue, 40, 10);
			styles[2] = new StyleInfo(50, Color.black, 36, 10);
			styles[3] = new StyleInfo(70, Color.black, 30, 10);
			styles[4] = new StyleInfo(90, Color.black, 24, 10);
		}

	public static StyleInfo getStyle(int level) {
		if (level >= styles.length) {
			level = styles.length - 1;
		}
		return styles[level];
	}
}
