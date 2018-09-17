
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit


lateinit var client: OkHttpClient
var image = """
iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNk+M9QDwADhgGAWjR9awAAAABJRU5ErkJggg==
"""
fun main(args: Array<String>) {
    client = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .followRedirects(false)
            .build()
    println(Date())
//    try {
//        val response = run("http://httpbin.org/delay/1")
//        println(response)
//    }catch (e : SocketTimeoutException){
//        println(Date())
//        e.printStackTrace()
//    }
//    var body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),"123")
    val request = Request.Builder()
            .url("http://httpbin.org/status/1000")
            .build()
    println(request)
    println(request.headers())
    println(request.body())

    println("///////////////")

    client.newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    println(response.headers())
                    val body = response.body()!!.string()

                    println(body)

//                    val gson = GsonBuilder()
//                            .setPrettyPrinting()
//                            .setLenient()
//                            .excludeFieldsWithoutExposeAnnotation()
//                            .create()
//                    val testGet = gson.fromJson<Content>(body, Content::class.java)
//
//                    print(testGet)

                }

            })
}
