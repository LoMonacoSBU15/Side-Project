
public class Isoleucine implements AminoAcids{
	private String name;
	public Isoleucine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Isoleucine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Ile";
	}
}
