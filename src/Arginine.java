
public class Arginine implements AminoAcids{
	private String name;
	public Arginine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Arginine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Basic";
	}

	@Override
	public String getAbbreviation() {
		return "Arg";
	}
}
