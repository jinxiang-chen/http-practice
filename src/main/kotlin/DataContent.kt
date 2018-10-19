import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataContent(
        @Expose
        @SerializedName("status")
        override val status: Int?,
        @Expose
        @SerializedName("field1")
        val badge: Int?,
        @Expose
        @SerializedName("field2")
        val data: Data?
) : StatusResponseBody(){

    data class Data(
            @Expose
            @SerializedName("dataField1")
            val appId: String?,
            @Expose
            @SerializedName("dataField2")
            val appToken: String?
    )
}