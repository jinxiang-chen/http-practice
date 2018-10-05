import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TestHeader(
        @Expose
        @SerializedName("one")
        var origin: String=""
)