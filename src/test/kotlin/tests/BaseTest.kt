import com.thoughtworks.gauge.AfterScenario
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

open class BaseTest() {

    var appUrl: String = System.getenv("application_endpoint")!!

    val chromeOptions = ChromeOptions().apply { addArguments("--headless") }

    val driver = ChromeDriver(chromeOptions)

    @AfterScenario
    fun teardown() {
        driver.quit()
    }
}
