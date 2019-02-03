package api

import api.base.OnInitialized

/**
 * InitializationAgent is the Agent responsible for building the other allowed API Agents based on ClientType.
 *
 * InitializationAgent.initialize() must be called ONCE in the client application before any methods are accessed,
 * otherwise any Agent requests will provide User version. This is a static, thread safe object so that only one
 * ClientType can be initialized by the client application.
 *
 * Getters for the Agents will be only accessible here and will call the InitializationFactory to retrieve entry point
 * instances. Each getter method must be provided a listener which will receive the callback which contains the actual
 * entry point. The listener will listen for all types of the requested Agent, but only one will be provided based
 * on the ClientType indicated at initialization.
 *
 * The client is recommended to have separate accessors for each Agent, as they are split based on API features and
 * should have little interaction above the API level
 */
object InitializationAgent {

    var userType = ClientType.USER
        private set

    private var initialized = false
    private val factory = InitializationFactory(this)

    /**
     * Initialize the OneSDK with a specific ClientType, which will allow for the necessary API Agents to be provided
     *
     * @param clientType A specific type of client which indicates to the OneSDK which API's are necessary
     * @return Boolean Success(true) Failure(false)
     */
    fun initialize(clientType: ClientType): Boolean {
        return if (!initialized) {
            this.userType = clientType
            this.initialized = true
            true
        } else {
            false
        }
    }

    /**
     * Initialize the OneSDK with the default client type of User
     * @return Boolean Success(true) Failure(false)
     */
    fun initialize(): Boolean {
        return initialize(ClientType.USER)
    }

    fun deinitialize() {
        initialized = false
        userType = ClientType.USER
        // TODO: How to handle cleanup?
    }

    /**
     * Get an Agent
     *
     * @param listener A listener which will receive the callback containing the Agent instance. This parameter also
     * serves to determine the type of Agent the factory will generate (i.e. ReservationListener should be passed if a
     * ReservationAgent is required).
     */
    fun getAgent(listener: OnInitialized<*, *, *>) {
        if (!initialized) initialize()
        factory.generateAgent(listener)
    }

    // TODO Functionality for other initialization, such as building the modules for networking
    // - ktor lib will be needed by all OneSDK consumers, but with various functionality
    // - firebase server can be generated for ClientType.BACKEND, firebase client for ClientType.MERCHANT and ClientType.USER


    // So Create NetworkManager, maybe 2 or 3 types (at least ServerNetworkManager & ClientNetworkManager)
    // These will generate or hold the required objects, between KtorServer, KtorClient, FirebaseServer, & FirebaseClient
    // These are created upon initialization and passed from here into the agents. The agents can then pass them to
    // processing layer objects which they will initialize as needed.
}