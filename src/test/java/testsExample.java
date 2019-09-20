

import static org.testng.Assert.assertTrue;

import org.junit.*;

import Outils.DriverManager;
import pages.*;

public class testsExample{
	
	@Test
	public void Test1() {
		String nomProduit = "";
		String menuProduit = ""; //vérifier la casse du nom dans le menu
		
		
		DriverManager.OuvrirNavigateur("Firefox");
		//navigation vers la page du produit souhaité
		PageAccueil pAccueil = new PageAccueil();
		pAccueil.ouvrirSite();
		pAccueil.allerALaPageDuProduit(menuProduit, nomProduit);
		
		//ajout du produit au panier
		PageProduit pProduit = new PageProduit();
		pProduit.nomProduit = nomProduit;
		assertTrue(pProduit.verifierTitrePageProduit(nomProduit), "la page de mon produit est bien affichée");
		
		double prixSurPageProduit = pProduit.recupererValeurPrixProduit();
		double ancienPrixSurPageProduit = pProduit.recupererValeurAncienPrixProduit();
		int quantite = pProduit.recupererQuantite();
		pProduit.cliquerAjouterAuPanier();
		pProduit.cliquerPanier();
		
		PagePanier pPanier = new PagePanier(); 
		assertTrue(pPanier.verifierTitrePagePanier(), "La page panier est bien affichée");
		int quantitePanier = pPanier.recupereQuantiteProduit(nomProduit);
		double prixPanier = pPanier.recupererPrixProduit(nomProduit);
		assertTrue(pPanier.verifierPresenceDansPanier(nomProduit));
	}

}
