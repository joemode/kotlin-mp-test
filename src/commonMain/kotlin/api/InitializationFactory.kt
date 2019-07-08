package api

import api.account.BackendAccountAgent
import api.account.MerchantAccountAgent
import api.account.UserAccountAgent
import api.account.base.AccountAgent
import api.base.OnInitialized
import api.reservation.BackendReservationAgent
import api.reservation.UserReservationAgent
import api.reservation.MerchantReservationAgent
import api.reservation.base.ReservationAgent
import api.search.UserSearchAgent
import api.search.UserSearchListener

internal class InitializationFactory(private val agent: InitializationAgent) {

    internal fun generateAgent(listener: OnInitialized<*, *, *>) {
        when (listener) {
            is ReservationAgent.OnReservationAgentInitialized -> generateReservationAgent(listener)
            is AccountAgent.OnAccountAgentInitialized -> generateAccountAgent(listener)
            is UserSearchAgent.OnSearchAgentInitialized -> generateAgent(listener)
            else -> listener.initializationError("Parameter was an unknown subclass of OnInitialized, please use provided OnInitialized subclasses")
        }
    }

    private fun generateAccountAgent(listener: AccountAgent.OnAccountAgentInitialized) {
        when (agent.userType) {
            ClientType.USER -> listener.userAgentInitialized(UserAccountAgent())
            ClientType.MERCHANT -> listener.merchantAgentInitialized(MerchantAccountAgent())
            ClientType.BACKEND -> listener.backendAgentInitialized(BackendAccountAgent())
        }
    }

    private fun generateReservationAgent(listener: ReservationAgent.OnReservationAgentInitialized) {
        when (agent.userType) {
            ClientType.USER -> listener.userAgentInitialized(UserReservationAgent())
            ClientType.MERCHANT -> listener.merchantAgentInitialized(MerchantReservationAgent())
            ClientType.BACKEND -> listener.backendAgentInitialized(BackendReservationAgent())
        }
    }

    private fun generateSearchAgent(listener: UserSearchAgent.OnSearchAgentInitialized) {
        when (agent.userType) {
            ClientType.USER -> listener.userAgentInitialized(UserSearchAgent())
            ClientType.MERCHANT -> listener.initializationError("No MerchantSearchAgent")
            ClientType.BACKEND -> listener.initializationError("No BackendSearchAgent()")
        }
    }
}