package com.example.nytimeassignmentzeeshan.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Article(
    val abstract: String?,
    @SerializedName("adx_keywords")
    val adx_keywords: String?,
    @SerializedName("asset_id")
    val asset_id: Long,
    val byline: String?,
    val column: Any,
    val des_facet: ArrayList<String>?,
    val eta_id: Int,
    val geo_facet: ArrayList<String>?,
    val id: Long,
    val media: List<Media>,
    val nytdsection: String?,
    val org_facet: List<Any>,
    val per_facet: ArrayList<String>?,
    val published_date: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        TODO("column"),
        TODO("des_facet"),
        parcel.readInt(),
        TODO("geo_facet"),
        parcel.readLong(),
        TODO("media"),
        parcel.readString(),
        TODO("org_facet"),
        TODO("per_facet"),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(abstract)
        parcel.writeString(adx_keywords)
        parcel.writeLong(asset_id)
        parcel.writeString(byline)
        parcel.writeInt(eta_id)
        parcel.writeLong(id)
        parcel.writeString(nytdsection)
        parcel.writeString(published_date)
        parcel.writeString(section)
        parcel.writeString(source)
        parcel.writeString(subsection)
        parcel.writeString(title)
        parcel.writeString(type)
        parcel.writeString(updated)
        parcel.writeString(uri)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}