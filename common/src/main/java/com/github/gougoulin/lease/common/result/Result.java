package com.github.gougoulin.lease.common.result;

import lombok.Data;

/**
 * A generic result class to encapsulate the response data, status code, and message.
 *
 * @param <T> The type of the data payload. This allows the Result class to be used with any data type.
 */
@Data
public class Result<T> {
    // T is the generic type
    // NOTE: class generic type T is different from generic type in static method
    // R is used in purpose to make this clear

    // Status code indicating the result of the operation (e.g., 200 for success, 500 for failure).
    private int code;
    // A message providing additional information about the result (e.g., error details or success confirmation).
    private String msg;
    // The actual data payload of the result. Its type is determined by the generic type parameter T.
    private T data;

    /**
     * Helper method to create a successful result with the provided data.
     *
     * @param data The data payload to include in the result.
     * @param <R>  The type of the data payload. This is independent of the class-level generic type T.
     * @return A Result object with the SUCCESS status and the provided data.
     */
    public static <R> Result<R> ok(R data) {
        return createResult(data, ResultOption.SUCCESS);
    }

    /**
     * Helper method to create a failed result with the provided error message.
     *
     * @param msg The error message to include in the result.
     * @param <R> The type of the data payload. This is independent of the class-level generic type T.
     * @return A Result object with the FAIL status and the provided error message.
     */
    public static <R> Result<R> fail(String msg) {
        Result<R> result = createResult(null, ResultOption.FAIL);
        result.setMsg(msg);
        return result;
    }

    /**
     * Custom builder method to create a Result object with the provided data and ResultOption.
     *
     * @param data    The data payload to include in the result.
     * @param option  The ResultOption (e.g., SUCCESS or FAIL) to set the status code and default message.
     * @param <R>     The type of the data payload. This is independent of the class-level generic type T.
     * @return A Result object initialized with the provided data and ResultOption.
     */
    public static <R> Result<R> createResult(R data, ResultOption option) {
        Result<R> result = createResult(data);
        result.code = option.getCode();
        result.msg = option.getDesc();
        return result;
    }

    /**
     * Basic builder method to create a Result object with the provided data.
     * The status code and message are not set by this method.
     *
     * @param data The data payload to include in the result.
     * @param <R>  The type of the data payload. This is independent of the class-level generic type T.
     * @return A Result object initialized with the provided data.
     */
    public static <R> Result<R> createResult(R data) {
        Result<R> result = new Result<>();
        result.data = data;
        return result;
    }

    /**
     * Helper method to create a Result object without a data payload, using only the provided ResultOption.
     *
     * @param option The ResultOption (e.g., SUCCESS or FAIL) to set the status code and default message.
     * @param <R>    The type of the data payload. This is independent of the class-level generic type T.
     * @return A Result object initialized with the provided ResultOption.
     */
    public static <R> Result<R> createResult(ResultOption option) {
        return createResult(null, option);
    }
}
