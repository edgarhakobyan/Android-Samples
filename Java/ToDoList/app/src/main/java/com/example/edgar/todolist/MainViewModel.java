package com.example.edgar.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.edgar.todolist.database.AppDatabase;
import com.example.edgar.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Receive all tasks from the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
