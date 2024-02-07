fun main() {
    val note = NoteService
    val comment = CommentService
    val userId: Long = 1
    note.add(Note(0L, "Расписание дня", userId, false, "Спать", 11, ""))
    println(note)
    comment.add(Comment(0L, userId, false, 11L, "Проспишь"))
    println(comment)
}


