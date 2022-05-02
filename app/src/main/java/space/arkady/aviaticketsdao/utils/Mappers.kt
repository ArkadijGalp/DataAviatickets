package space.arkady.aviaticketsdao.utils

import space.arkady.aviaticketsdao.data.entity.FlightTicketEntity
import space.arkady.aviaticketsdao.domain.models.FlightTicket


fun FlightTicketEntity.toFlightTicket() = FlightTicket(
    namePassenger = passengerName,
    departure = departure,
    departDate = departureDate,
    destination = destination,
    numberPassportOfPassenger = passportNumberPassenger,
    returnDate = returnDate,
    passengerAge = passengerAge.toPassengerAge(),
    id = id
)

fun FlightTicket.toFlightTicketEntity() = FlightTicketEntity(
    destination = destination,
    departure = departure,
    departureDate = departDate,
    passengerAge = passengerAge.idAge,
    id = id,
    passengerName = namePassenger,
    passportNumberPassenger = numberPassportOfPassenger,
    returnDate = returnDate
)