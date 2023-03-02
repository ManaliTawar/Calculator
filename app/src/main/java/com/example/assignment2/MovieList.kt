package com.example.assignment2;

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import movieStruct

class MovieList : AppCompatActivity() {

    private val movies = """
       [
        {
            "adult": false,
            "backdrop_path": "/gNBCvtYyGPbjPCT1k3MvJuNuXR6.jpg",
            "genre_ids": [
                35,
                18,
                10749
            ],
            "id": 19404,
            "original_language": "hi",
            "original_title": "दिलवाले दुल्हनिया ले जायेंगे",
            "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
            "popularity": 24.459,
            "poster_path": "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
            "release_date": "1995-10-20",
            "title": "Saiyaan Re, Salaam-e-Ishq",
            "video": false,
            "vote_average": 8.8,
            "vote_count": 3144
        },
        {
            "adult": false,
            "backdrop_path": "/9Xw0I5RV2ZqNLpul6lXKoviYg55.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 278,
            "original_language": "en",
            "original_title": "You Got Me Rocking & Reeling, Billu",
            "overview": "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
            "popularity": 65.65,
            "poster_path": "/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
            "release_date": "1994-09-23",
            "title": "Raat Ke Dhai Baje, Kaminey",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 19737
        },
        {
            "adult": false,
            "backdrop_path": "/rSPw7tgCH9c6NqICZef4kZjFOQ5.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 238,
            "original_language": "en",
            "original_title": "The Godfather",
            "overview": "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
            "popularity": 53.115,
            "poster_path": "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
            "release_date": "1972-03-14",
            "title": "Exotic",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 14812
        },
        {
            "adult": false,
            "backdrop_path": "/jtAI6OJIWLWiRItNSZoWjrsUtmi.jpg",
            "genre_ids": [
                10749
            ],
            "id": 724089,
            "original_language": "en",
            "original_title": "Gabriel's Inferno Part II",
            "overview": "Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?",
            "popularity": 8.546,
            "poster_path": "/x5o8cLZfEXMoZczTYWLrUo1P7UJ.jpg",
            "release_date": "2020-07-31",
            "title": "Darling, 7 Khoon Maaf",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 1307
        },
        {
            "adult": false,
            "backdrop_path": "/fQq1FWp1rC89xDrRMuyFJdFUdMd.jpg",
            "genre_ids": [
                10749,
                35
            ],
            "id": 761053,
            "original_language": "en",
            "original_title": "Gabriel's Inferno Part III",
            "overview": "The final part of the film adaption of the erotic romance novel Gabriel's Inferno written by an anonymous Canadian author under the pen name Sylvain Reynard.",
            "popularity": 19.542,
            "poster_path": "/fYtHxTxlhzD4QWfEbrC1rypysSD.jpg",
            "release_date": "2020-11-19",
            "title": "Asalaam-e-Ishqum, Gunday",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 869
        },
        {
            "adult": false,
            "backdrop_path": "/1EAxNqdkVnp48a7NUuNBHGflowM.jpg",
            "genre_ids": [
                16,
                28,
                18,
                878
            ],
            "id": 283566,
            "original_language": "ja",
            "original_title": "シン・エヴァンゲリオン劇場版:||",
            "overview": "In the aftermath of the Fourth Impact, stranded without their Evangelions, Shinji, Asuka, and Rei find refuge in one of the rare pockets of humanity that still exist on the ruined planet Earth. There, each of them live a life far different from their days as an Evangelion pilot. However, the danger to the world is far from over. A new impact is looming on the horizon—one that will prove to be the true end of Evangelion.",
            "popularity": 205.72,
            "poster_path": "/jDwZavHo99JtGsCyRzp4epeeBHx.jpg",
            "release_date": "2021-03-08",
            "title": "Say Na Say Na, Bluffmaster!",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 307
        },
        {
            "adult": false,
            "backdrop_path": "/w2uGvCpMtvRqZg6waC1hvLyZoJa.jpg",
            "genre_ids": [
                10749
            ],
            "id": 696374,
            "original_language": "en",
            "original_title": "Gabriel's Inferno",
            "overview": "An intriguing and sinful exploration of seduction, forbidden love, and redemption, Gabriel's Inferno is a captivating and wildly passionate tale of one man's escape from his own personal hell as he tries to earn the impossible--forgiveness and love.",
            "popularity": 10.572,
            "poster_path": "/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg",
            "release_date": "2020-05-29",
            "title": "Desi Girl, Dostana",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 2113
        },
        {
            "adult": false,
            "backdrop_path": "/loRmRzQXZeqG78TqZuyvSlEQfZb.jpg",
            "genre_ids": [
                18,
                36,
                10752
            ],
            "id": 424,
            "original_language": "en",
            "original_title": "Schindler's List",
            "overview": "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.",
            "popularity": 31.536,
            "poster_path": "/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg",
            "release_date": "1993-11-30",
            "title": "Aaj Ki Raat, Don",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 11824
        },
        {
            "adult": false,
            "backdrop_path": "/u1wHUA0R48FH4WV3sGqjwx3aNZm.jpg",
            "genre_ids": [
                16,
                18,
                10402,
                10749
            ],
            "id": 632632,
            "original_language": "ja",
            "original_title": "映画 ギヴン",
            "overview": "The film centers on the love relationship among the band's bassist Haruki Nakayama, drummer Akihiko Kaji, and Akihiko's roommate and ex-boyfriend Ugetsu Murata.",
            "popularity": 114.642,
            "poster_path": "/xKCtoYHUyX8zAg68eemnYa2orep.jpg",
            "release_date": "2020-08-22",
            "title": "Gallan Goodiyaan, Dil Dhadakne Do",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 247
        },
        {
            "adult": false,
            "backdrop_path": "/poec6RqOKY9iSiIUmfyfPfiLtvB.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 240,
            "original_language": "en",
            "original_title": "The Godfather: Part II",
            "overview": "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.",
            "popularity": 41.126,
            "poster_path": "/hek3koDUyRQk7FIhPXsa6mT2Zc3.jpg",
            "release_date": "1974-12-20",
            "title": "Raat Ke Dhai Baje, Kaminey",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 8891
        }
       ]
    """.trimIndent()
    private lateinit var dataList : List<movieStruct>
    private lateinit var posterTable:MutableMap<String, Int>
    private var index = 0

    @SuppressLint("ClickableViewAccessibility", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        val primaryToolbar = findViewById<Toolbar>(R.id.primary_toolbar)
        setSupportActionBar(primaryToolbar)
        supportActionBar?.title = "Movie List"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataList = Gson().fromJson(movies,Array<movieStruct>::class.java).asList()

        posterTable = mutableMapOf()
        posterTable["Saiyaan Re, Salaam-e-Ishq"] = R.drawable.poster1
        posterTable["Desi Girl, Dostana"] = R.drawable.poster7
        posterTable["You Got Me Rocking & Reeling, Billu"] = R.drawable.poster2
        posterTable["Gallan Goodiyaan, Dil Dhadakne Do"] = R.drawable.poster9
        posterTable["Exotic"] = R.drawable.poster3
        posterTable["Asalaam-e-Ishqum, Gunday "] = R.drawable.poster5
        posterTable["Say Na Say Na, Bluffmaster!"] = R.drawable.poster6
        posterTable["Aaj Ki Raat, Don"] = R.drawable.poster8
        posterTable["Raat Ke Dhai Baje, Kaminey"] = R.drawable.poster10
        posterTable["Darling, 7 Khoon Maaf"] = R.drawable.poster4

        setResource()

        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val poster = findViewById<ImageView>(R.id.movie_image)

        poster.setOnLongClickListener {
            seekbar.progress = 50
            poster.layoutParams.width = 500
            poster.layoutParams.height= 500
            true
        }

        poster.setOnClickListener {
            val toast= Toast.makeText(this, "Toast Generated", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
            Snackbar.make(it,"SnackBar Generated",Snackbar.LENGTH_SHORT).show()
        }

        seekbar?.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val layoutParams = LinearLayout.LayoutParams(1000*p1/100, 1000*p1/100)
                poster.layoutParams = layoutParams
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
               //On start
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //OnStop
            }
        })


        val allView = findViewById<ScrollView>(R.id.all_view)
        var downX = 0.0f
        allView.setOnTouchListener { view, event ->
            when(event?.action){
                MotionEvent.ACTION_DOWN->{
                      downX = event.x
                }
                MotionEvent.ACTION_UP->{
                    val deltaX = downX - event.x
                    if (kotlin.math.abs(deltaX) >20f){
                        if ( deltaX > 0 ){
                            index++
                            if (index >= dataList.size){
                                 Toast.makeText(this,"End of the List",Toast.LENGTH_SHORT).show()
                                index = dataList.size-1
                            }
                            else{
                                setResource()
                            }
                        }
                        else{
                            index--
                            if (index<0){
                                Toast.makeText(this,"Start of the List",Toast.LENGTH_SHORT).show()
                                index =0
                            }
                            else{
                                setResource()
                            }
                        }
                    }
                }
            }
            view?.onTouchEvent(event)?:true
        }
    }

    @SuppressLint("SetTextI18n", "CutPasteId")
    private fun setResource() {

        val poster = findViewById<ImageView>(R.id.movie_image)
        poster.layoutParams.width = 500
        poster.layoutParams.height= 500
        poster.setImageResource(posterTable[dataList[index].title]!!)

        val movieTitle = findViewById<TextView>(R.id.movie_title)
        movieTitle.text = dataList[index].title

        val movieId = findViewById<TextView>(R.id.movie_id)
        movieId.text = "Movie ID:"+" "+dataList[index].id

        val rating = findViewById<TextView>(R.id.rating)
        rating.text = "Rating:"+" "+dataList[index].vote_average

        val info = findViewById<TextView>(R.id.movie_info)
        info.text = dataList[index].overview

    }
}




