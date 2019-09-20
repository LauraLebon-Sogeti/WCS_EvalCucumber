package pages;

import org.openqa.selenium.By;

public class PageAccueil extends GenericPage{
	//Sous catégorie
	private By sousCategorie(String valeurChoisie){ 
		return By.xpath("//div[@class = 'sub-category-item']//a[contains(text(),'" + valeurChoisie + "')]");
	}
	
	public void cliquerSousCategorie(String valeurSousCategorie) {
		driver.findElement(sousCategorie(valeurSousCategorie)).click();
	}
}
