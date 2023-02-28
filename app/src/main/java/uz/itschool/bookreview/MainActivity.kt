package uz.itschool.bookreview

import android.app.DownloadManager.Query
import android.app.SearchManager
import android.content.ClipData.Item
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import uz.itschool.bookreview.databinding.ActivityMainBinding
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.contains
import androidx.core.widget.addTextChangedListener
import java.util.Locale.filter
import java.util.zip.Inflater
//import kotlin.collections.EmptyList.contains
//import kotlin.collections.EmptyList as EmptyList1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
    val binding = ActivityMainBinding.inflate(layoutInflater)
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    val bookList = mutableListOf<Book>()



    for (i in 0..10){
        bookList.add(Book("Why We Sleep","Matthew Walker","https://m.media-amazon.com/images/I/71w36SmT3dL._AC_UF1000,1000_QL80_.jpg",
            "Science","Why We Sleep is a fascinating and accessible guide to what sleep is, why sleep matters " +
                    "and how to optimise your sleep habits to live longer, feel happier and set your life up for success - by sleep scientist" +
                    " and best-selling author, Matthew Walker."))


        bookList.add(Book("The Fault In Our Stars","John Green","https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1660273739i/11870085.jpg",
            "Young adult novel realistic fiction","The Fault In Our Stars is a fabulous book about a young teenage girl who has been diagnosed with lung cancer and attends a cancer support group."+
                    "Hazel is 16 and is reluctant to go to the support group, but she soon realises that it was a good idea. Hazel meets a young boy named Augustus Waters. He is charming and witty. Augustus has had osteosarcoma, a rare form of bone cancer, but has recently had the all clear." +
              "Hazel and Augustus embark on a roller coaster ride of emotions, including love, sadness and romance, while searching for the author of their favourite book. They travel to Amsterdam in search of Peter Van Houten the author of An Imperial Affliction." +
                    " While on their trip Augustus breaks some heartbreaking news to " +
                    "Hazel and both of their worlds fall apart around them."))

        bookList.add(Book("It Starts with Us","Colleen Hoover","https://s1.livelib.ru/boocover/1007094157/o/8511/Kolin_Guver__It_Starts_with_Us.jpeg",
        "romance novel","It Starts With Us is told from the alternating perspectives of two main characters, Atlas Corrigan and Lily Bloom. Lily deals with her chaotic life as a floral shop owner, single mom and co-parent with her ex-husband — who can’t seem to grasp the fact that they will never get back together.\n" +
                    "But when Lily’s first love, Atlas, turns up in her life," +
                    " she realizes that the chaos has only just begun. Returning readers " +
                    "will be thrilled to finally get to know more of Atlas’ story and past.",false))

        bookList.add(
            Book("Atomic Habits","James Clear","https://i2.wp.com/www.samuelthomasdavies.com/wp-content/uploads/2021/01/Atomic-Habits-Summary.jpeg?resize=199%2C300&ssl=1",
            "Nonfiction","In Atomic Habits, James Clear argues that big goals shouldn’t be your main focus in life. Instead, you should be utilizing frequent, repetitive actions and systems to help develop habits that stick." +
                        "The significant changes you want to make in your life depend more on creating small habits than sizable shifts. For example, suppose you want to get in shape. In that case, your best bet is eating slightly better, exercising regularly, and getting enough sleep. Instead of wasting your time setting unachievable goals" +
                        " with drastic changes, all you have to do is make one minor change daily. This theme runs throughout Atomic Habits. The quality of your life " +
                        "depends on the quality of your habits. Some habits are small like an atom. As " +
                        "these atomic habits accumulate, they can make a significant" +
                        " impact in your life.")
        )

        bookList.add(Book("The Family Outing: A Memoir","Jessi Hempel","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQBIlsDNoWdxdgle96Szf1KpLbNzgkUxGA1qKX4pXRd3QxQPzD8",
        "biography","The Family Outing is a memoir like no other—perhaps because in very few families do all five members eventually come out. Jessi Hempel, a journalist," +
                    " turns her reporting skills inward to tell the story how her family was reshaped by a series of revelations. In the span of five years, starting when Hempel was in college, she came out as lesbian, her sister as bisexual, her brother as trans, their father as gay, and their mother as a survivor of a formative trauma. It wasn’t until the COVID-19 pandemic forced both" +
                    " isolation and introspection that the members of Hempel’s family came together to truly unpack their identity as a group, finding new ways to heal" +
                    " and connect. "))


        bookList.add(Book("My What If Year", "Alisha Fernandez Miranda","https://m.media-amazon.com/images/I/41sqZ8+fmTL._SX318_BO1,204,203,200_.jpg",
        "Memoir","On the cusp of turning forty, Alisha Fernandez Miranda has climbed to the peak of personal and professional success, but at a price; she’s overworked and exhausted. Bravely, Alisha decides to give herself a break, temporarily pausing her stressful career as the CEO of high-powered consulting firm. With the tentative blessing of her husband and eight-year-old twins, she leaves her home in London to spend one year exploring the dream jobs of her youth, seeking answers to the question, “What If?”" +
                    "What follows is a spirited and hilarious journey for Alisha - and the reader. Contending with her lack of experience (and the onset of a global pandemic), Alisha gofers for two high-profile Broadway productions (and nearly tramples Stephen Sondheim), attempts to master a fitness regimen called Voga (a cross between yoga and “voguing”), feigns confidence while handling multi-million-dollar artwork at Christie’s, and literally sets her shirt on fire while serving rack of lamb in a posh hotel on Scotland’s remote Isle of Skye. Her experiences are at once challenging and humbling, and push the boundaries of what Alisha thought she was physically, mentally, and emotionally capable of. Alisha’s “What If” year reveals that she can achieve success on her own terms by embodying the spirit of the intern: never stop learning, be flexible, and understand that failure is a prerequisite for growth." +
                    "For anyone who’s ever felt stuck in a rut, My What If Year proves that it’s never too late to say yes to second chances and explore the roads untraveled throughout your life."))

  }

    var adapter = BookAdapter(this, bookList)
    binding.lv.adapter = adapter

    binding.lv.setOnItemClickListener { adapterView, view, i, l ->
        val book = bookList[i]
        val intent = Intent(this, BookActivity::class.java)
        intent.putExtra("book", book)
        startActivity(intent)

    }
        var search=findViewById<EditText>(R.id.search)

        binding.search.addTextChangedListener{

            var filter = mutableListOf<Book>()
            if (it != null) {

                for (c in bookList) {
                    if (c.name.toUpperCase().contains(it.toString().toUpperCase())) {
                        filter.add(c)
                    }
                }
                adapter= BookAdapter(this, filter)
                binding.lv.adapter = adapter
            }
        }

       var markedList= mutableListOf<Book>()
    var fav=findViewById<ImageView>(R.id.iconFav)

       var count=0
       fav.setOnClickListener {
           count++

       if (count%2==0){
        val adapter = BookAdapter(this, bookList)
        binding.lv.adapter = adapter
        binding.lv.setOnItemClickListener { adapterView, view, i, l ->

            val book = bookList[i]
            val intent = Intent(this, BookActivity::class.java)
            intent.putExtra("book", book)
            startActivity(intent)
        }
    }
    else{
       for (j in bookList){
        if (j.position==true && !markedList.contains(j)){
            markedList.add(j)
        }
    }

    val adapter = BookAdapter(this, markedList)
    binding.lv.adapter = adapter
    binding.lv.setOnItemClickListener { adapterView, view, i, l ->
        val book = markedList[i]
        val intent = Intent(this, BookActivity::class.java)
        intent.putExtra("book", book)
        startActivity(intent)


    }
  }
}
    }
}