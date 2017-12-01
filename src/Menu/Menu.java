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
		while (true)
		{
			try
			{
				Scanner kb = new Scanner(System.in);

				int choice = 0;

				System.out.println();

				System.out.print("> ");
				choice = kb.nextInt();
				System.out.println();

				boolean isValid = verifyChoice(choice);
				
				if (isValid)
				{
					manageKeyboard(choice);
				} else 
				{
					System.out.println();
					System.out.println("[Error] Please enter a valid option.\n");

					print();
				}

				kb.close();
			} catch (InputMismatchException e)
			{
				System.out.println();
				System.out.println("[Error] Please only enter [int] values (1 ... 9).\n");

				print();

				continue;
			}
		}
	}

	private int getMaxOptionNumber()
	{
		int max = optionList.get(0).getNumber();

		for (int i = 0; i < optionList.size(); i++)
		{
			Option opt = optionList.get(i);

			if (max < opt.getNumber())
			{
				max = opt.getNumber();
			}

			max++;
		}

		return max;
	}

	private int getMinOptionNumber()
	{
		int min = 0;
		
		if (optionList.size() > 1)
		{
			min = 1;
		} else 
		{
			min = -1;
		}
		
		return min;
	}

	private boolean verifyChoice(int choice)
	{
		boolean isValid = false;
		
		int min = getMinOptionNumber();
		int max = getMaxOptionNumber();
		
		if (choice >= min && choice <= max)
		{
			isValid = true;
		} else if (choice > max || choice < min)
		{
			isValid = false;
		}
		
		return isValid;
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
