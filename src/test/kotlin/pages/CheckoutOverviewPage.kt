import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class CheckoutOverviewPage(driver: WebDriver) : BasePage(driver) {

    fun goto() {
        driver.get("$appUrl/checkout-step-two.html")
    }

    fun finishCheckout() {
        driver.findElement(By.id("finish")).click()
    }
}
