package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RemoverItemSacolaStep {

    private WebDriver driver;


    @Dado("que acessei a funcionalidade de login")
    public void queAcesseiAFuncionalidadeDeLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.className("login")).click();

    }

    @Dado("preenchi com dados validos os campos de email e senha")
    public void preenchiComDadosValidosOsCamposDeEmailESenha() {
        driver.findElement(By.id("email")).sendKeys("mack5086@uorak.com");
        driver.findElement(By.id("passwd")).sendKeys("dbcimpact");

    }

    @Dado("cliquei no botao de sign in")
    public void cliqueiNoBotaoDeSignIn() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Quando("eu selecionar um item no ecommerce")
    public void euSelecionarUmItemNoEcommerce() {
        driver.findElement(By.id("search_query_top")).sendKeys("Blouse", Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='product-image-container']")).click();
    }

    @Quando("eu adicionar a sacola")
    public void euAdicionarASacola() {
        driver.findElement(By.id("add_to_cart")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
    }

    @Quando("clicar no botao de remover")
    public void clicarNoBotaoDeRemover() {
        driver.findElement(By.className("icon-trash")).click();
    }

    @Entao("o item sera removido com sucesso")
    public void oItemSeraRemovidoComSucesso() {
        String mensagem = driver.findElement(By.cssSelector(".alert-warning")).getText();
        Assert.assertEquals("Your shopping cart is empty.", mensagem);

    }
}
