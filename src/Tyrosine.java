
public class Tyrosine implements AminoAcids{
	private String name;
	public Tyrosine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Tyrosine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Polar";
	}

	@Override
	public String getAbbreviation() {
		return "Tyr";
	}
}
