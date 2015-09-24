package AminoAcids;


public class Leucine implements AminoAcids{

	private String name;
	public Leucine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Leucine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Leu";
	}
}
