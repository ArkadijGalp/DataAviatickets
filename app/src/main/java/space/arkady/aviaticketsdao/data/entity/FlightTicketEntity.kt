package space.arkady.aviaticketsdao.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "flighttickets")
data class FlightTicketEntity(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "departure")
    val departure: String,
    @ColumnInfo(name = "arrival")
    val destination: String,
    @ColumnInfo(name = "departure_date")
    val departureDate: String,
    @ColumnInfo(name = "return_date")
    val returnDate: String,
    @ColumnInfo(name = "passport_number_passenger")
    val passportNumberPassenger: String,
    @ColumnInfo(name = "passenger_name")
    val passengerName: String,
    @ColumnInfo(name = "passenger_age")
    val passengerAge: Int
)
