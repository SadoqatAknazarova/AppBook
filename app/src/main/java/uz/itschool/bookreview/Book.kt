package uz.itschool.bookreview

data class Book(var name:String, var author:String,
                var img:String, var genre:String, var summaryText:String, var position:Boolean=false):java.io.Serializable {

}