package entity

data class Response(
    val hadiths: Hadiths,
    val message: String,
    val status: Int
)