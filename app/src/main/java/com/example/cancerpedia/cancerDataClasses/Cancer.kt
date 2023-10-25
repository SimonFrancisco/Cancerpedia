package com.example.cancerpedia.cancerDataClasses

import android.media.Image
import java.net.URL

abstract class Cancer {
    abstract val cancerName: String
    abstract val image: Image   //drawable?    png/jpeg file
    abstract val cancerInfo: HashMap<String, String>
    abstract val cancerURLs: HashMap<String, URL>        //URL type? or just string?
}


//общий принцип - у нас есть общий класс для болезней Cancer, от него будут штамповаться объекты конкретных
//болезней при запуске приложения и кидаться в список

//данные для объектов (название болезни, картинка, остальная инфа, ссылки) должны подаваться из какого то
//хранилища
//в душе не ебу, какого, есть подозрения на использование файла .json