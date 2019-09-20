package pages;

import org.openqa.selenium.By;

public class PagePanier extends GenericPage{
	private String titrePagePanier = debutTitrePages +" Shopping Cart";
	private By champPrixProduit(String nomProduit) {
		// le xpath est sécurisé pour le cas où il y aurait plusieurs lignes
		return By.xpath("//table[@class='cart']//a[@class='product-name'][text()=" +nomProduit +
						"/../following-sibling::td/span[@class='product-unit-price']");
	}
	
	public boolean verifierTitrePagePanier() {
		return verifierTitrePage(titrePagePanier);
	}
	
	public double recupererPrixProduit(String nomProduit) {
		try {
			return  Double.parseDouble(driver.findElement(champPrixProduit(titrePagePanier)).getText());
		}
		catch (NumberFormatException e) {
			return 0.0;
		}
	}
}
	