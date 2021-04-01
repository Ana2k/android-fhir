/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.cqlreference

object Constant {

  //From cql/AndroidR4FhirModelResolver.kt
  /**
   * A prefix that is incorrectly included on Android due to the inconsistency of JSON
   * deserialization.
   */
  const val NAMESPACE_URI_PREFIX = "{http://hl7.org/fhir}"

}