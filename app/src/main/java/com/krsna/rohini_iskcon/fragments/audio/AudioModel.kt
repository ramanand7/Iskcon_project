package com.krsna.rohini_iskcon.fragments.audio

class AudioModel {
    var name = "default"
    var url = "default"

    constructor()
    constructor(name: String, url: String) {
        this.name = name
        this.url = url
    }
}