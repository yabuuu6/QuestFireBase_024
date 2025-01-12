package com.example.pertemuan14.ui.home.Navigation

interface DestinasiNavgiasi {
    val route : String
    val titleRes : String
}
object DestinasiHome : DestinasiNavgiasi {
    override val route : String = "home"
    override  val titleRes : String = "Home"

}
object DestinasiInsert : DestinasiNavgiasi {
    override val route : String = "insert"
    override val titleRes : String = "Insert"
}