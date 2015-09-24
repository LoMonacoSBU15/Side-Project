package AminoAcids;


public class Lysine implements AminoAcids{
	private String name;
	public Lysine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Lysine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Basic";
	}

	@Override
	public String getAbbreviation() {
		return "Lys";
	}
}
