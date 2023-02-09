/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.intentresolver

import com.android.intentresolver.flags.FeatureFlagRepository
import com.android.systemui.flags.BooleanFlag
import com.android.systemui.flags.ReleasedFlag
import com.android.systemui.flags.UnreleasedFlag

internal class TestFeatureFlagRepository(
    private val overrides: Map<BooleanFlag, Boolean>
) : FeatureFlagRepository {
    override fun isEnabled(flag: UnreleasedFlag): Boolean = getValue(flag)
    override fun isEnabled(flag: ReleasedFlag): Boolean = getValue(flag)

    private fun getValue(flag: BooleanFlag) = overrides.getOrDefault(flag, flag.default)
}
