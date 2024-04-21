import java.awt.*;

public class PreviousMenu extends MenuOption {
    private static final String PREV = "Prev";

    public PreviousMenu(Presentation presentation, Frame parent) {
        super(presentation, parent);
        this.name = PREV;
        this.menuType = MenuType.VIEW;
        this.action = this::previousSlide;
        this.menuItem = mkMenuItem(name, action);
    }

    public void previousSlide(){
        if (presentation.getCurrentSlideNumber() > 0) {
            presentation.setSlideNumber(presentation.getCurrentSlideNumber() - 1);
        }
    }
}
