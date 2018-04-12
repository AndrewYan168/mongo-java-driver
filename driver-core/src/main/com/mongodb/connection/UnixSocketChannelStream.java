/*
 * Copyright 2008-present MongoDB, Inc.
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

package com.mongodb.connection;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.UnixServerAddress;
import jnr.unixsocket.UnixSocketAddress;
import jnr.unixsocket.UnixSocketChannel;

import java.io.IOException;

class UnixSocketChannelStream extends SocketChannelStream {
    private final UnixServerAddress address;

    UnixSocketChannelStream(final UnixServerAddress address, final SocketSettings settings, final SslSettings sslSettings,
                            final BufferProvider bufferProvider) {
        super(address, settings, sslSettings, bufferProvider);
        this.address = address;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void open() {
        try {
            setSocketChannel(UnixSocketChannel.open((UnixSocketAddress) address.getUnixSocketAddress()));
        } catch (IOException e) {
            close();
            throw new MongoSocketOpenException("Exception opening socket", getAddress(), e);
        }
    }
}