/**
 * Copyright 2007-2016, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.service.turn.proxy;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

/**
 * Created by APirvu on 8/29/2016.
 */
public class InheritedTestsFilter extends Filter {
    @Override
    public boolean shouldRun(Description description) {
        Class<?> clazz = description.getTestClass();
        String methodName = description.getMethodName();
        if (clazz.isAnnotationPresent(IgnoreBaseClassTests.class)) {
            try {
                return clazz.getDeclaredMethod(methodName) == null;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String describe() {
        return null;
    }
}
