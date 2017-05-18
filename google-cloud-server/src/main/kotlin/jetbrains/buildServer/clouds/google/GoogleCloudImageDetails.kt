/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.clouds.google

import com.google.gson.annotations.SerializedName
import jetbrains.buildServer.clouds.CloudImageParameters
import jetbrains.buildServer.clouds.base.beans.CloudImageDetails
import jetbrains.buildServer.clouds.base.types.CloneBehaviour

/**
 * Google cloud image details.
 */
class GoogleCloudImageDetails(
        @SerializedName(CloudImageParameters.SOURCE_ID_FIELD)
        private val sourceId: String,
        @SerializedName(GoogleConstants.SOURCE_IMAGE)
        val sourceImage: String,
        @SerializedName(GoogleConstants.ZONE)
        val zone: String,
        @SerializedName(GoogleConstants.NETWORK_ID)
        val network: String?,
        @SerializedName(GoogleConstants.MACHINE_TYPE)
        val machineType: String,
        @SerializedName(GoogleConstants.MAX_INSTANCES_COUNT)
        private val maxInstances: Int,
        @SerializedName(CloudImageParameters.AGENT_POOL_ID_FIELD)
        val agentPoolId: Int?,
        @SerializedName(GoogleConstants.PROFILE_ID)
        val profileId: String?,
        @SerializedName(GoogleConstants.PREEMPTIBLE)
        val preemptible: Boolean = false) : CloudImageDetails {

    override fun getSourceId(): String {
        return sourceId
    }

    override fun getMaxInstances(): Int {
        return maxInstances
    }

    override fun getBehaviour(): CloneBehaviour {
        return CloneBehaviour.FRESH_CLONE
    }
}
