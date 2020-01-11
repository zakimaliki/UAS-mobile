package bersatu.kita.part11.Model

import com.google.firebase.database.PropertyName
import com.google.gson.annotations.SerializedName

class Pelajaran {

    @PropertyName("gambar")
    var gambar: String = ""

    @PropertyName("detail")
    var detail: String = ""

    @PropertyName("id")
    var id: Int = 0

    @PropertyName("nama")
    var Nama: String = ""
}
