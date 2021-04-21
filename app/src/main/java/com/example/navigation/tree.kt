package com.example.navigation

import android.os.Parcel
import android.os.Parcelable

data  class tree(val tName:String?, val tDetails:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        TODO("tDetails")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<tree> {
        override fun createFromParcel(parcel: Parcel): tree {
            return tree(parcel)
        }

        override fun newArray(size: Int): Array<tree?> {
            return arrayOfNulls(size)
        }
    }
}