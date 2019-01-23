package api

import api.reservation.CustomerReservationManager
import api.reservation.ReservationManager
import api.reservation.RestaurantReservationManager
import api.user.UserManager

internal class ManagerFactory(private val manager: RegistrationManager) {

    fun generateUserManager(value: Int): UserManager {
        return UserManager(value)
    }

    fun generateReservationManager(listener: ReservationListener) {
        when (manager.type) {
            UserType.CUSTOMER -> listener.customerCallback(CustomerReservationManager())
            else -> listener.restaurantCallback(RestaurantReservationManager())
        }
    }

}