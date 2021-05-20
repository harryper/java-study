package com.lhb.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author harryper
 * @date 2020/7/31
 */
@SuppressWarnings("unused")
public class StreamTest {
    public static void main(String[] args) {
        //System.out.println(check("get", "h"));
        peekTest();
    }


    /**
     *  Stream 操作分为 中间操作(Intermediate operations) 和 结束操作(Terminal operations) 两种。
     *      中间操作只是一种标记，只有结束操作才会触发实际计算。中间操作又分为 无状态(Stateless) 和 有状态(stateful)两种。
     *      无状态中间操作是指元素的处理不受前面元素的影响；有状态中间操作必须等所有元素处理之后才知道最终结果，比如排序操作。
     *
     *      结束操作又可以分为 短路操作 和 非短路操作。
     *      短路操作是指不用处理全部元素就可以返回结果，比如找到第一个满足条件的元素。
     *      之所以要进行如此精细的划分，是因为底层对每一种情况的处理方式不同。
     *
     * 中间操作(Intermediate operations)
     *      无状态(Stateless)
     *          unordered() filter() map() mapToInt() mapToLong() mapToDouble() flatMap() flatMapToInt() flatMapToLong() flatMapToDouble() peek()
     *      有状态(Stateful)
     *          distinct() sorted() sorted() limit() skip()
     * 结束操作(Terminal operations)
     *      非短路操作
     *          forEach() forEachOrdered() toArray() reduce() collect() max() min() count()
     *      短路操作(short-circuiting)
     *          anyMatch() allMatch() noneMatch() findFirst() findAny()
     */

    public static void peekTest() {
        Stream.of(1, 2, 3, 4)
                .filter(integer -> {
                    System.out.println("这是 filter 方法" + integer);
                    return integer > 2;
                })
                .peek(integer -> System.out.println("integer = " + integer));
    }


    public static boolean check(String ...params) {
        List<String> strings = Arrays.asList("get", "update", "add");
        return Arrays.stream(params).anyMatch(strings::contains);
    }
}
