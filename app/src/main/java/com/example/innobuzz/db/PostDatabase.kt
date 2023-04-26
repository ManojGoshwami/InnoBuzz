package com.example.innobuzz.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.innobuzz.models.PostListItem

@Database(entities = [PostListItem::class], version = 1)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao() : PostDao

    companion object{
        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getDatabase(context: Context): PostDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        PostDatabase::class.java,
                        "postDB")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}