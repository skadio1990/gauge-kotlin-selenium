import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ShoppingCartPage(driver: WebDriver) : BasePage(driver) {

    fun goto() {
        driver.get("$appUrl/cart.html")
    }

    fun proceedToCheckout() {
        driver.findElement(By.id("checkout")).click()
    }
}
