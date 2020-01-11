package tj.belajar.orang.interfaces


interface onGetResponse {
    fun onError(message : String)
    fun onGetData(body : String)
}