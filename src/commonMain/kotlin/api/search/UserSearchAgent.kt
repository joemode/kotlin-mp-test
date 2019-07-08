package api.search

import api.base.*
import data.LatLng
import util.logDebug

class UserSearchAgent: BaseAgent<UserSearchAgent.UserSearchListener>(), UserAgent {
    interface OnSearchAgentInitialized: OnInitialized<UserSearchAgent, MerchantAgent, BackendAgent>

    private val tag: String = "UserSearchAgent"

    override fun init(listener: UserSearchListener) {
        super.init(listener)
        logDebug(tag, "init()")
    }

    /**
     * Entry point for SoGo Search
     *
     * @param location The latitude/longitude of the location upon which the search should be centered
     * @param radius The radius in meters of the circle which should be searched
     * @param cuisine The types of cuisines that should be considered
     */
    public fun sogoSearch(location: LatLng, radius: Int, cuisine: List<String>) {
        logDebug(tag, "sogoSearch()")
    }

    /**
     * Entry point which enables autocomplete on the manual search string
     *
     * @param partial The partial string of the search parameter entered so far
     */
    public fun directSearchProgress(partial: String) {
        logDebug(tag, "directSearchProgress()")
    }

    /**
     * Entry point for direct manual search
     *
     * @param name The name of the restaurant to search for
     */
    public fun directSearch(name: String) {
        logDebug(tag, "directSearch()")
    }

    interface UserSearchListener: BaseAgentListener {

        fun autoComplete(candidates: List<String>)

        fun result(restaurants: List<String>) // TODO change to List<Restaurant>
    }

}