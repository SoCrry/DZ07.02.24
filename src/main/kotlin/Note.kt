data class Note(
    override var id: Long,
    val title: String,
    override var ownerId: Long,
    override var isDeleting: Boolean,
    val text: String,
    val date: Int,
    val comments: String
) : Argument(id, ownerId, isDeleting)