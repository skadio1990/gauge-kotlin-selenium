import com.thoughtworks.gauge.Step

class LoginPageTest() : BaseTest() {

    private val loginPage = LoginPage(driver)
    private val basePage = BasePage(driver)
    private val inventoryPage = InventoryPage(driver)
    private val shoppingCartPage = ShoppingCartPage(driver)
    private val checkoutPage = CheckoutPage(driver)
    private val checkoutOverviewPage = CheckoutOverviewPage(driver)
    private val checkoutCompletePage = CheckoutCompletePage(driver)

    @Step("Login with user <username> and password <password>")
    fun login(username: String, password: String) {
        loginPage.authenticate(username, password)
    }

    @Step("Add <item> to the shopping cart")
    fun shop(item: String) {
        inventoryPage.addToCart(item)
    }

    @Step("Proceed with cart to checkout")
    fun checkout() {
        basePage.goToShoppingCart()
        shoppingCartPage.proceedToCheckout()
    }

    @Step("Fill out name <firstName> <lastName> and postal code <zipCode>")
    fun details(firstName: String, lastName: String, zipCode: String) {
        checkoutPage.fillShippingInformation(firstName, lastName, zipCode)
        checkoutPage.continueToOverview()
    }

    @Step("Get checkout overview")
    fun summary() {
        checkoutOverviewPage.finishCheckout()
        val expected = "Thank you for your order!"
        if (!checkoutCompletePage.getText().contains(expected)) {
            throw AssertionError("Assert Failed: '$expected' text is not present.")
        }
    }
}
