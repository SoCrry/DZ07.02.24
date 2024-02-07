data class Comment(
    override var id: Long,//Идентификатор комментария.
    override var ownerId: Long,
    override var isDeleting: Boolean,
    val date: Long = 0,//Дата создания комментария в формате Unixtime.
    var text: String,//Текст комментария.
) : Argument(id, ownerId, isDeleting)
