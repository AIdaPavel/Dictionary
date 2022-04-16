package pavel.ivanov.myapplication.model.data.dto

import geekbrains.ru.model.data.dto.TranslationDto

class MeaningsDto(
    @field:SerializedName("translation") val translation: TranslationDto?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)
