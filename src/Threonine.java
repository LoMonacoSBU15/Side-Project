
public class Threonine implements AminoAcids{
	private String name;
	public Threonine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Threonine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Polar";
	}

	@Override
	public String getAbbreviation() {
		return "Thr";
	}
}
