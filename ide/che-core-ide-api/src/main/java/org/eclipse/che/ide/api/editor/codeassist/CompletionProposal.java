/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.api.editor.codeassist;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import org.eclipse.che.ide.api.icon.Icon;

/**
 * The interface of completion proposals generated by content assist processors. A completion
 * proposal contains information used to present the proposed completion to the user, to insert the
 * completion should the user select it, and to present context information for the chosen
 * completion once it has been inserted.
 *
 * <p>This interface can be implemented by clients
 */
public interface CompletionProposal {

  /**
   * Returns optional additional information about the proposal. The additional information will be
   * presented to assist the user in deciding if the selected proposal is the desired choice.
   *
   * @param callback a callback to return a widget with additional information
   */
  void getAdditionalProposalInfo(AsyncCallback<Widget> callback);

  /**
   * Returns the string to be displayed in the list of completion proposals.
   *
   * @return the string to be displayed
   */
  String getDisplayString();

  /**
   * Returns the image to be displayed in the list of completion proposals. The image would
   * typically be shown to the left of the display string.
   *
   * @return the image to be shown or <code>null</code> if no image is desired
   */
  Icon getIcon();

  void getCompletion(CompletionCallback callback);

  /** Callback called when the completion is applied. */
  interface CompletionCallback {
    void onCompletion(Completion completion);
  }
}