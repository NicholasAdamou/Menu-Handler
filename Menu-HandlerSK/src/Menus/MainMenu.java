package Menus;

import Menu.Menu;
import Menu.MenuType;
import Menu.Option;
import State.State;
import State.StateManager;

public class MainMenu extends State
{
    private static Menu menu = new Menu(MenuType.MAIN);
    public static int key = 1;

    public MainMenu(StateManager sManager)
    {
        super(MainMenu.key, MainMenu.menu, sManager);
    }

    @Override
    public void init()
    {
        menu.add(new Option(1, "Option 1")
        {
            @Override
            public void action()
            {

            }
        });

        menu.add(new Option(4, "Exit")
        {
            @Override
            public void action()
            {
                System.exit(0);
            }
        });
    }
}
