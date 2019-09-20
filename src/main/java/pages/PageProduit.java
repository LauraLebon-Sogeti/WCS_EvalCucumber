package pages;

import org.openqa.selenium.By;

public class PageProduit extends GenericPage{
	public String nomProduit;
	
	public By prixProduit = By.xpath("//div[@class='prices']/div[@class='product-price']/span");
	public By ancienPrixProduit = By.xpath("//div[@class='prices']/div[@class='old-product-price']/span");
	
	//récupération nom produit pour vérif titre
	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	
	// fonctions verification
	public boolean verifierTitrePageProduit() {
		return verifierTitrePage(debutTitrePages + nomProduit);
	}
	
	//fonctions recuperation
	public double recupererValeurPrixProduit() {
		try {
			return  Double.parseDouble(driver.findElement(prixProduit).getText());
		} 
		catch (NumberFormatException e) {
			return 0.0;
		}
	}
	
	public double recupererValeurAncienPrixProduit() {
		try {
			return  Double.parseDouble(driver.findElement(ancienPrixProduit).getText());
		}
		catch (NumberFormatException e) {
			return 0.0;
		}
	}
}
