package AminoAcids;


public class Glutamine implements AminoAcids{
	private String name;
	public Glutamine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Glutamine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Polar";
	}

	@Override
	public String getAbbreviation() {
		return "Gln";
	}
}
