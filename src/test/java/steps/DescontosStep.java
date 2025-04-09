package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DescontosStep {

    WebDriver navegador;

    @Dado("que estou no site da Qazando")
    public void que_estou_no_site_da_Qazando() {
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://qazando.com.br/curso.html");
        WebElement botao = navegador.findElement(By.id("btn-ver-cursos"));
        Assert.assertTrue("Não acessou a aplicação", botao.isDisplayed());
    }

    @Quando("eu preencho meu e-mail")
    public void eu_preencho_meu_e_mail() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) navegador;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(2000);

        navegador.findElement(By.id("email")).sendKeys("teste@qazando.com.br");
    }

    @Quando("clico em ganhar cupom")
    public void clico_em_ganhar_cupom() {
        navegador.findElement(By.id("button")).click();
    }

    @Entao("eu vejo o código de desconto")
    public void eu_vejo_o_codigo_de_desconto() {
        WebElement elementoCupom = navegador.findElement(By.cssSelector("#cupom > h2 > span"));
        Assert.assertTrue("O cupom não está visível na tela", elementoCupom.isDisplayed());
        String cupom = elementoCupom.getText();
        System.out.println("Código de desconto: " + cupom);
        navegador.quit();
    }
}
