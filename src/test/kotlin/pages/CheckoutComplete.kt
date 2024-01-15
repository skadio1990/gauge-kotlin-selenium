import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

class CheckoutCompletePage(driver: WebDriver) : BasePage(driver) {

    fun goto() {
        driver.get("$appUrl/checkout-complete.html")
    }

    private val completeHeaderLocator: By = By.className("complete-header")

    fun getText(): String {
        val completeHeaderElement = driver.findElement(completeHeaderLocator)
        return completeHeaderElement.text
    }
}
