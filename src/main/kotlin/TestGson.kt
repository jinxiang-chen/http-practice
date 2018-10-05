
import com.google.gson.*
import java.lang.reflect.Type
import com.google.gson.reflect.TypeToken




val content=
        """
{
  "origin": "118.163.76.6",
  "url": null
}
        """

val map = """

{
  "origin": {
    "bar": "2",
    "foo": 1
  },
  "url": ""
}

"""

fun main(args: Array<String>) {
    val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
//            .registerTypeAdapter(Content::class.java, MyYtpe())
            .create()

//    val readWriteMap = hashMapOf("foo" to "1", "bar" to "2")
//    print(gson.toJson(readWriteMap))


    val testGet = gson.fromJson<TestMap>(map, TestMap::class.java)

    var value = testGet.origin["foo"]


    print( value as? Int)

    var a = "1"


//    var test2 = TestMap(readWriteMap, "")
//
//    print(gson.toJson(test2))

}

class MyYtpe :JsonDeserializer<Content>{
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Content {
        val testGet = Content()

        println(json?.isJsonObject)

        if(json?.asJsonObject?.get("url")?.isJsonNull!!){

        }else{
            testGet.url = json?.asJsonObject?.get("url")?.asString!!
        }

        return testGet
    }
}

inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}