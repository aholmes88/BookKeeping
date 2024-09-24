package com.example.bookkeeping

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BookViewModel : ViewModel(){
    private val _booklist = MutableStateFlow<List<Book>>(emptyList())
    val booklist :StateFlow<List<Book>> = _booklist

    fun  addBook(book: Book){
        _booklist.value += book
    }
}