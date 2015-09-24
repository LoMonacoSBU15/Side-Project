package AminoAcids;


public class Asparagine implements AminoAcids{
	private String name;
	public Asparagine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Asparagine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Polar";
	}

	@Override
	public String getAbbreviation() {
		return "Asn";
	}
}
