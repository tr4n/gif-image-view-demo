package com.example.demoproject3.coroutine

open class DataSourceException(message: String? = null) : Exception(message)

class DataNotAvailableException: DataSourceException("Data not found in data source")
