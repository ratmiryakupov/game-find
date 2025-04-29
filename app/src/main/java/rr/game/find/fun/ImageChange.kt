package rr.game.find.`fun`

import rr.game.find.R

class ImageChange {
    fun takeImage (cardNum: Int): Int {
        return when (cardNum){
            1 -> R.drawable.image101
            2 -> R.drawable.image102
            3 -> R.drawable.image103
            4 -> R.drawable.image104
            5 -> R.drawable.image105
            6 -> R.drawable.image106
            7 -> R.drawable.image107
            8 -> R.drawable.image108
            else -> R.drawable.image109
        }
    }
}