package com.example.infrastructure

class NativeLib {

    /**
     * A native method that is implemented by the 'infrastructure' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'infrastructure' library on application startup.
        init {
            System.loadLibrary("infrastructure")
        }
    }
}