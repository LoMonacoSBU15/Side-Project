package AminoAcids;


public class Proline implements AminoAcids{
	private String name;
	public Proline()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Proline";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Pro";
	}
}
