package bersatu.kita.part11.Api

import bersatu.kita.part11.Model.Pelajaran
import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {
    @GET("mata_pelajaran.json/")
    fun getPhotos(): Single<List<Pelajaran>>

}