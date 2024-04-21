import java.awt.*;

public class ExitMenu extends MenuOption {
    private static final String EXIT = "Exit";

    public ExitMenu(Presentation presentation, Frame parent) {
        super(presentation, parent);
        this.name = EXIT;
        this.menuType = MenuType.FILE;
        this.action = this::exit;
        this.menuItem = mkMenuItem(name, action);
    }

    public void exit() {
        System.exit(0);
    }
}