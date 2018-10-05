import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TestMap(
        @Expose
        @SerializedName("origin")
        var origin: Map<String, Any>,

        @Expose
        @SerializedName("url")
        var url: String=""
)