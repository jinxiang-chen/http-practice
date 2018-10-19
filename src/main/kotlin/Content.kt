import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Content(

        @Expose
        @SerializedName("origin")
        val origin: String="",

        @Expose
        @SerializedName("url")
        val url: String=""
)