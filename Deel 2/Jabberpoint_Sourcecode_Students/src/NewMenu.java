import java.awt.*;

public class NewMenu extends MenuOption {
    private static final String NEW = "New";

    public NewMenu(Presentation presentation, Frame parent){
        super(presentation, parent);
        this.name = NEW;
        this.menuType = MenuType.FILE;
        this.action = this::clearPresentation;
        this.menuItem = mkMenuItem(name, action);
    }

    public void clearPresentation() {
        presentation.clear();
        parent.repaint();
    }
}
