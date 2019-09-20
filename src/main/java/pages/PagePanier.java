package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class PagePanier extends GenericPage{
	private String titrePagePanier = debutTitrePages +" Shopping Cart";
	private By champNomProduit(String nomProduit) {
		return By.xpath("//table[@class='cart']//a[@class='product-name'][text()=" +nomProduit +"]");

	}
	private By champPrixProduit(String nomProduit) {
		// le xpath est sécurisé pour le cas où il y aurait plusieurs lignes
		return By.xpath("//table[@class='cart']//a[@class='product-name'][text()=" +nomProduit +
						"]/../following-sibling::td/span[@class='product-unit-price']");
	}
	private By champQuantiteProduit(String nomProduit) {
		// le xpath est sécurisé pour le cas où il y aurait plusieurs lignes
		return By.xpath("//table[@class='cart']//a[@class='product-name'][text()=" +nomProduit +
						"]/../following-sibling::td[@class='qty nobr']/input");
	}
	
	
	// fonction vérificaiton
	public boolean verifierTitrePagePanier() {
		return verifierTitrePage(titrePagePanier);
	}
	
	public boolean verifierPresenceDansPanier(String nomProduit) {
		try {
			driver.findElement(champNomProduit(nomProduit));
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	// fonction récupération valeurs
	public double recupererPrixProduit(String nomProduit) {
		try {
			return  Double.parseDouble(driver.findElement(champPrixProduit(titrePagePanier)).getText());
		}
		catch (NumberFormatException e) {
			return 0.0;
		}
	}
	
	public int recupereQuantiteProduit(String nomProduit) {
		try {
			return  Integer.parseInt(driver.findElement(champQuantiteProduit(titrePagePanier)).getAttribute("value"));
		}
		catch (NumberFormatException e) {
			return 0;
		}
	}
	
	
}
	