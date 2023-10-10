package testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	@Test

	public void deveInteragirComAlertSimples() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		
	}
}
