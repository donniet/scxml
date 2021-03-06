/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.scxml.model;

/**
 * The class in this SCXML object model that corresponds to the
 * &lt;history&gt; SCXML pseudo state element.
 *
 */
public class History extends TransitionTarget {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Whether this is a shallow or deep history, the default is shallow.
     */
    private boolean isDeep;

    /**
     * A conditionless transition representing the default history state
     * and indicates the state to transition to if the parent state has
     * never been entered before.
     */
    private Transition transition;

    /**
     * Default no-args constructor for XML Digester.
     */
    public History() {
        super();
    }

    /**
     * Get the transition.
     *
     * @return Returns the transition.
     */
    public final Transition getTransition() {
        return transition;
    }

    /**
     * Set the transition.
     *
     * @param transition The transition to set.
     */
    public final void setTransition(final Transition transition) {
        this.transition = transition;
        this.transition.setParent(this);
    }

    /**
     * Is this history &quot;deep&quot; (as against &quot;shallow&quot;).
     *
     * @return Returns whether this is a &quot;deep&quot; history
     */
    public final boolean isDeep() {
        return isDeep;
    }

    /**
     * This method is invoked by XML digester when parsing SCXML markup.
     *
     * @param type The history type, which can be &quot;shallow&quot; or
     * &quot;deep&quot;
     */
    public final void setType(final String type) {
        if (type.equals("deep")) {
            isDeep = true;
        }
        //shallow is by default
    }

}

