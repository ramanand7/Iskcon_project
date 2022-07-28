package com.krsna.rohini_iskcon.fragments.books

class BookModel {
    var filename: String? = null
    var fileurl: String? = null
    var imageuri: String? = null

    constructor()
    constructor(fileName: String?, fileUrl: String?, imageUri: String?) {
        this.filename = fileName
        this.fileurl = fileUrl
        this.imageuri = imageUri
    }
}