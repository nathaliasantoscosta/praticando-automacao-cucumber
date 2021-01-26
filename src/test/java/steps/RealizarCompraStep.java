package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RealizarCompraStep {

    private WebDriver driver;

    @Dado("que eu acessei a funcionalidade de login")
    public void queEuAcesseiAFuncionalidadeDeLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.className("login")).click();
    }

    @Dado("preenchi os campos de email e senha")
    public void preenchiOsCamposDeEmailESenha() {
        driver.findElement(By.id("email")).sendKeys("mack5086@uorak.com");
        driver.findElement(By.id("passwd")).sendKeys("dbcimpact");
    }

    @Dado("cliquei no botao de login")
    public void cliqueiNoBotaoDeLogin() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Quando("eu selecionar um item")
    public void euSelecionarUmItem() {
        driver.findElement(By.id("search_query_top")).sendKeys("Blouse", Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='product-image-container']")).click();
    }

    @Quando("adicionar a sacola")
    public void adicionarASacola() {
        driver.findElement(By.id("add_to_cart")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
    }


    @Quando("preencher os dados para entrega")
    public void preencherOsDadosParaEntrega() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
        driver.findElement(By.xpath("//div[@id='ordermsg']/textarea")).sendKeys("Entrega na portaria");

        driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
        driver.findElement(By.id("cgv")).click();

        driver.findElement(By.name("processCarrier")).click();

    }
    @Quando("informar os dados de pagamento")
    public void informarOsDadosDePagamento() {
        driver.findElement(By.xpath("//a[contains(text(), 'Pay by bank wire')]")).click();
    }

    @Quando("eu confrimar a compra")
    public void euConfrimarACompra() {
        driver.findElement(By.xpath("//span[text()='I confirm my order']")).click();
    }

    @Entao("a compra sera realizada com sucesso")
    public void aCompraSeraRealizadaComSucesso() {
        String mensagem = driver.findElement(By.xpath("//p[@class='cheque-indent']/strong")).getText();
        Assert.assertEquals("Your order on My Store is complete.", mensagem);
    }

}
