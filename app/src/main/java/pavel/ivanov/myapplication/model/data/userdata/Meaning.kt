package pavel.ivanov.myapplication.model.data.userdata

import geekbrains.ru.model.data.userdata.TranslatedMeaning

data class Meaning(
    val translatedMeaning: TranslatedMeaning = TranslatedMeaning(),
    val imageUrl: String = ""
)
