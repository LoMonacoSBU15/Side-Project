
public class Tryptophan implements AminoAcids{
	private String name;
	public Tryptophan()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Tryptophan";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Trp";
	}
}
