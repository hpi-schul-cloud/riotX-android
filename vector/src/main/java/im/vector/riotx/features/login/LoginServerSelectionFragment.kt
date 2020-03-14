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

import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.airbnb.mvrx.withState
import im.vector.riotx.R
import kotlinx.android.synthetic.main.fragment_login_server_selection.*
import javax.inject.Inject

/**
 * In this screen, the user will choose between different Schul-Cloud instances
 */
class LoginServerSelectionFragment @Inject constructor() : AbstractLoginFragment() {

    override fun getLayoutResId() = R.layout.fragment_login_server_selection

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTextViews()
    }

    private fun updateSelectedChoice(state: LoginViewState) {
        state.serverType.let {
            loginServerChoiceTest.isChecked = it == ServerType.Test
            loginServerChoiceSc.isChecked = it == ServerType.Sc
            loginServerChoiceOpen.isChecked = it == ServerType.Open
            loginServerChoiceN21.isChecked = it == ServerType.N21
            loginServerChoiceThr.isChecked = it == ServerType.Thr
            loginServerChoiceBrb.isChecked = it == ServerType.Brb
        }
    }

    private fun initTextViews() {
    }

    @OnClick(R.id.loginServerChoiceTest)
    fun selectTest() {
        if (loginServerChoiceTest.isChecked) {
            // Consider this is a submit
            submit()
        } else {
            loginViewModel.handle(LoginAction.UpdateServerType(ServerType.Test))
        }
    }

    @OnClick(R.id.loginServerChoiceSc)
    fun selectSc() {
        if (loginServerChoiceSc.isChecked) {
            // Consider this is a submit
            submit()
        } else {
            loginViewModel.handle(LoginAction.UpdateServerType(ServerType.Sc))
        }
    }

    @OnClick(R.id.loginServerChoiceOpen)
    fun selectOpen() {
        if (loginServerChoiceOpen.isChecked) {
            // Consider this is a submit
            submit()
        } else {
            loginViewModel.handle(LoginAction.UpdateServerType(ServerType.Open))
        }
    }

    @OnClick(R.id.loginServerChoiceN21)
    fun selectN21() {
        if (loginServerChoiceN21.isChecked) {
            // Consider this is a submit
            submit()
        } else {
            loginViewModel.handle(LoginAction.UpdateServerType(ServerType.N21))
        }
    }

    @OnClick(R.id.loginServerChoiceThr)
    fun selectThr() {
        if (loginServerChoiceThr.isChecked) {
            // Consider this is a submit
            submit()
        } else {
            loginViewModel.handle(LoginAction.UpdateServerType(ServerType.Thr))
        }
    }

    @OnClick(R.id.loginServerChoiceBrb)
    fun selectBrb() {
        if (loginServerChoiceBrb.isChecked) {
            // Consider this is a submit
            submit()
        } else {
            loginViewModel.handle(LoginAction.UpdateServerType(ServerType.Brb))
        }
    }

    @OnClick(R.id.loginServerSubmit)
    fun submit() = withState(loginViewModel) { state ->
        loginViewModel.handle(LoginAction.UpdateHomeServer("https://${state.serverType.url}"))
    }

    override fun resetViewModel() {
        loginViewModel.handle(LoginAction.ResetHomeServerType)
    }

    override fun updateWithState(state: LoginViewState) {
        updateSelectedChoice(state)

        if (state.loginMode != LoginMode.Unknown) {
            // LoginFlow for matrix.org has been retrieved
            loginSharedActionViewModel.post(LoginNavigation.OnLoginFlowRetrieved)
        }
    }
}
