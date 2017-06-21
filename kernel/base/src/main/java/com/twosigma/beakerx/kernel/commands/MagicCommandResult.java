/*
 *  Copyright 2017 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.twosigma.beakerx.kernel.commands;

import com.twosigma.beakerx.kernel.Code;
import com.twosigma.beakerx.message.Message;

import java.util.LinkedList;
import java.util.List;

public class MagicCommandResult {

  private LinkedList<MagicCommandResultItem> items = new LinkedList<>();

  public void addItem(MagicCommandResultItem magicCommandResultItem) {
    this.items.add(magicCommandResultItem);
  }

  public boolean hasCodeToExecute() {
    MagicCommandResultItem last = items.getLast();
    return last.hasCodeToExecute();
  }

  public Message getResultMessage() {
    return items.getLast().getResultMessage().get();
  }

  public Message replyMessage() {
    return items.getLast().getReplyWithoutStatus().get();
  }

  public Code getCode() {
    return items.getLast().getCode().get();
  }

  public List<MagicCommandResultItem> getItems() {
    return items;
  }
}