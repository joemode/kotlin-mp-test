package api.reservation

import api.base.UserAgent
import api.reservation.base.ReservationAgent
import api.reservation.base.ReservationAgentListener

class UserReservationAgent: ReservationAgent<UserReservationAgent.UserReservationListener>(), UserAgent {

    override fun init(listener: UserReservationListener) {
        super.init(listener)
    }

    interface UserReservationListener: ReservationAgentListener {
    }
}