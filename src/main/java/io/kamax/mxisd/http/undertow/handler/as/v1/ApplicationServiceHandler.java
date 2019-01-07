/*
 * mxisd - Matrix Identity Server Daemon
 * Copyright (C) 2018 Kamax Sarl
 *
 * https://www.kamax.io/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.mxisd.http.undertow.handler.as.v1;

import io.kamax.mxisd.http.undertow.handler.BasicHttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.LinkedList;
import java.util.Optional;

public abstract class ApplicationServiceHandler extends BasicHttpHandler {

    protected String getToken(HttpServerExchange ex) {
        return Optional.ofNullable(ex.getQueryParameters()
                .getOrDefault("access_token", new LinkedList<>())
                .peekFirst()
        ).orElse("");
    }

}