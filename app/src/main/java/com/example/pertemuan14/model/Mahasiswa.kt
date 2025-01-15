package com.example.pertemuan14.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenisKelamin: String,
    val kelas: String,
    val angkatan: String,
    val dosenPembimbing1 : String,
    val dosenPembimbing2: String,
    val judulSkripsi : String
){
    constructor() : this("","","","","","","","","")
}
