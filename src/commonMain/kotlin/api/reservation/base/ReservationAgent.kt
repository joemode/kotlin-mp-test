package api.reservation.base

import api.base.BaseAgent
import api.base.OnInitialized
import api.reservation.BackendReservationAgent
import api.reservation.MerchantReservationAgent
import api.reservation.UserReservationAgent

abstract class ReservationAgent<T: ReservationAgentListener>: BaseAgent<T>() {
    interface OnReservationAgentInitialized: OnInitialized<UserReservationAgent,
            MerchantReservationAgent,
            BackendReservationAgent>
}