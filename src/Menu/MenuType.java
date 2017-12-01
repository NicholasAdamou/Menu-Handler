package Menu;

public enum MenuType
{
	MAIN("Main Menu"), SUB("Sub Menu");

	private String title;

	private MenuType(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}
}
