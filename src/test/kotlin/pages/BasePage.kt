import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

open class BasePage(protected val driver: WebDriver) {

    val appUrl = System.getenv("application_endpoint")!!

    val shoppingCartIcon: By = By.id("shopping_cart_container")

    fun goToShoppingCart() {
        driver.findElement(shoppingCartIcon).click()
    }
}
