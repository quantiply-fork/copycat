/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.cluster;

import java.util.Arrays;
import java.util.Collection;

/**
 * Basic HTTP cluster configuration.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class HttpClusterConfig extends ClusterConfig<HttpMember> {

  public HttpClusterConfig() {
  }

  public HttpClusterConfig(ClusterConfig<HttpMember> cluster) {
    super(cluster);
  }

  public HttpClusterConfig(HttpMember localMember, HttpMember... remoteMembers) {
    this(localMember, Arrays.asList(remoteMembers));
  }

  public HttpClusterConfig(HttpMember localMember, Collection<HttpMember> remoteMembers) {
    super(localMember, remoteMembers);
  }

  @Override
  public HttpClusterConfig copy() {
    return new HttpClusterConfig(localMember, remoteMembers);
  }

}
