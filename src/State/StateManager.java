package State;

import java.util.ArrayList;

public class StateManager
{
	private ArrayList<State> sList = new ArrayList<>();

	public StateManager()
	{
	}

	public void add(State s)
	{
		this.sList.add(s);
	}

	public State getState(int key)
	{
		State state = null;

		for (State s : sList)
		{
			if (key == s.getKey())
			{
				state = s;
				break;
			}
		}

		return state;
	}

	public void switchState(int key)
	{
		for (State s : sList)
		{
			if (key == s.getKey())
			{
				s.getMenu().print();
				break;
			}
		}
	}
}
