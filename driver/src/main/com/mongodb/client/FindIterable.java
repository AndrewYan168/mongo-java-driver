/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
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

package com.mongodb.client;

import com.mongodb.CursorType;
import com.mongodb.client.model.Collation;
import org.bson.conversions.Bson;

import java.util.concurrent.TimeUnit;

/**
 * Iterable for find.
 *
 * @param <TResult> The type of the result.
 * @since 3.0
 */
public interface FindIterable<TResult> extends MongoIterable<TResult> {

    /**
     * Sets the query filter to apply to the query.
     *
     * @param filter the filter, which may be null.
     * @return this
     *
     */
    FindIterable<TResult> filter(Bson filter);

    /**
     * Sets the limit to apply.
     *
     * @param limit the limit, which may be null
     * @return this
     *
     */
    FindIterable<TResult> limit(int limit);
    /**
     * Sets the number of documents to skip.
     *
     * @param skip the number of documents to skip
     * @return this
     *
     */
    FindIterable<TResult> skip(int skip);

    /**
     * Sets the maximum execution time on the server for this operation.
     *
     * @param maxTime  the max time
     * @param timeUnit the time unit, which may not be null
     * @return this
     *
     */
    FindIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit);

    /**
     * The maximum amount of time for the server to wait on new documents to satisfy a tailable cursor
     * query. This only applies to a TAILABLE_AWAIT cursor. When the cursor is not a TAILABLE_AWAIT cursor,
     * this option is ignored.
     *
     * On servers &gt;= 3.2, this option will be specified on the getMore command as "maxTimeMS". The default
     * is no value: no "maxTimeMS" is sent to the server with the getMore command.
     *
     * On servers &lt; 3.2, this option is ignored, and indicates that the driver should respect the server's default value
     *
     * A zero value will be ignored.
     *
     * @param maxAwaitTime  the max await time
     * @param timeUnit the time unit to return the result in
     * @return the maximum await execution time in the given time unit
     *
     * @since 3.2
     */
    FindIterable<TResult> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit);

    /**
     * Sets the query modifiers to apply to this operation.
     *
     * @param modifiers the query modifiers to apply, which may be null.
     * @return this
     *
     */
    FindIterable<TResult> modifiers(Bson modifiers);

    /**
     * Sets a document describing the fields to return for all matching documents.
     *
     * @param projection the project document, which may be null.
     * @return this
     *
     */
    FindIterable<TResult> projection(Bson projection);
    /**
     * Sets the sort criteria to apply to the query.
     *
     * @param sort the sort criteria, which may be null.
     * @return this
     *
     */
    FindIterable<TResult> sort(Bson sort);

    /**
     * The server normally times out idle cursors after an inactivity period (10 minutes)
     * to prevent excess memory use. Set this option to prevent that.
     *
     * @param noCursorTimeout true if cursor timeout is disabled
     * @return this
     */
    FindIterable<TResult> noCursorTimeout(boolean noCursorTimeout);

    /**
     * Users should not set this under normal circumstances.
     *
     * @param oplogReplay if oplog replay is enabled
     * @return this
     */
    FindIterable<TResult> oplogReplay(boolean oplogReplay);

    /**
     * Get partial results from a sharded cluster if one or more shards are unreachable (instead of throwing an error).
     *
     * @param partial if partial results for sharded clusters is enabled
     * @return this
     */
    FindIterable<TResult> partial(boolean partial);

    /**
     * Sets the cursor type.
     *
     * @param cursorType the cursor type
     * @return this
     */
    FindIterable<TResult> cursorType(CursorType cursorType);

    /**
     * Sets the number of documents to return per batch.
     *
     * @param batchSize the batch size
     * @return this
     *
     */
    @Override
    FindIterable<TResult> batchSize(int batchSize);

    /**
     * Sets the collation options
     *
     * <p>A null value represents the server default.</p>
     * @param collation the collation options to use
     * @return this
     * @since 3.4
     *
     */
    FindIterable<TResult> collation(Collation collation);
}
