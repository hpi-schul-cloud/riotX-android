/*
 * Copyright 2019 New Vector Ltd
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

package im.vector.riotx.features.login

import butterknife.OnClick
import com.airbnb.mvrx.withState
import im.vector.riotx.R
import javax.inject.Inject

/**
 * In this screen, the user will choose between different Schul-Cloud instances
 */
class LoginServerSelectionFragment @Inject constructor() : AbstractLoginFragment() {

    override fun getLayoutResId() = R.layout.fragment_login_server_selection

    @OnClick(R.id.loginServerChoiceTest)
    fun selectTest() = submit(ServerType.Test)

    @OnClick(R.id.loginServerChoiceSc)
    fun selectSc() = submit(ServerType.Sc)

    @OnClick(R.id.loginServerChoiceOpen)
    fun selectOpen() = submit(ServerType.Open)

    @OnClick(R.id.loginServerChoiceN21)
    fun selectN21() = submit(ServerType.N21)

    @OnClick(R.id.loginServerChoiceThr)
    fun selectThr() = submit(ServerType.Thr)

    @OnClick(R.id.loginServerChoiceBrb)
    fun selectBrb() = submit(ServerType.Brb)

    fun submit(serverType: ServerType) = withState(loginViewModel) { state ->
        loginViewModel.handle(LoginAction.UpdateServerType(serverType))
        loginViewModel.handle(LoginAction.UpdateHomeServer("https://${state.serverType.url}"))
    }

    override fun resetViewModel() {
        loginViewModel.handle(LoginAction.ResetHomeServerType)
    }

    override fun updateWithState(state: LoginViewState) {
//        updateSelectedChoice(state)

        if (state.loginMode != LoginMode.Unknown) {
            // LoginFlow for matrix.org has been retrieved
            loginSharedActionViewModel.post(LoginNavigation.OnLoginFlowRetrieved)
        }
    }
}
