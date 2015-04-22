
public class AsparticAcid implements AminoAcids{
	private String name;
	public AsparticAcid()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Aspartic Acid";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Acidic";
	}

	@Override
	public String getAbbreviation() {
		return "Asp";
	}
}
