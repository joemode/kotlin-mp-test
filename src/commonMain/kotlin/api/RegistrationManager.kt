package api

// TODO Thread independent singleton, so that SDK consumer cannot impersonate multiple UserTypes
class RegistrationManager(internal val type: UserType) {

    @Deprecated("Use default constructor")
    constructor (init: Int,
                 type: UserType): this(type) {
        this.init = init
    }

    private var init: Int = 0
    private val factory = ManagerFactory(this)

    /**
     * Get a UserManager instance for access to API's related to User functionality
     *
     * @param listener A class which implements UserListener and can receive the resultant UserManager
     */
    fun getUserManager(listener: UserListener) {
        val userManager = factory.generateUserManager(init)
        listener.userManagerCallback(userManager)
    }

    /**
     * Get a ReservationManager instance for access to API's related to Reservation functionality
     * Three classes subtype ReservationManager based on UserType and provide varying functionality
     *
     * @param listener A class which implements ReservationListener and can receive the resultant ReservationManager
     */
    fun getReservationManager(listener: ReservationListener) {
        factory.generateReservationManager(listener)
    }

    // TODO Functionality for other initialization, such as building the modules for networking
    // - ktor lib will be needed by all OneSDK consumers, but with various functionality
    // - firebase server can be generated for UserType.REMOTE, firebase client for UserType.RESTAURANT and UserType.CUSTOMER

}