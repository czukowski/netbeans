/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.j2ee.weblogic9.ui.nodes.actions;

import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.NodeAction;

/**
 *
 * @author Petr Hejl
 */
public class RefreshModulesAction extends NodeAction {

    @Override
    protected boolean enable(org.openide.nodes.Node[] nodes) {
        RefreshModulesCookie cookie;
        for (int i = 0; i < nodes.length; i++) {
            cookie = nodes[i].getCookie(RefreshModulesCookie.class);
            if (cookie == null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(RefreshModulesAction.class, "LBL_RefreshModulesAction"); // NOI18N
    }

    @Override
    protected void performAction(org.openide.nodes.Node[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            RefreshModulesCookie cookie = nodes[i].getCookie(RefreshModulesCookie.class);
            if (cookie != null) {
                cookie.refresh();
            }
        }
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    @Override
    public org.openide.util.HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
}
