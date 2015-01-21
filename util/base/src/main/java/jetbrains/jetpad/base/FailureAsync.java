/*
 * Copyright 2012-2014 JetBrains s.r.o
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.jetpad.base;

public class FailureAsync<ValueT> implements Async<ValueT> {
  public final Throwable throwable;

  public FailureAsync(Throwable throwable) {
    this.throwable = throwable;
  }

  public Registration onSuccess(Handler<? super ValueT> successHandler) {
    return Registration.EMPTY;
  }

  public Registration onResult(Handler<? super ValueT> successHandler, Handler<Throwable> failureHandler) {
    return onFailure(failureHandler);
  }

  public Registration onFailure(Handler<Throwable> failureHandler) {
    failureHandler.handle(throwable);
    return Registration.EMPTY;
  }
}