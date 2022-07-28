package com.krsna.rohini_iskcon.fragments.videos.youtube

class YoutubeModel {
    var videoId: String? = null
    var title: String? = null
    var url: String? = null
    var description: String? = null


    constructor() {}
    constructor(videoId: String?, title: String?, url: String?, description: String?) {
        this.videoId = videoId
        this.title = title
        this.url = url
        this.description = description
    }
}