package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RealizarLoginStep {

    private WebDriver driver;


    @Dado("que eu acessei a funcionalidade login")
    public void queEuAcesseiAFuncionalidadeLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.className("login")).click();
    }

    @Quando("eu preencher o campo de email")
    public void euPreencherOCampoDeEmail() {
        driver.findElement(By.id("email")).sendKeys("mack5086@uorak.com");
    }

    @Quando("preencher o campo de senha")
    public void preencherOCampoDeSenha() {
        driver.findElement(By.id("passwd")).sendKeys("dbcimpact");
    }

    @Quando("clicar no botao de login")
    public void clicarNoBotaoDeLogin() {
        driver.findElement(By.id("SubmitLogin")).click();
    }
    @Entao("realizarei o login com sucesso")
    public void realizareiOLoginComSucesso() {
        String mensagem = driver.findElement(By.className("info-account")).getText();
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", mensagem);
    }
}
