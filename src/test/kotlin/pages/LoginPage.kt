import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage(driver: WebDriver) : BasePage(driver) {

    fun goto() {
        driver.get(appUrl)
    }

    fun authenticate(username: String, password: String) {
        goto()
        driver.findElement(By.id("user-name")).sendKeys(username)
        driver.findElement(By.id("password")).sendKeys(password)
        driver.findElement(By.id("login-button")).click()
    }
}
