package AminoAcids;


public class Start implements AminoAcids{
	private String name;
	public Start()
	{
	}
	
	@Override
	public String getName()
	{
		name = "Start";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Start";
	}

	@Override
	public String getAbbreviation() {
		return "Start";
		
	}

}
