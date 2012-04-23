package ecologylab.testing.serialization;

import ecologylab.serialization.annotations.simpl_generic;

public class inhGen<InhGen> extends rootGeneric<InhGen>{
	
	@simpl_generic(Double.class)
	protected InhGen type;
	
	public inhGen(InhGen gg)
	{
		super(gg);
	}

	public inhGen() {
		super();
		// TODO Auto-generated constructor stub
	}
}