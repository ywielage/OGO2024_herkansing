import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SaveMenu extends MenuOption {
    private static final String SAVEFILE = "savedPresentation.xml";

    private static final String IOEX = "IO Exception: ";
    private static final String SAVEERR = "Save Error";
    private static final String SAVE = "Save";

    public SaveMenu(Presentation presentation, Frame parent) {
        super(presentation, parent);
        this.name = SAVE;
        this.menuType = MenuType.FILE;
        this.action = this::savePresentation;
        this.menuItem = mkMenuItem(name, action);
    }

    public void savePresentation() {
        try {
            new XMLAccessor().saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
