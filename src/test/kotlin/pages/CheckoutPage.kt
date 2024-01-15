import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class CheckoutPage(driver: WebDriver) : BasePage(driver) {

    fun goto() {
        driver.get("$appUrl/checkout-step-one.html")
    }

    fun fillShippingInformation(firstName: String, lastName: String, postalCode: String) {
        driver.findElement(By.id("first-name")).sendKeys(firstName)
        driver.findElement(By.id("last-name")).sendKeys(lastName)
        driver.findElement(By.id("postal-code")).sendKeys(postalCode)
    }

    fun continueToOverview() {
        driver.findElement(By.id("continue")).click()
    }
}
