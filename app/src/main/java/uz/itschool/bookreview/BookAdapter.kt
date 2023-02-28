package uz.itschool.bookreview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import coil.load
import uz.itschool.bookreview.databinding.BookItemBinding

class BookAdapter (context: Context, var books:MutableList<Book>):
ArrayAdapter<Book>(context, R.layout.book_item,books) {
    override fun getCount(): Int {
        return books.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var favList= mutableListOf<Book>()
        val bookItem : BookItemBinding
        if (convertView==null){
            bookItem = BookItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        }else{
            bookItem = BookItemBinding.bind(convertView)
        }
        var book = books.get(position)
        bookItem.nameBook.text = book.name
        bookItem.imageBook.load(book.img)
        if (book.position==false){
            bookItem.saved.setImageResource(R.drawable.ic_baseline_star_outline_24)

        }
        else{
            bookItem.saved.setImageResource(R.drawable.ic_baseline_star_24)
        }

        bookItem.saved.setOnClickListener {

            if (book.position==false){
                book.position=true
                bookItem.saved.setImageResource(R.drawable.ic_baseline_star_24)
                favList.add(book)
            }
            else{
                book.position=false
                bookItem.saved.setImageResource(R.drawable.ic_baseline_star_outline_24)
                favList.remove(book)
            }
        }

        return bookItem.root
    }}