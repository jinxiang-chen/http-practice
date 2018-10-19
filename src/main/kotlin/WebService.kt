import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface WebService {
    @GET("get")
    fun testGet(): Call<Content>

    @GET("status/{codes}")
    fun testStatis(@Path("codes") codes: Int): Call<ResponseBody>

//    @Headers("appid:123, apptoken: ABC")
    @POST("testHeader")
    fun testHeader(@Body one : String): Call<ResponseBody>
}