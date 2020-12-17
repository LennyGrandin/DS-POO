
public class Role
{
	private String nomRole;
	
	public Role(String nom)
	{
		this.nomRole = nom;
	}

	public String getNomRole()
	{
		return nomRole;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Role)
		{
			return this.nomRole.equals(((Role)o).getNomRole());
		}
		return false;
	}
}
