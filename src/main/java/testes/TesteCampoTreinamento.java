package testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextFiekd() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		// escrevendo no formulario atravaes das keys
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme Diniz");
		// buscando o valor do formulario getAttribute
		Assert.assertEquals("Guilherme Diniz", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

		driver.quit();

	}

	@Test
	public void deveInteragirComTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		// para escrever nas linhas abaixo basta inserir o \n
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste de escrita area\nteste");
		Assert.assertEquals("teste de escrita area\nteste",
				driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();

	}

	@Test
	public void deveInteragirComRadioButton() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}

	@Test
	public void deveInteragirComCheckbox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		// driver.quit();
	}

	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		driver.quit();
	}

	@Test
	public void deveVerificarComBotoes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!",botao.getAttribute("value"));
		driver.quit();
		// minha implementação
		//String resultado = botao.getAttribute("value");
		//Assert.assertEquals(resultado, botao.getAttribute("value"));
		
				
	}
	@Test
	@Ignore
	public void deveInteragirComLinks() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1350, 10));
		driver.manage().window().maximize();
		driver.get("file:///C:/selenium/Curso/formulario/componentes.html");
		driver.findElement(By.linkText("Voltar")).click();
		Assert.fail();
		
	}
}
