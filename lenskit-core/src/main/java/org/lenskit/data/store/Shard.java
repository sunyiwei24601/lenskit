/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2016 LensKit Contributors.  See CONTRIBUTORS.md.
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.lenskit.data.store;

/**
 * Created by michaelekstrand on 4/15/2017.
 */
abstract class Shard {
    static final int SHARD_SIZE = 2048;

    /**
     * Get the value at an index in the shard.
     * @param idx The index.
     * @return The value, or `null`.
     */
    abstract Object get(int idx);

    /**
     * Put a new value into the shard.
     * @param idx The index.
     * @param value The value (`null` to unset).
     */
    abstract void put(int idx, Object value);

    /**
     * Adapt this shard to be able to hold an object.
     * @param obj The object to store.
     * @return This shard, if it can hold the object, or a new shard that can.
     * @throws IllegalArgumentException if it is impossible to adapt this shard to the appropriate type.
     */
    abstract Shard adapt(Object obj);

    /**
     * Get the size (number of possibly-used values) in this shard.
     * @return The shard size.
     */
    abstract int size();

    /**
     * Compact this shard's storage to only the last used value.
     */
    abstract void compact();
}
