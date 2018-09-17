import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("get")
    fun testGet(): Call<Content>

    @GET("status/{codes}")
    fun testStatis(@Path("codes") codes: Int): Call<ResponseBody>
}