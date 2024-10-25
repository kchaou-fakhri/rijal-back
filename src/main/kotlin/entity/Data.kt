package entity

data class Data(
    val book: Book,
    val bookSlug: String,
    val chapter: Chapter,
    val chapterId: String,
    val hadithArabic: String,
    val hadithNumber: String,
    val headingArabic: String,
    val id: Int,
    val status: String,
    val volume: String
)