import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenMenu extends MenuOption {
    private static final String OPEN = "Open";
    private static final String IOEX = "IO Exception: ";
    private static final String LOADERR = "Load Error";
    private static final String TESTFILE = "testPresentation.xml";

    public OpenMenu(Presentation presentation, Frame parent){
        super(presentation, parent);
        this.name = OPEN;
        this.menuType = MenuType.FILE;
        this.action = this::loadPresentation;
        this.menuItem = mkMenuItem(name, action);
    }

    public void loadPresentation() {
        try {
            presentation.clear();
            new XMLAccessor().loadFile(presentation, TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }
}
