package pages;

import org.openqa.selenium.By;

public class PageListeProduits  extends GenericPage {
	private By nomProduit(String nomProduitChoisi) {
		return By.xpath("//a[contains(text(),'" + nomProduitChoisi + "')]");
	}
	
	public void cliquerNomProduit(String produitChoisi){
		driver.findElement(nomProduit(produitChoisi)).click();
	}
}
