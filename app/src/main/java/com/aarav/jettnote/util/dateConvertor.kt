package com.aarav.jettnote.util

import androidx.room.TypeConverter
import java.util.Date

class DateConvertor {
    @TypeConverter
    fun fromTimeStamp(value: Long?) : Date? {
        return value?.let{ Date(it) }
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date?) : Long? {
        return date?.time
    }
}
