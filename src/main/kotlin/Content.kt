import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Content(
        @Expose
        @SerializedName("origin")
        var origin: String="",

        @Expose
        @SerializedName("url")
        var url: String=""
)