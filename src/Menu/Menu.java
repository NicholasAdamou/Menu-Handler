package Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Printable
{
	private MenuType type;
	private ArrayList<Option> optionList = new ArrayList<>();

	public Menu(MenuType mType)
	{
		this.type = mType;
	}

	public void add(Option opt)
	{
		optionList.add(opt);
	}

	@Override
	public void print()
	{
		System.out.println("---[" + type.getTitle() + "]---");
		for (Option opt : optionList)
		{
			opt.print();
		}

		getKeyboard();
	}

	private void getKeyboard()
	{
		try
		{
			Scanner kb = new Scanner(System.in);

			int choice = 0;

			System.out.println();

			System.out.print("> ");
			choice = kb.nextInt();
			System.out.println();

			manageKeyboard(choice);

			kb.close();
		} catch (InputMismatchException e)
		{
			System.out.println();
			System.out.println("[Error] Please only enter [int] values (1 ... 9).");
		}
	}

	private void manageKeyboard(int choice)
	{
		for (Option opt : optionList)
		{
			if (choice == opt.getNumber())
			{
				opt.action();
				break;
			}
		}
	}
}
