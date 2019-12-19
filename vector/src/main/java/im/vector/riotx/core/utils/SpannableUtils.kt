/*
 * Copyright 2018 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package im.vector.riotx.core.utils

import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.annotation.ColorInt

fun Spannable.styleMatchingText(match: String, typeFace: Int): Spannable {
    if (match.isEmpty()) return this
    indexOf(match).takeIf { it != -1 }?.let { start ->
        this.setSpan(StyleSpan(typeFace), start, start + match.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return this
}

fun Spannable.colorizeMatchingText(match: String, @ColorInt color: Int): Spannable {
    if (match.isEmpty()) return this
    indexOf(match).takeIf { it != -1 }?.let { start ->
        this.setSpan(ForegroundColorSpan(color), start, start + match.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return this
}
