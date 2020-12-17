
public enum Habilitation implements Comparable<Habilitation>
{
	LECTURE(0), ECRITURE(1), MODIFICATION(2), SUPPRESSION(3), DROIT_INVITATION(4);

	private int habilitation;
	
	Habilitation(int h)
	{
		this.habilitation = h;
	}
	
	public int getValue()
	{
		return this.habilitation;
	}
}
