import com.google.gson.GsonBuilder

val action1 =
        """
{
  "action": "a",
  "data": "{
    \"name\":\"fu\"
  }"
}
        """

val action2 =
        """
{
  "action": "b",
  "data": {
    "id":2
  }
}
        """

fun main(args: Array<String>) {
    val gson = GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .serializeNulls()
            .create()
    val content1 = gson.fromJson<Action>(action1)
    println(content1)

    val content2 = gson.fromJson<Action2>(action2)
    println(content2)

    if(content1.action == "a"){
        val data = gson.fromJson<Data1>(content1.data)
        println(data)
    }

    if(content2.action == "b"){
        val data = gson.fromJson<Action2.Data2>(content2.data.toString())
        println(data)
    }
    //send
    val a = Action2("b", 1)
    println(gson.toJson(a))
}

data class Action(
        val action: String,
        val data: String
)

data class Data1(
        val name: String
)

data class Action2(
        val action: String,
        val data: Any
){

    data class Data2(
            val id: Int
    )
}


