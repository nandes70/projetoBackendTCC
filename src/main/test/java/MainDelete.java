import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainDelete {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://localhost:4200/products");
            driver.manage().window().maximize();

            // Aguarda carregamento da tabela
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

            // Localiza todas as linhas da tabela
            List<WebElement> linhas = driver.findElements(By.cssSelector("table tbody tr"));

            boolean encontrado = false;

            for (WebElement linha : linhas) {
                if (linha.getText().contains("Produto Teste")) {
                    // Clica no botão de excluir dentro da linha (último botão, por exemplo)
                    WebElement btnExcluir = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//tr[td[contains(text(),'Produto Teste')]]//button[.//mat-icon[text()='delete']]")
                    ));
                    btnExcluir.click();
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                // Aguarda o botão "Excluir" do modal de confirmação e clica
                WebElement btnConfirmarExcluir = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//mat-card[.//mat-card-title[contains(text(),'Excluir Produto')]]//button[contains(text(),'Excluir')]")
                ));
                btnConfirmarExcluir.click();

                System.out.println("Produto excluído com sucesso.");
            } else {
                System.out.println("Produto 'Produto Teste' não encontrado.");
            }

            Thread.sleep(3000); // Visualização

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
