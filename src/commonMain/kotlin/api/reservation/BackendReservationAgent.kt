package api.reservation

import api.base.BackendAgent
import api.base.BaseAgent
import api.base.BaseAgentListener

class BackendReservationAgent:
    BaseAgent<BackendReservationAgent.BackendReservationListener>(), BackendAgent {

    interface BackendReservationListener: BaseAgentListener {
    }
}