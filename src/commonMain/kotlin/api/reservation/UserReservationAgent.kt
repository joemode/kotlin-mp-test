package api.reservation

import api.base.UserAgent
import api.reservation.base.ReservationAgent

class UserReservationAgent: ReservationAgent<UserReservationListener>(), UserAgent {

    override fun init(listener: UserReservationListener) {
        super.init(listener)
    }
}