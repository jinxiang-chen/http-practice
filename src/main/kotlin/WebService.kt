import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface WebService {
    @GET("get")
    fun testGet(): Call<Content>

    @GET("status/{codes}")
    fun testStatis(@Path("codes") codes: Int): Call<ResponseBody>

//    @Headers("foxtech-appid:123, foxtech-apptoken: ABC")
    @POST("foxTech/mobile/testHeader")
    fun testHeader(@Body one : String): Call<ResponseBody>
}