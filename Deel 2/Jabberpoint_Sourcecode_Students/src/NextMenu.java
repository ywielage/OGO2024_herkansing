import java.awt.*;

public class NextMenu extends MenuOption {
    private static final String NEXT = "Next";

    public NextMenu(Presentation presentation, Frame parent) {
        super(presentation, parent);
        this.name = NEXT;
        this.menuType = MenuType.VIEW;
        this.action = this::nextSlide;
        this.menuItem = mkMenuItem(name, action);
    }

    public void nextSlide(){
        if (presentation.getCurrentSlideNumber() < (presentation.getShowListSize()-1)) {
            presentation.setSlideNumber(presentation.getCurrentSlideNumber() + 1);
        }
    }
}
