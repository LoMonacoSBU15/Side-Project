
public class Valine implements AminoAcids{
	private String name;
	public Valine()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Valine";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "NonPolar";
	}

	@Override
	public String getAbbreviation() {
		return "Val";
	}
}
