package entity

data class Book(
    val aboutWriter: Any,
    val bookName: String,
    val bookSlug: String,
    val id: Int,
    val writerDeath: String,
    val writerName: String
)