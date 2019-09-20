package pages;

import org.openqa.selenium.By;

import Outils.DriverManager;

/*
 * Elements communs à toutes les pages
 * Ces éléments et ces fonctions sont accessibles depuis toutes les classes du PageObjectModel
 */

public class GenericPage extends DriverManager{
	
	private String titrePage = driver.getTitle();
	protected String debutTitrePages = "Demo Web Shop. ";
	//elements de menu
	private By elementMenu(int indiceChoisi) { 
		return By.xpath("//div[@class='header-menu']/ul[@class='top-menu']/li["+ indiceChoisi +"]/a"); 
	}
	private By elementMenu(String valeurChoisie) { 
		return By.xpath("//div[@class='header-menu']/ul[@class='top-menu']/li/a[contains(text(),'"+ valeurChoisie +"')]"); 
	}
	
	//elements sous- menu - attention à la manipulation, un peu compliquée
	private By elementSousMenu(int indiceMenuChoisi, int indiceSousMenuChoisi) { 
		return By.xpath("//div[@class='header-menu']/ul[@class='top-menu']/li["+ indiceMenuChoisi + 
				"]/ul[@class='sublist firstLevel']/li[" + indiceSousMenuChoisi + "]/a"); 
	}
	private By elementSousMenu(String valeurSousMenuChoisi) { 
		return By.xpath("//div[@class='header-menu']/ul[@class='top-menu']//ul[@class='sublist firstLevel']/li/a[contains(text(),'" + valeurSousMenuChoisi + "')]"); 
	}
	//boutons communs
	private By lienPanier = By.xpath("//li[@id='topcartlink']//a[@href='/cart']");
	
	
	// Fonctions de clic sur menus / sous-menus
	public void cliquerElementMenu(int indiceChoisi) {
		driver.findElement(elementMenu(indiceChoisi)).click();
	}
	
	public void cliquerElementMenu(String valeurChoisie) {
		driver.findElement(elementMenu(valeurChoisie)).click();
	}
	
	public void cliquerElementSousMenu(int indiceChoisi,int indiceSousMenuChoisi) {
		driver.findElement(elementSousMenu(indiceChoisi,indiceSousMenuChoisi)).click();
	}
	
	public void cliquerElementSousMenu(String valeurChoisie) {
		driver.findElement(elementSousMenu(valeurChoisie)).click();
	}
	
	public boolean cliquerPanier() {
		boolean bAffichagePagePanier;
		try {
			// La fonction va cliquer sur le bouton panier et vérifier que la page panier est bien affichée
			driver.findElement(lienPanier).click();
			PagePanier pPanier = new PagePanier();
			bAffichagePagePanier= pPanier.verifierTitrePagePanier();
		}
		catch (Exception e) {
			e.printStackTrace();
			bAffichagePagePanier= false;
		}
		return bAffichagePagePanier;
	}
		
	public boolean verifierTitrePage (String titrePageAttendu) {
		return ( titrePageAttendu == titrePage);
	}
}
