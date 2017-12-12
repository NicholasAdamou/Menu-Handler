package State;

import Menu.Menu;

public abstract class State
{
	private int key;
	private Menu menu;
	protected StateManager sManager;

	public State(int key, Menu menu, StateManager sManager)
	{
		this.key = key;
		this.menu = menu;
		this.sManager = sManager;

		init();
	}

	public abstract void init();

	public int getKey()
	{
		return key;
	}

	public Menu getMenu()
	{
		return menu;
	}

	public StateManager getStateManager()
	{
		return sManager;
	}
}
