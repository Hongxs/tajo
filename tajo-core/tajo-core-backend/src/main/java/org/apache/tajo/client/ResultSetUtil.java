/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tajo.client;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetUtil {
  public static String prettyFormat(ResultSet res) throws SQLException {
    StringBuilder sb = new StringBuilder();
    ResultSetMetaData rsmd = res.getMetaData();
    int numOfColumns = rsmd.getColumnCount();

    for (int i = 1; i <= numOfColumns; i++) {
      if (i > 1) sb.append(",  ");
      String columnName = rsmd.getColumnName(i);
      sb.append(columnName);
    }
    sb.append("\n-------------------------------\n");

    while (res.next()) {
      for (int i = 1; i <= numOfColumns; i++) {
        if (i > 1) sb.append(",  ");
        String columnValue = res.getObject(i).toString();
        sb.append(columnValue);
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}