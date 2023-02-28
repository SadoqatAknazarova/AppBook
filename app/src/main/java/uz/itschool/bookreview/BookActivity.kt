package uz.itschool.bookreview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load

class BookActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
       getSupportActionBar()!!.setTitle("SummaryPage")
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        var  book = intent.getSerializableExtra("book") as Book
        var img = findViewById<ImageView>(R.id.image)
        img.load(book.img)
        var name=findViewById<TextView>(R.id.bookname)
        name.text=book.name
        var summary=findViewById<TextView>(R.id.textofsummary)
        summary.text=book.summaryText
        var genre=findViewById<TextView>(R.id.name_genre)
        genre.text=book.genre
        var author=findViewById<TextView>(R.id.name_author)
        author.text=book.author

    }
}