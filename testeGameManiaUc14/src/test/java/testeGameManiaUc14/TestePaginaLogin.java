package testeGameManiaUc14;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePaginaLogin {
	
	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste ( ) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OI417415\\Webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		driver.findElement(By.id("logcad")).click();
	}
	
	@Test
	public void TesteLogin ( ) {
		
		WebElement CampoEmail = driver.findElement(By.id("arealogin"));
		WebElement CampoSenha = driver.findElement(By.id("areasenha"));
		
		//email errado
		CampoEmail.sendKeys("errado@email.com");
		CampoSenha.sendKeys("1234");
		driver.findElement(By.id("botao-enviar")).click();
		CampoEmail.clear();
		CampoSenha.clear();
		
		//senha errada
		CampoEmail.sendKeys("maria@email.com");
		CampoSenha.sendKeys("senhaerrada");
		driver.findElement(By.id("botao-enviar")).click();
		CampoEmail.clear();
		CampoSenha.clear();
		
		//email e senha corretos
		CampoEmail.sendKeys("maria@email.com");
		CampoSenha.sendKeys("1234");
		driver.findElement(By.id("botao-enviar")).click();
		
	}
	
	@After
	public void EncerrarTeste ( ) {
		
		driver.close();
		
	}
}