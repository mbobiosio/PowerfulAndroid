package com.ozantopuz.powerfulAndroid.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("id")
    @Expose
    var id : Int? = null,

    @SerializedName("vote_average")
    @Expose
    var voteAverage : Number? = null,

    @SerializedName("title")
    @Expose
    var title : String? = null,

    @SerializedName("popularity")
    @Expose
    var popularity : Number? = null,

    @SerializedName("poster_path")
    @Expose
    var posterPath : String? = null,

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath : String? = null,

    @SerializedName("overview")
    @Expose
    var overview : String? = null,

    @SerializedName("release_date")
    @Expose
    var releaseDate : String? = null

)