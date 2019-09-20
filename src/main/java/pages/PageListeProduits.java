package pages;

import org.openqa.selenium.By;

public class PageListeProduits {
	public By nomProduit(String nomProduitChoisi) {
		return By.xpath("//a[contains(text(),'" + nomProduitChoisi + "')]");
	}
}
