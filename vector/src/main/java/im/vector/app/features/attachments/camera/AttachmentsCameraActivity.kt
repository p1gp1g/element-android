/*
 * Copyright (c) 2022 New Vector Ltd
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

package im.vector.app.features.attachments.camera

import android.content.Intent
import android.provider.MediaStore
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import im.vector.app.core.extensions.addFragment
import im.vector.app.core.platform.VectorBaseActivity
import im.vector.app.databinding.ActivitySimpleBinding
import im.vector.app.features.themes.ActivityOtherThemes

@AndroidEntryPoint
class AttachmentsCameraActivity : VectorBaseActivity<ActivitySimpleBinding>() {

    override fun getOtherThemes() = ActivityOtherThemes.AttachmentsPreview

    override fun getBinding() = ActivitySimpleBinding.inflate(layoutInflater)

    override fun getCoordinatorLayout() = views.coordinatorLayout

    override fun initUiAndData() {
        if (isFirstCreation()) {
            addFragment(views.simpleFragmentContainer, AttachmentsCameraFragment::class.java)
        }
    }

    fun setResultAndFinish(data: AttachmentsCameraOutput) {
        val resultIntent = Intent().apply {
            putExtra(MediaStore.EXTRA_OUTPUT, data)
        }
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    fun setErrorAndFinish() {
        val resultIntent = Intent()
        setResult(RESULT_CANCELED, resultIntent)
        finish()
    }

    fun showWaitingView() {
        views.simpleActivityWaitingView.isVisible = true
    }
}
