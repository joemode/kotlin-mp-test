package api

import api.reservation.CustomerReservationManager
import api.reservation.ReservationManager
import api.reservation.RestaurantReservationManager
import api.user.UserManager

interface UserListener {
    fun userManagerCallback(userManager: UserManager)
}

interface ReservationListener {
    // Initialization Callbacks
    fun customerCallback(manager: CustomerReservationManager)
    fun restaurantCallback(manager: RestaurantReservationManager)

    // API Callbacks
}