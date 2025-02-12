package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void userCanCreateAndSeeProduct(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        // Fill the product form
        WebElement nameInput = driver.findElement(By.id("productName"));
        WebElement quantityInput = driver.findElement(By.id("productQuantity"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        nameInput.sendKeys("Test Product");
        quantityInput.sendKeys("10");
        submitButton.click();

        // Navigate to product list
        driver.get(baseUrl + "/product/list");

        // Check if product exists in the table
        WebElement productRow = driver.findElement(By.xpath("//td[text()='Test Product']"));
        WebElement quantityRow = driver.findElement(By.xpath("//td[text()='10']"));

        assertNotNull(productRow, "Product name should be visible in the table");
        assertNotNull(quantityRow, "Product quantity should be visible in the table");
    }
}
