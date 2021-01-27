package com.example.newsapplication.model

class News() {
    var title: String? = null
    var source: String? = null
    var date: String? = null
    var image: String? = null
    var sendURL: String? = null
    var article: String? = null

    constructor(title: String, source: String, date: String, image: String, sendUrl: String, article: String,) : this() {
        this.title = title
        this.source = source
        this.date = date
        this.image = image
        this.sendURL = sendUrl
        this.article = article
    }
}