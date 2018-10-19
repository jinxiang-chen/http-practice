
import com.google.gson.*
import java.lang.reflect.Type
import com.google.gson.reflect.TypeToken




val content=
        """
{
  "origin": "123",
  "url": null,
  "status" : 1
}
        """
val dataContent =
        """{
    "status": 0,
    "field1" : 1934,
    "field2" : {
        "dataField1" : "dag34g34y3",
        "dataField2" : "dag34hw34hw3"
    }
}

        """.trimIndent()
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


//    val testGet = gson.fromJson<TestMap>(map, TestMap::class.java)
//
//    var value = testGet.origin["foo"]

    var testContent = gson.fromJson<Content>(content, Content::class.java)
    println(testContent)


    var testDataContent = gson.fromJson<DataContent>(dataContent, DataContent::class.java)
    println(testDataContent)
}

class MyYtpe :JsonDeserializer<Content>{
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Content {
        val testGet = Content()

        println(json?.isJsonObject)

        if(json?.asJsonObject?.get("url")?.isJsonNull!!){

        }else{
//            testGet.url = json?.asJsonObject?.get("url")?.asString!!
        }

        return testGet
    }
}

inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}