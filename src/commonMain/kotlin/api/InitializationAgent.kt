package api

object InitializationAgent {

    var userType = UserType.CUSTOMER
        private set

    private var initialized = false
    private val factory = InitializationFactory(this)

    fun initialize(userType: UserType) {
        if (!initialized) {
            this.userType = userType
            this.initialized = true
        } else {
            throw RuntimeException("OneSDK has already been initialized")
        }
    }

    fun initialize() {
        initialize(UserType.CUSTOMER)
    }

    /**
     * Get a UserManager instance for access to API's related to User functionality
     *
     * @param listener A class which implements UserListener and can receive the resultant UserManager
     */
    fun getUserManager(listener: UserListener) {
        if (initialized) throw RuntimeException("InitializationAgent.initialize() must be called before Agents can be retrieved")
        val userManager = factory.generateUserAgent(5)
        listener.userManagerCallback(userManager)
    }

    /**
     * Get a ReservationManager instance for access to API's related to Reservation functionality
     * Three classes subtype ReservationManager based on UserType and provide varying functionality
     *
     * @param listener A class which implements ReservationListener and can receive the resultant ReservationManager
     */
    fun getReservationManager(listener: ReservationListener) {
        factory.generateReservationAgent(listener)
    }
}