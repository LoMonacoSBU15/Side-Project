
public class Glycine implements AminoAcids{
	private String name;
	public Glycine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Glycine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Gly";
	}
}
