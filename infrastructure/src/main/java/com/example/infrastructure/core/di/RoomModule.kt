package com.example.infrastructure.core.di

import android.content.Context
import androidx.room.Room
import com.example.infrastructure.data.database.YapeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val NAME_DATABASE = "yape_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, YapeDataBase::class.java, NAME_DATABASE).build()

    @Singleton
    @Provides
    fun provideRecipeDao(db: YapeDataBase) = db.getRecipeDao()


}