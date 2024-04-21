import java.awt.*;

public class StyleInfo {
    private int indent;
    private Color color;
    private int points;
    private int leading;
    private int fontSize;

    private static final String FONTNAME = "Helvetica";

    public StyleInfo(int indent, Color color, int points, int leading){
        this.indent = indent;
        this.color = color;
        this.points = points;
        this.leading = leading;
    }
    public int getIndent() {
        return indent;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont(float scale) {
        return new Font(FONTNAME, Font.BOLD, points);
    }

    public int getLeading() {
        return leading;
    }

}
