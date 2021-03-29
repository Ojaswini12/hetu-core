/*
 * Copyright (C) 2018-2020. Huawei Technologies Co., Ltd. All rights reserved.
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
package io.hetu.core.materializedview.utils;

import io.prestosql.spi.ErrorCode;
import io.prestosql.spi.ErrorCodeSupplier;
import io.prestosql.spi.ErrorType;

import static io.prestosql.spi.ErrorType.EXTERNAL;

/**
 * MvErrorCode
 *
 * @since 2020-03-26
 */
public enum MaterializedViewErrorCode
        implements ErrorCodeSupplier
{
    /**
     * Thrown when a unsupported type
     */
    UNSUPPORTED_TYPE(1, EXTERNAL);

    private static final int ERROR_CODE_NUM = 0x0106_0000;
    private final ErrorCode errorCode;

    MaterializedViewErrorCode(int code, ErrorType type)
    {
        errorCode = new ErrorCode(code + ERROR_CODE_NUM, name(), type);
    }

    @Override
    public ErrorCode toErrorCode()
    {
        return errorCode;
    }
}