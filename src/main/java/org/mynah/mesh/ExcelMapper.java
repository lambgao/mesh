/*
 * Copyright 2012-2013 the original author or authors.
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
package org.mynah.mesh;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ExcelMapper
 */
public final class ExcelMapper {

    /** Logger available to subclasses. */
    protected final Log logger = LogFactory.getLog(getClass());

    /**
     * Construct a new ExcelMapper for usage..
     */
    public ExcelMapper() {
    }

    /**
     * App log :-).
     */
    public void log() {
        this.logger.info("This is a message.");
    }

}
