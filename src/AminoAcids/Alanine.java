package AminoAcids;


public class Alanine implements AminoAcids{
	private String name;
	public Alanine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Alanine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Phe";
		
	}

}
