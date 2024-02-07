import org.junit.Assert.*
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NoteServiceTest {
    @Before
    fun clear() {
        val note = NoteService
        note.clear()
    }

    @Test
    fun add() {

        val note = NoteService
        val userId: Long = 1

        Assert.assertEquals(
            1,
            note.add(Note(0L, "Расписание дня", userId, false, "Спать", 11, ""))
        )
    }


    @Test
    fun update() {
        val note = NoteService
        val userId: Long = 1

        note.add(Note(0L, "Расписание дня", userId, false, "Спать", 11, ""))

        assertTrue(
            note.update(
                1,
                Note(0L, "Расписание дня", userId, false, "Спать надо много", 11, "")
            )
        )

    }

    @Test
    fun updateFalse() {
        val note = NoteService
        val userId: Long = 1
        note.add(
            Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        )



        assertFalse(
            note.update(2, Note(0L, "Расписание дня", userId, false, "Спать не надо", 11, ""))
        )

    }

    @Test(expected = DeleteException::class)
    fun updateThrow() {
        val note = NoteService
        val userId: Long = 1
        note.add(
            Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        )

        note.delete(1)


        note.update(1, Note(0L, "Расписание дня", userId, false, "Спать зачем?", 11, ""))


    }

    @Test
    fun delete() {

        val note = NoteService
        val userId: Long = 1
        note.add(
            Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        )


        assertTrue(note.delete(1))

    }

    @Test
    fun deleteFalse() {

        val note = NoteService
        val userId: Long = 1
        note.add(
            Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        )
        assertFalse(note.delete(3))

    }

    @Test(expected = DeleteException::class)
    fun deleteThrow() {

        val note = NoteService
        val userId: Long = 1
        note.add(
            Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        )


        note.delete(1)
        note.delete(1)

    }


    @Test
    fun getById() {

        val note = NoteService
        val userId: Long = 1
        val resultNote: Note = Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        note.add(
            resultNote
        )



        Assert.assertEquals(resultNote, note.getById(1))
    }

    @Test
    fun getByIdNull() {

        val note = NoteService
        val userId: Long = 1
        val resulNote: Note = Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        note.add(
            resulNote
        )



        Assert.assertEquals(null, note.getById(2))
    }

    @Test(expected = DeleteException::class)
    fun getByIdThrow() {

        val note = NoteService
        val userId: Long = 1
        val resulNote: Note = Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        note.add(
            resulNote
        )


        note.delete(1)
        note.getById(1)
    }

    @Test
    fun get() {

        val note = NoteService
        val userId: Long = 1
        val resulNote: Note = Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        note.add(
            resulNote
        )

        Assert.assertEquals(note.parameters, note.get(1))
    }

    @Test
    fun getNotFound() {

        val note = NoteService
        val userId: Long = 1
        val resulNote: Note = Note(0L, "Расписание дня", userId, false, "Спать", 11, "")
        note.add(
            resulNote
        )

        Assert.assertEquals(mutableListOf<Note>(), note.get(2))
    }
}