package api.reservation

import api.base.MerchantAgent
import api.reservation.base.ReservationAgent

class MerchantReservationAgent: ReservationAgent<MerchantReservationListener>(), MerchantAgent {
    override fun init(listener: MerchantReservationListener) {
        super.init(listener)
        // TODO other initialization
    }
}