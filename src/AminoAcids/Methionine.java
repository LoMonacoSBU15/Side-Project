package AminoAcids;


public class Methionine implements AminoAcids{
	private String name;
	public Methionine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Methionine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Met";
	}
}
