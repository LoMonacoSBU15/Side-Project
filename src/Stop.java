
public class Stop implements AminoAcids{
	private String name;
	public Stop()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Stop Codon";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Stop";
	}

	@Override
	public String getAbbreviation() {
		return "Stop";
	}
}
