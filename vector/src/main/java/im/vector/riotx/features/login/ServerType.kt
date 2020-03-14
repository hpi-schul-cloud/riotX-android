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

enum class ServerType(val title: String, val url: String) {
    Test("Test", "matrix.stomt.com"),
    Sc("HPI Schul-Cloud", "matrix.messenger.schule"),
    Open("Open Schul-Cloud", "matrix.open.messenger.schule"),
    N21("Niedersächsische Bildungscloud", "matrix.niedersachsen.messenger.schule"),
    Thr("Thüringer Schulcloud", "matrix.thueringen.messenger.schule"),
    Brb("Schul-Cloud Brandenburg", "matrix.brandenburg.messenger.schule"),
}
