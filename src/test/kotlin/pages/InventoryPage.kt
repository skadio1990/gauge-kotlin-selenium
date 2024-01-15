import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class InventoryPage(driver: WebDriver) : BasePage(driver) {

    fun goto() {
        driver.get("$appUrl/inventory.html")
    }

    fun addToCart(item: String) {
        val addToCartButton =
                By.xpath("//div[text()='$item']/ancestor::div[@class='inventory_item']//button")
        driver.findElement(addToCartButton).click()
    }
}
