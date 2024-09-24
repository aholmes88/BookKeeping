package com.example.bookkeeping

class Book(private var title: String, private var author: String) {


    // Getter Functions

    fun getTitle(): String {

        return this.title
    }

    fun getAuthor(): String {

        return this.author
    }

    //Setter Functions
    fun setTitle(title: String){
        this.title = title
    }

    fun setAuthor(author: String){
        this.author = author
    }
    // Customize toString function
    override fun toString(): String{
        return "${this.title}, ${this.author}"
    }
}