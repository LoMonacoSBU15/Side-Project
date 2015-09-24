package AminoAcids;


public class Phenylalanine implements AminoAcids {

	private String name;
	public Phenylalanine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Phenylalanine";
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
