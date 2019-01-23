package api.user

class UserManager internal constructor(private val incoming: Int) {

    companion object {
        private val TAG = "UserManager"
    }

    internal fun thing() {

    }

    fun bar(): Int {
        return 5 + incoming
    }
}