import java.awt.*;
import java.util.ArrayList;
import java.util.List;



/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	private final Frame frame;
	private final Presentation presentation;
	private final List<MenuOption> menuOptions;

	public MenuController(Frame frame, Presentation presentation) {
		this.frame = frame;
		this.presentation = presentation;
		this.menuOptions = initializeMenuOptions();
		createMenus();
	}

	private List<MenuOption> initializeMenuOptions() {
		List<MenuOption> items = new ArrayList<>();
		items.add(new OpenMenu(presentation, frame));
		items.add(new NewMenu(presentation, frame));
		items.add(new SaveMenu(presentation, frame));
		items.add(new ExitMenu(presentation, frame));
		items.add(new NextMenu(presentation, frame));
		items.add(new PreviousMenu(presentation, frame));
		items.add(new GoToMenu(presentation, frame));
		items.add(new HelpMenu(presentation, frame));
		return items;
	}

	private void createMenus() {
		add(createMenu("File", MenuType.FILE));
		add(createMenu("View", MenuType.VIEW));
		setHelpMenu(createMenu("Help", MenuType.HELP));
	}

	private Menu createMenu(String name, MenuType type) {
		List<MenuItem> items = menuOptions.stream()
				.filter(item -> item.getMenuType().equals(type))
				.map(MenuOption::getMenuItem).toList();

		Menu menu = new Menu(name);
		items.forEach(menu::add);
		return menu;
	}
}
