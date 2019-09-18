/*
 * Copyright 2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.client;

import com.mongodb.client.model.Collation;

import java.util.concurrent.TimeUnit;

/**
 * Iterable for aggregate.
 *
 * @param <TResult> The type of the result.
 *
 * @since 3.0
 */
public interface AggregateIterable<TResult> extends MongoIterable<TResult> {

    /**
     * Aggregates documents according to the specified aggregation pipeline, which must end with a $out stage.
     *
     * @throws IllegalStateException if the pipeline does not end with a $out stage
     *
     * @since 3.4
     */
    void toCollection();

    /**
     * Enables writing to temporary files. A null value indicates that it's unspecified.
     *
     * @param allowDiskUse true if writing to temporary files is enabled
     * @return this
     *
     *
     */
    AggregateIterable<TResult> allowDiskUse(Boolean allowDiskUse);

    /**
     * Sets the number of documents to return per batch.
     *
     * @param batchSize the batch size
     * @return this
     *
     */
    AggregateIterable<TResult> batchSize(int batchSize);

    /**
     * Sets the maximum execution time on the server for this operation.
     *
     * @param maxTime  the max time
     * @param timeUnit the time unit, which may not be null
     * @return this
     *
     */
    AggregateIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit);

    /**
     * Sets whether the server should use a cursor to return results.
     *
     * @param useCursor whether the server should use a cursor to return results
     * @return this
     *
     *
     */
    AggregateIterable<TResult> useCursor(Boolean useCursor);

    /**
     * Sets the bypass document level validation flag.
     *
     * <p>Note: This only applies when an $out stage is specified</p>.
     *
     * @param bypassDocumentValidation If true, allows the write to opt-out of document level validation.
     * @return this
     * @since 3.2
     *
     *
     */
    AggregateIterable<TResult> bypassDocumentValidation(Boolean bypassDocumentValidation);

    /**
     * Sets the collation options
     *
     * <p>A null value represents the server default.</p>
     * @param collation the collation options to use
     * @return this
     * @since 3.4
     *
     */
    AggregateIterable<TResult> collation(Collation collation);
}
