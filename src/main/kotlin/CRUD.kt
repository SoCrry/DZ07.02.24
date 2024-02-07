open class Crud<T : Argument> {
    private var id = 1L
    var parameters = mutableListOf<T>()

    fun clear() {
        id = 1
        parameters = mutableListOf<T>()
    }

    fun add(param: T): Long {
        param.id = id++
        parameters += param
        return parameters.last().id
    }

    fun update(id: Long, update: T): Boolean {
        for ((index, param) in parameters.withIndex()) {
            if (param.id == id) {
                if (param.isDeleting) {
                    throw DeleteException("Попытка редактирования удалённого элемента")
                } else {
                    update.id = id
                    parameters[index] = update
                    return true
                }
            }
        }
        return false
    }

    fun delete(id: Long): Boolean {
        for ((index, param) in parameters.withIndex()) {
            if (param.id == id) {
                if (param.isDeleting) {
                    throw DeleteException("Попытка удаления удалённого элемента")
                } else {

                    parameters[index].isDeleting = true
                    return true
                }
            }
        }
        return false
    }

    fun getById(id: Long, isDeleting: Boolean = false): T? {
        for (param in parameters) {
            if (param.id == id) {

                if (param.isDeleting && !isDeleting) {
                    throw DeleteException("Попытка получения удалённого элемента")
                } else {
                    return param
                }
            }
        }
        return null
    }

    fun get(userId: Long): MutableList<T> {
        val results = mutableListOf<T>()
        for (param in parameters) {
            if (param.ownerId == userId && !param.isDeleting) {
                results.add(param)
            }
        }

        return results
    }
}

open class Argument(open var id: Long, open var ownerId: Long, open var isDeleting: Boolean)