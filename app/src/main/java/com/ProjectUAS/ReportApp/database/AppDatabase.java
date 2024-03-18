package com.ProjectUAS.ReportApp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ProjectUAS.ReportApp.dao.DatabaseDao;
import com.ProjectUAS.ReportApp.model.ModelDatabase;

@Database(entities = {ModelDatabase.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}
