import java.awt.*;

public abstract class MenuOption {
    protected Presentation presentation;
    protected Frame parent;
    protected MenuItem menuItem;
    protected MenuType menuType;
    protected String name;
    protected Runnable action;
    public MenuOption(Presentation presentation, Frame parent){
        this.presentation = presentation;
        this.parent = parent;
    }
    protected MenuItem mkMenuItem(String name, Runnable action) {
        MenuItem menuItem = new MenuItem(name, new MenuShortcut(name.charAt(0)));
        menuItem.addActionListener(e-> action.run());
        return menuItem;
    }

    public MenuType getMenuType(){
        return this.menuType;
    }

    public MenuItem getMenuItem(){
        return this.menuItem;
    }
}
