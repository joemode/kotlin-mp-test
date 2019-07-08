package api.reservation

import api.base.MerchantAgent
import api.reservation.base.ReservationAgent
import api.reservation.base.ReservationAgentListener

class MerchantReservationAgent: ReservationAgent<MerchantReservationAgent.MerchantReservationListener>(), MerchantAgent {
    override fun init(listener: MerchantReservationListener) {
        super.init(listener)
        // TODO other initialization
    }

    interface MerchantReservationListener: ReservationAgentListener {
    }
}