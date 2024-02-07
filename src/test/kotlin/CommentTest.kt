import org.junit.Assert.*
import org.junit.Assert
import org.junit.Test
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

class CommentTest {
    @Test
    fun restoreComment() {

        val comment = CommentService
        val userId: Long = 1
        comment.add(Comment(0L, userId, false, 11L, "Проспишь"))
        comment.delete(1)
        assertTrue(comment.restoreComment(1))
    }

    @Test
    fun restoreCommentFail() {
        val comment = CommentService
        val userId: Long = 1
        comment.add(Comment(0L, userId, false, 11L, "Проспишь"))
        assertFalse(comment.restoreComment(2))
    }
}
