import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServeurDiscussion
{
	private Map<Role, List<Utilisateur>> mapping_role_utilisateurs;
	private List<Canal> canaux;
	private String nom;
	private Map<Role, List<Habilitation>> mapping_role_habilitations;

	public Map<Role, List<Utilisateur>> getMapping_role_utilisateurs()
	{
		return mapping_role_utilisateurs;
	}

	public void setMapping_role_utilisateurs(Map<Role, List<Utilisateur>> mapping_role_utilisateurs)
	{
		this.mapping_role_utilisateurs = mapping_role_utilisateurs;
	}

	public List<Canal> getCanaux()
	{
		return canaux;
	}

	public void setCanaux(List<Canal> canaux)
	{
		this.canaux = canaux;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public Map<Role, List<Habilitation>> getMapping_role_habilitations()
	{
		return mapping_role_habilitations;
	}

	public void setMapping_role_habilitations(Map<Role, List<Habilitation>> mapping_role_habilitations)
	{
		this.mapping_role_habilitations = mapping_role_habilitations;
	}

	public ServeurDiscussion()
	{
		this.mapping_role_utilisateurs = new HashMap<Role, List<Utilisateur>>();
		this.mapping_role_habilitations = new HashMap<Role, List<Habilitation>>();
		this.canaux = new ArrayList<Canal>();
	}
	
	public static void main(String[] args)
	{
		ServeurDiscussion s = new ServeurDiscussion();
		
		Canal c1 = new Canal();
		c1.setNom("Général");
		c1.setOrdre(1);
		Canal c2 = new Canal();
		c2.setNom("Accueil");
		c2.setOrdre(0);
		
		s.getCanaux().add(c1);
		s.getCanaux().add(c2);
		
		System.out.println("s.getCanaux() = " + s.getCanaux());
		System.out.println("Bonne fin d'année !!!");
	}
}
