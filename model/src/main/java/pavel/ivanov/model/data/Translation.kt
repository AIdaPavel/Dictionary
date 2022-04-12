package pavel.ivanov.model.data

import com.google.gson.annotations.SerializedName

class Translation(
    @field:SerializedName("text") val translation: String?
)