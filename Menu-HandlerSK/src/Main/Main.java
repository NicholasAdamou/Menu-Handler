package Main;

import Menus.MainMenu;
import State.StateManager;

public class Main
{
    private static StateManager sManager = new StateManager();
    public static MainMenu mainMenu = new MainMenu(sManager);

    public static void main(String[] args)
    {
        sManager.add(mainMenu);
        sManager.switchState(MainMenu.key);
    }
}
