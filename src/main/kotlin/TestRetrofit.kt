import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor


fun main(args: Array<String>) {

    testStatus(200)
//    testContent()
//    testHeaders()
}

fun testContent(){
    var client = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

    val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
//            .serializeNulls()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://httpbin.org/")
            .build()

    var webService= retrofit.create(WebService::class.java)
    var call = webService.testGet()
    call.enqueue(object : Callback<Content> {
        override fun onFailure(call: Call<Content>, t: Throwable) {
            println("onFailure")
            println(t.printStackTrace())

        }

        override fun onResponse(call: Call<Content>, response: Response<Content>) {
            println("Response")
            println(response)
            println("Header")
            println(response.headers())
            val body = response.body()
            println("Body")
            println(body?.origin)
            println(body?.url)
        }

    })
}


fun testStatus(codes: Int){
    var client = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

    val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://httpbin.org/")
            .build()

    var webService= retrofit.create(WebService::class.java)
    var call = webService.testStatis(codes)
    call.enqueue(object : Callback<ResponseBody> {

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            println("onFailure")
            println(t.printStackTrace())
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            println("Response")
            println(response)
            println("Header")
            println(response.headers())
            val body = response.body()
            println("Body")
            println(body?.string())
//            println(body?.origin)
//            println(body?.url)
        }

    })
}


fun testHeaders(){
    var client = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addInterceptor {
                val request = it.request()
                val newRequest: Request
                newRequest = request.newBuilder()
                        .addHeader("appid","123")
                        .addHeader("apptoken","ABC")
                        .build()
                it.proceed(newRequest)
            }
            .build()

    val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://192.168.3.205/")
            .build()

    var webService= retrofit.create(WebService::class.java)
    var call = webService.testHeader("YOYO")

    call.enqueue(object : Callback<ResponseBody> {

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            t.printStackTrace()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            println("Response")
            println(response)
            println("Header")
            println(response.headers())
            val body = response.body()
            println("Body")
            println(body?.string())
//            println(body?.origin)
//            println(body?.url)
        }

    })
}