import javax.swing.*;
import java.awt.*;

public class HelpMenu extends MenuOption {
    protected static final String HELP = "Help";

    public HelpMenu(Presentation presentation, Frame parent) {
        super(presentation, parent);
        this.name = HELP;
        this.menuType = MenuType.HELP;
        this.action = this::showAboutBox;
        this.menuItem = mkMenuItem(name,action);
    }
    public void showAboutBox() {
        JOptionPane.showMessageDialog(parent,
                "JabberPoint is a primitive slide-show program in Java(tm). It\n" +
                        "is freely copyable as long as you keep this notice and\n" +
                        "the splash screen intact.\n" +
                        "Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n" +
                        "Adapted by Gert Florijn (version 1.1) and " +
                        "Sylvia Stuurman (version 1.2 and higher) for the Open" +
                        "University of the Netherlands, 2002 -- now.\n" +
                        "Author's version available from http://www.darwinsys.com/",
                "About JabberPoint",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
