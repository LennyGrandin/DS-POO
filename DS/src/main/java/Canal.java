import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Canal implements Comparable<Canal>, Destinataire
{
	private Map<Role, List<Utilisateur>> mapping_role_utilisateurs;
	private int ordre;
	private List<Webhook> webhooks;
	private String nom;
	private Map<Role, List<Habilitation>> mapping_role_habilitations;
	private List<Message> historiques;
	
	public Map<Role, List<Utilisateur>> getMapping_role_utilisateurs()
	{
		return mapping_role_utilisateurs;
	}

	public void setMapping_role_utilisateurs(Map<Role, List<Utilisateur>> mapping_role_utilisateurs)
	{
		this.mapping_role_utilisateurs = mapping_role_utilisateurs;
	}

	public int getOrdre()
	{
		return ordre;
	}

	public void setOrdre(int ordre)
	{
		this.ordre = ordre;
	}

	public List<Webhook> getWebhooks()
	{
		return webhooks;
	}

	public void setWebhooks(List<Webhook> webhooks)
	{
		this.webhooks = webhooks;
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

	public List<Message> getHistoriques()
	{
		return historiques;
	}

	public void setHistoriques(List<Message> historiques)
	{
		this.historiques = historiques;
	}
	
	public Canal()
	{
		this.mapping_role_habilitations = new HashMap<Role, List<Habilitation>>();
		this.mapping_role_utilisateurs = new HashMap<Role, List<Utilisateur>>();
		this.historiques = new ArrayList<Message>();
		this.webhooks = new ArrayList<Webhook>();
	}
	
	private boolean aRoleAvecHabilitationEcriture(List<Role> rolesUtilisateur)
	{
		boolean hasWriteHabilitation = false;
		
		// On cherche si on trouve une habilitation ECRITURE ou plus parmi les rôles.
		for (Role r : rolesUtilisateur)
		{	
			if (mapping_role_habilitations.containsKey(r))
			{
				for (Habilitation h : mapping_role_habilitations.get(r))
				{
					if (h.compareTo(Habilitation.ECRITURE) >= 0)
					{
						hasWriteHabilitation = true;
						break;
					}
				}
			}
		}
		
		return hasWriteHabilitation;
	}
	
	public void ecrireMessage(Utilisateur u, Message m) throws ActionNonAutoriseeException
	{
		ArrayList<Role> rolesUtilisateur = new ArrayList<Role>();
		
		// On récupère les roles que possède l'utilisateur.
		for (Map.Entry<Role, List<Utilisateur>> entry : mapping_role_utilisateurs.entrySet())
		{
			if (entry.getValue().contains(u))
			{
				rolesUtilisateur.add(entry.getKey());
			}
	    }
		
		if (aRoleAvecHabilitationEcriture(rolesUtilisateur)) // Si l'utilisateur a le droit d'écrire, alors on envoie.
		{
			historiques.add(m);
		}
		else
		{
			throw new ActionNonAutoriseeException("l'utilisateur n'a pas le droit d'écrire dans ce canal");
		}
	}
	
	public int compareTo(Canal o)
	{
		return this.ordre - o.ordre;
	}
}
