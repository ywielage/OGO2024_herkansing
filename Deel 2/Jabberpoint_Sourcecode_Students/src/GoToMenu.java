import javax.swing.*;
import java.awt.*;

public class GoToMenu extends MenuOption {
    private static final String PAGENR = "Page number?";
    private static final String GOTO = "Go to";

    public GoToMenu(Presentation presentation, Frame parent) {
        super(presentation, parent);
        this.name = GOTO;
        this.menuType = MenuType.VIEW;
        this.action = this::gotoPage;
        this.menuItem = mkMenuItem(name,action);
    }

    public void gotoPage() {
        String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);
            if (pageNumber <= presentation.getSize() && pageNumber > 0) {
                presentation.setSlideNumber(pageNumber - 1);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
