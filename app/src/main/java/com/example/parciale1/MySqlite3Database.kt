package com.example.parciale1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySqlite3Database(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "SchedulesDB.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "schedule"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_DAY = "day"
        const val COLUMN_START_TIME = "start_time"
        const val COLUMN_END_TIME = "end_time"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_DAY TEXT, " +
                "$COLUMN_START_TIME TEXT, " +
                "$COLUMN_END_TIME TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(name: String, day: String, startTime: String, endTime: String) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_DAY, day)
            put(COLUMN_START_TIME, startTime)
            put(COLUMN_END_TIME, endTime)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readAllData(): List<Schedule> {
        val list = mutableListOf<Schedule>()
        val db = this.readableDatabase
        val cursor: Cursor = db.query(
            TABLE_NAME, null, null, null,
            null, null, "$COLUMN_DAY ASC, $COLUMN_START_TIME ASC"
        )

        if (cursor.moveToFirst()) {
            do {
                val schedule = Schedule(
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DAY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_START_TIME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_END_TIME))
                )
                list.add(schedule)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return list
    }
    fun readData(day: String): List<Schedule> {
    val list = mutableListOf<Schedule>()
    val db = this.readableDatabase
    val cursor: Cursor = db.query(
        TABLE_NAME, null, "$COLUMN_DAY = ?", arrayOf(day),
        null, null, "$COLUMN_START_TIME ASC"
    )

    if (cursor.moveToFirst()) {
        do {
            val schedule = Schedule(
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DAY)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_START_TIME)),
                cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_END_TIME))
            )
            list.add(schedule)
        } while (cursor.moveToNext())
    }
    cursor.close()
    db.close()
    return list
}
}
