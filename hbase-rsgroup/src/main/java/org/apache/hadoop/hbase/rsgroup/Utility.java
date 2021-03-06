/**
 * Copyright The Apache Software Foundation
 *
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
package org.apache.hadoop.hbase.rsgroup;

import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.hbase.ServerName;
import org.apache.hadoop.hbase.classification.InterfaceAudience;
import org.apache.hadoop.hbase.master.MasterServices;

import com.google.common.net.HostAndPort;

/**
 * Utility for this RSGroup package in hbase-rsgroup.
 */
@InterfaceAudience.Private
class Utility {
  /**
   * @param master
   * @return Set of online Servers named for their hostname and port (not ServerName).
   */
  static Set<HostAndPort> getOnlineServers(final MasterServices master) {
    Set<HostAndPort> onlineServers = new HashSet<HostAndPort>();
    if (master == null) return onlineServers;
    for(ServerName server: master.getServerManager().getOnlineServers().keySet()) {
      onlineServers.add(server.getHostPort());
    }
    return onlineServers;
  }
}