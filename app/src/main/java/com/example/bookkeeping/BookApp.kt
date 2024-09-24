package com.example.bookkeeping

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun BookApp(bookViewModel : BookViewModel = viewModel()) {
    val books = bookViewModel.booklist.collectAsState()

    Column() { }

    // Render a book and form to add a  book

    BookList(books = books.value)
    AddBookForm (
        onAdd = { title, author  ->
        bookViewModel.addBook(Book(title, author))
    })

}

@Composable
fun BookList(books: List<Book>) {
    LazyColumn {
        items(books) { book ->
            Text(book.toString())
        }
    }
}

@Composable
fun AddBookForm(onAdd: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Column() {
        TextField(value = title, onValueChange = { title = it })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = author, onValueChange = { author = it })

        Button(onClick = {
            onAdd(title, author)
            title = ""
            author = ""

        }) {
            Text("Add Book")
        }
    }

}