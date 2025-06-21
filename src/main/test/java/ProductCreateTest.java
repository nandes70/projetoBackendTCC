import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductCreateTest extends BaseTest {

    @Test
    public void testCreateProductSuccessfully() {
        WebElement btnNovoProduto = driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-crud/button"));
        btnNovoProduto.click();

        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[1]/div[1]/div[2]/div/input")).sendKeys("Produto Teste");
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[2]/div[1]/div[2]/div/input")).sendKeys("5.50");
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[3]/div[1]/div[2]/div/input")).sendKeys("8.90");
        //driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[4]/div[1]/div[2]/div/input")).sendKeys("100");
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[5]/div[1]/div[2]/div/input")).sendKeys("9876543210123");
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[6]/div[1]/div[2]/div/input")).sendKeys("Pão");
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[7]/div[1]/div[2]/div/input")).sendKeys("Kg");
        //driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/form/mat-form-field[9]/div[1]/div[2]/div/input")).sendKeys("ativo"); // Se for checkbox


        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/button[1]")).click(); // botão Salvar

        // Verificação básica
        WebElement created = driver.findElement(By.xpath("//*[contains(text(), 'Produto Teste')]"));
        assert(created.isDisplayed());
    }

    @Test
    public void testCreateProductWithEmptyFields() {
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-crud/button")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-nav/mat-sidenav-container/mat-sidenav-content/app-product-create/mat-card/button[1]")).click();

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        assert(errorMsg.isDisplayed());
    }
}