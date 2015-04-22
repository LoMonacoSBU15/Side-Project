
public class Histidine implements AminoAcids{
	private String name;
	public Histidine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Histidine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Basic";
	}

	@Override
	public String getAbbreviation() {
		return "His";
	}
}
