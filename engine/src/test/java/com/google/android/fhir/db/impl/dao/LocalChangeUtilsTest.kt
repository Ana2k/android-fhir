/*
 * Copyright 2020 Google LLC
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

package com.google.android.fhir.db.impl.dao

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.android.fhir.db.impl.dao.LocalChangeUtils.mergeLocalChanges
import com.google.android.fhir.db.impl.entities.LocalChangeEntity
import com.google.android.fhir.toTimeZoneString
import java.util.Date
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/** Unit tests for [LocalChangeUtils]. */
@RunWith(RobolectricTestRunner::class)
class LocalChangeUtilsTest {
  val payload1 =
    """
     {
       "resourceType": "Patient",
       "id": "human",
       "name": [
         {
           "use": "usual",
           "given": [
             "Kenzi"
           ]
         }
       ]
     }
     """

  val json_patch =
    """
       [
         {
          "op": "replace",
          "path": "/name/0/use",
          "value":"Ana2k"          
          }
       ]
     """.trimMargin()

  // converting the json payload to json node type
  val objectMapper = ObjectMapper()
  val payload_json_node: JsonNode = objectMapper.readTree(payload1)

  val first =
    LocalChangeEntity(
      id = 1L,
      resourceType = "Test1",
      resourceId = "Anam1",
      timestamp = Date().toTimeZoneString(),
      payload = "payload1",
      type = LocalChangeEntity.Type.INSERT
    )
  val second =
    LocalChangeEntity(
      id = 2L,
      resourceType = "Test2",
      resourceId = "Anam2",
      timestamp = Date().toTimeZoneString(),
      payload = "payload2",
      type = LocalChangeEntity.Type.INSERT
    )
  val third =
    LocalChangeEntity(
      id = 3L,
      resourceType = "Test3",
      resourceId = "Anam3",
      timestamp = Date().toTimeZoneString(),
      payload = "payload3",
      type = LocalChangeEntity.Type.DELETE
    )
  val fourth =
    LocalChangeEntity(
      id = 4L,
      resourceType = "Test4",
      resourceId = "Anam4",
      timestamp = Date().toTimeZoneString(),
      payload = json_patch,
      type = LocalChangeEntity.Type.UPDATE
    )
  val fifth =
    LocalChangeEntity(
      id = 5L,
      resourceType = "Test5",
      resourceId = "Anam5",
      timestamp = Date().toTimeZoneString(),
      payload = payload_json_node.toString(),
      type = LocalChangeEntity.Type.INSERT
    )

  @Test
  fun mergeInsertAndInsert() {
    // Expected output when first and second mix,(INSERT AND INSERT)
    val res12 =
      LocalChangeEntity(
        id = 0L,
        resourceType = "Test2",
        resourceId = "Anam2",
        timestamp = "",
        type = LocalChangeEntity.Type.INSERT,
        payload = "payload2"
      )
    assertEquals(mergeLocalChanges(first, second), res12)
  }

  @Test
  fun mergeInsertAndDelete() {
    // Expected output when first and second are mixed(INSERT AND DELETE)
    val res13 =
      LocalChangeEntity(
        id = 0L,
        resourceType = "Test3",
        resourceId = "Anam3",
        timestamp = "",
        type = LocalChangeEntity.Type.DELETE,
        payload = ""
      )
    assertEquals(mergeLocalChanges(first, third), res13)
  }

  @Test
  fun mergeDeleteAndInsert() {
    // Expected output when third and first are mixed( DELETE AND INSERT)
    val res31 =
      LocalChangeEntity(
        id = 0L,
        resourceType = "Test1",
        resourceId = "Anam1",
        timestamp = "",
        type = LocalChangeEntity.Type.INSERT,
        payload = "payload1"
      )
    assertEquals(mergeLocalChanges(third, first), res31)
  }

  @Test
  fun mergeInsertAndUpdate() {
    // Expected output when fifth and fourth are mixed(INSERT AND UPDATE)
    val res54 =
      LocalChangeEntity(
        id = 0L,
        resourceType = "Test4",
        resourceId = "Anam4",
        timestamp = "",
        type = LocalChangeEntity.Type.INSERT,
        payload =
          """{"resourceType":"Patient","id":"human","name":[{"use":"Ana2k","given":["Kenzi"]}]}"""
      )
    assertEquals(mergeLocalChanges(fifth, fourth), res54)
  }
}
