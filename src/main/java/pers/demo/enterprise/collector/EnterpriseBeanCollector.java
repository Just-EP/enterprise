package pers.demo.enterprise.collector;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/13 13:46
 */
public class EnterpriseBeanCollector<T, A, R> implements Collector<T, A, R> {
    @Override
    public Supplier<A> supplier() {
        return null;
    }

    @Override
    public BiConsumer<A, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<A> combiner() {
        return null;
    }

    @Override
    public Function<A, R> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
