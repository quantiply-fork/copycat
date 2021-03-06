/*
 * Copyright 2014 the original author or authors.
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
package net.kuujo.copycat.protocol;

import java.util.List;

/**
 * Submit command request.<p>
 *
 * Submit requests are simply operation submissions that are forwarded
 * to the cluster leader. When a node receives an operation submission,
 * it can optionally reject the operation or forward it using this request.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class SubmitRequest extends Request {
  private static final long serialVersionUID = -8657438748181101192L;
  private String operation;
  private List<Object> args;

  public SubmitRequest() {
    super(null);
  }

  public SubmitRequest(Object id, String operation, List<Object> args) {
    super(id);
    this.operation = operation;
    this.args = args;
  }

  /**
   * Returns the request operation.
   *
   * @return The operation being submitted.
   */
  public String operation() {
    return operation;
  }

  /**
   * Returns the request arguments.
   *
   * @return The arguments to apply to the command being submitted.
   */
  public List<Object> args() {
    return args;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof SubmitRequest) {
      SubmitRequest request = (SubmitRequest) object;
      return request.id().equals(id()) && request.operation.equals(operation) && request.args.equals(args);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = 37 * hashCode + id().hashCode();
    hashCode = 37 * hashCode + operation.hashCode();
    hashCode = 37 * hashCode + args.hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%s[id=%s, operation=%s, args=%s]", getClass().getSimpleName(), id(), operation, args);
  }

}
