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

/**
 * Poll response.<p>
 *
 * Poll responses are sent in response to a poll request. The vote
 * response contains information regarding the requestee's current
 * term and whether it voted for the candidate.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class PollResponse extends Response {
  private static final long serialVersionUID = 8188723576438876929L;
  private long term;
  private boolean voteGranted;

  public PollResponse() {
  }

  public PollResponse(Object id, long term, boolean voteGranted) {
    super(id, Status.OK);
    this.term = term;
    this.voteGranted = voteGranted;
  }

  public PollResponse(Object id, Throwable t) {
    super(id, Status.ERROR, t);
  }

  public PollResponse(Object id, String message) {
    super(id, Status.ERROR, message);
  }

  /**
   * Returns the responding node's current term.
   * 
   * @return The responding node's current term.
   */
  public long term() {
    return term;
  }

  /**
   * Returns a boolean indicating whether the vote was granted.
   * 
   * @return Indicates whether the vote was granted.
   */
  public boolean voteGranted() {
    return voteGranted;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof PollResponse) {
      PollResponse response = (PollResponse) object;
      return response.id().equals(id()) && response.status().equals(status()) && response.term == term && response.voteGranted == voteGranted;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = 37 * hashCode + id().hashCode();
    hashCode = 37 * hashCode + status().hashCode();
    hashCode = 37 * hashCode + (int)(term ^ (term >>> 32));
    hashCode = 37 * hashCode + (voteGranted ? 1 : 0);
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%s[id=%s, term=%d, voteGranted=%b]", getClass().getSimpleName(), id(), term, voteGranted);
  }

}
