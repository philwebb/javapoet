/*
 * Copyright (C) 2015 Square, Inc.
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
package com.squareup.javapoet;

/** Formatting options to apply when emitting code. */
public final class Formatting {

  public static final Formatting DEFAULT = builder().build();

  final String indent;
  final boolean separateFirstMember;

  private Formatting(Builder builder) {
    this.indent = builder.indent;
    this.separateFirstMember = builder.separateFirstMember;
  }

  public Builder toBuilder() {
    return new Builder(indent, separateFirstMember);
  }

  public static Builder builder() {
    return new Builder("  ", false);
  }

  public static final class Builder {
    private String indent;
    private boolean separateFirstMember;

    private Builder(String indent, boolean separateFirstMember) {
      this.indent = indent;
      this.separateFirstMember = separateFirstMember;
    }

    public Builder indent(String indent) {
      this.indent =  indent;
      return this;
    }

    public Builder separateFirstMember(boolean separateFirstMember) {
      this.separateFirstMember = separateFirstMember;
      return this;
    }

    public Formatting build() {
      return new Formatting(this);
    }

  }
}
