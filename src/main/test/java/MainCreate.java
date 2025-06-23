import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainCreate {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:4200/products");
            driver.manage().window().maximize();

            // Clica no botão "Novo Produto"
            WebElement btnNovoProduto = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Novo Produto')]")));
            btnNovoProduto.click();

            // Preenche os campos do formulário
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("proNome"))).sendKeys("Produto Teste");
            driver.findElement(By.name("proDescricao")).sendKeys("Descrição do Produto");
            driver.findElement(By.name("proCategoria")).sendKeys("Categoria Exemplo");
            driver.findElement(By.name("proEstoque")).sendKeys("100");
            driver.findElement(By.name("proCodigoBarra")).sendKeys("1234567890123");
            driver.findElement(By.name("proAplicacao")).sendKeys("Aplicação Teste");
            driver.findElement(By.name("proMarca")).sendKeys("Marca Fictícia");

            // Seleciona a opção "Sim" do mat-select "Produto Ativo?"
            WebElement ativoSelect = driver.findElement(By.cssSelector("mat-form-field mat-select[name='proStatus']")); // ajuste para Angular
            ativoSelect.click();

            WebElement opcaoSim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-option//span[contains(text(),'Ativo')]")));
            opcaoSim.click();

            // Preenche preços
            driver.findElement(By.name("proPrecoCusto")).sendKeys("10.50");
            driver.findElement(By.name("proPrecoVenda")).sendKeys("20.00");

            // Preenche fabricante
            driver.findElement(By.name("proFabricante")).sendKeys("Fabricante Genérico");

            // Data (se for preenchida automaticamente, pode pular)

            // Clica no botão "Salvar"
            WebElement btnSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Salvar')]")));
            btnSalvar.click();

            Thread.sleep(3000); // tempo para observar resultado

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
