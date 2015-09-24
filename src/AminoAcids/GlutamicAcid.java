package AminoAcids;


public class GlutamicAcid implements AminoAcids{
	private String name;
	
	public GlutamicAcid()
	{
	}
	
	@Override
	public String getName()
	{
		name = "GlutamicAcid";
		return name;
	}
	
	@Override
	public String getAttribute(){
		return "Acidic";
	}

	@Override
	public String getAbbreviation() {
		return "Glu";
	}
}
