package AminoAcids;


public class Cysteine implements AminoAcids{
	private String name;
	public Cysteine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Cysteine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Polar";
	}

	@Override
	public String getAbbreviation() {
		return "Cys";
	}
}
