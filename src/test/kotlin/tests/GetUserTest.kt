import com.thoughtworks.gauge.Step
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject

open class APITest() {
    @Step("Verify user <user> is in the list of users")
    fun main(user: String) {
        val baseUrl = "https://reqres.in/api/users"
        var (currentPage, totalPages) = 1 to 1
        var userFound = false

        while (currentPage <= totalPages && !userFound) {
            val url = URL("$baseUrl?page=$currentPage")
            (url.openConnection() as? HttpURLConnection)?.let { connection ->
                connection.requestMethod = "GET"
                val responseCode = connection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = connection.inputStream
                    val jsonResponse =
                            JSONObject(
                                    InputStreamReader(inputStream).use(InputStreamReader::readText)
                            )
                    totalPages = jsonResponse.getInt("total_pages")

                    val dataArray = jsonResponse.getJSONArray("data")
                    for (i in 0 until dataArray.length()) {
                        val userData = dataArray.getJSONObject(i)
                        val fullName =
                                "${userData.getString("first_name")} ${userData.getString("last_name")}"

                        if (fullName == user) {
                            userFound = true
                            break
                        }
                    }

                    inputStream.close()
                } else {
                    throw AssertionError("GET request failed with response code: $responseCode")
                }
            }

            currentPage++
        }

        if (!userFound) {
            throw AssertionError("Verification Failed: '$user' is not present.")
        }
    }
}