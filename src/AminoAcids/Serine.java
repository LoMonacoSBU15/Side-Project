package AminoAcids;


public class Serine implements AminoAcids{
	private String name;
	public Serine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Serine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Polar";
	}

	@Override
	public String getAbbreviation() {
		return "Ser";
	}
}
