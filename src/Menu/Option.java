package Menu;

public class Option implements Printable
{
	private int number;
	private String title;

	public Option(int number, String title)
	{
		this.number = number;
		this.title = title;
	}

	public void action()
	{
	}

	@Override
	public void print()
	{
		System.out.println("[" + number + "] " + title);
	}

	public int getNumber()
	{
		return number;
	}
}
