import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.PrintWriter;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** <p>A text item.</p>
 * <p>A text item has drawing capabilities.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem {
	private String text;
	
	private static final String EMPTYTEXT = "No Text Given";

//A textitem of int level with text string
	public TextItem(int level, String string) {
		super(level);
		text = string;
	}

//An empty textitem
	public TextItem() {
		this(0, EMPTYTEXT);
	}

//Returns the text
	public String getText() {
		return text == null ? "" : text;
	}

//Returns the AttributedString for the Item
	public AttributedString getAttributedString(StyleInfo style, float scale) {
		AttributedString attrStr = new AttributedString(getText());
		attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
		return attrStr;
	}

//Returns the bounding box of an Item
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, 
			float scale, StyleInfo myStyle) {
		List<TextLayout> layouts = getLayouts(g, myStyle, scale);
		int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);
		Iterator<TextLayout> iterator = layouts.iterator();
		while (iterator.hasNext()) {
			TextLayout layout = iterator.next();
			Rectangle2D bounds = layout.getBounds();
			if (bounds.getWidth() > xsize) {
				xsize = (int) bounds.getWidth();
			}
			if (bounds.getHeight() > 0) {
				ysize += bounds.getHeight();
			}
			ysize += layout.getLeading() + layout.getDescent();
		}
		return new Rectangle((int) (myStyle.getIndent()*scale), 0, xsize, ysize );
	}

//Draws the item
	public void draw(int x, int y, float scale, Graphics g, 
			StyleInfo myStyle, ImageObserver o) {
		if (text == null || text.length() == 0) {
			return;
		}
		List<TextLayout> layouts = getLayouts(g, myStyle, scale);
		Point pen = new Point(x + (int)(myStyle.getIndent() * scale),
				y + (int) (myStyle.getLeading() * scale));
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(myStyle.getColor());
		Iterator<TextLayout> it = layouts.iterator();
		while (it.hasNext()) {
			TextLayout layout = it.next();
			pen.y += layout.getAscent();
			layout.draw(g2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
	  }

	private List<TextLayout> getLayouts(Graphics g, StyleInfo s, float scale) {
		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attrStr = getAttributedString(s, scale);
    	Graphics2D g2d = (Graphics2D) g;
    	FontRenderContext frc = g2d.getFontRenderContext();
    	LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
    	float wrappingWidth = (Slide.WIDTH - s.getIndent()) * scale;
    	while (measurer.getPosition() < getText().length()) {
    		TextLayout layout = measurer.nextLayout(wrappingWidth);
    		layouts.add(layout);
    	}
    	return layouts;
	}

	public String toString() {
		return "TextItem[" + getLevel()+","+getText()+"]";
	}

	@Override
	public void print(PrintWriter out){
		out.print("\"text\" level=\"" + getLevel() + "\">");
		out.print(getText());
	}
}
