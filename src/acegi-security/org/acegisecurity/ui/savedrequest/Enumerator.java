/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acegisecurity.ui.savedrequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


/**
 * <p>Adapter that wraps an <code>Enumeration</code> around a Java 2 collection <code>Iterator</code>.</p>
 * <p>Constructors are provided to easily create such wrappers.</p>
 * <p>This class is based on code in Apache Tomcat.</p>
 *
 * @author Craig McClanahan
 * @author Andrey Grebnev
 * @version $Id: Enumerator.java 1784 2007-02-24 21:00:24Z luke_t $
 */
public class Enumerator implements Enumeration {
    //~ Instance fields ================================================================================================

    /**
     * The <code>Iterator</code> over which the <code>Enumeration</code> represented by this class actually operates.
     */
    private Iterator iterator = null;

    //~ Constructors ===================================================================================================

/**
     * Return an Enumeration over the values of the specified Collection.
     *
     * @param collection Collection whose values should be enumerated
     */
    public Enumerator(Collection collection) {
        this(collection.iterator());
    }

/**
     * Return an Enumeration over the values of the specified Collection.
     *
     * @param collection Collection whose values should be enumerated
     * @param clone true to clone iterator
     */
    public Enumerator(Collection collection, boolean clone) {
        this(collection.iterator(), clone);
    }

/**
     * Return an Enumeration over the values returned by the specified
     * Iterator.
     *
     * @param iterator Iterator to be wrapped
     */
    public Enumerator(Iterator iterator) {
        super();
        this.iterator = iterator;
    }

/**
     * Return an Enumeration over the values returned by the specified
     * Iterator.
     *
     * @param iterator Iterator to be wrapped
     * @param clone true to clone iterator
     */
    public Enumerator(Iterator iterator, boolean clone) {
        super();

        if (!clone) {
            this.iterator = iterator;
        } else {
            List list = new ArrayList();

            while (iterator.hasNext()) {
                list.add(iterator.next());
            }

            this.iterator = list.iterator();
        }
    }

/**
     * Return an Enumeration over the values of the specified Map.
     *
     * @param map Map whose values should be enumerated
     */
    public Enumerator(Map map) {
        this(map.values().iterator());
    }

/**
     * Return an Enumeration over the values of the specified Map.
     *
     * @param map Map whose values should be enumerated
     * @param clone true to clone iterator
     */
    public Enumerator(Map map, boolean clone) {
        this(map.values().iterator(), clone);
    }

    //~ Methods ========================================================================================================

    /**
     * Tests if this enumeration contains more elements.
     *
     * @return <code>true</code> if and only if this enumeration object contains at least one more element to provide,
     *         <code>false</code> otherwise
     */
    public boolean hasMoreElements() {
        return (iterator.hasNext());
    }

    /**
     * Returns the next element of this enumeration if this enumeration has at least one more element to
     * provide.
     *
     * @return the next element of this enumeration
     *
     * @exception NoSuchElementException if no more elements exist
     */
    public Object nextElement() throws NoSuchElementException {
        return (iterator.next());
    }
}
