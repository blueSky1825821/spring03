package com.test.test;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ComparisonChain;
import org.junit.Test;

import java.util.Set;

import static com.google.common.base.Preconditions.checkElementIndex;

/**
 * Created by sky on 2017/6/9.
 */
public class GuavaTest {
    @Test
    public void testOptional() throws Exception {
        Optional<Integer> possible=Optional.of(6);
        Optional<Integer> absentOpt=Optional.absent();
        Optional<Integer> NullableOpt=Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
        if(absentOpt.isPresent()){
            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
        }
        if(NullableOpt.isPresent()){
            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
        }
        if(NoNullableOpt.isPresent()){
            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
        }
    }

    @Test
    public void testMethodReturn() {
        Optional<Long> value = method();
        if(value.isPresent()==true){
            System.out.println("获得返回值: " + value.get());
        }else{

            System.out.println("获得返回值: " + value.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + value.orNull());

        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent()==true){
            Set<Long> set=valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());
            System.out.println("获得返回值: " + valueNoNull.get());
        }else{
            System.out.println("获得返回值: " + valueNoNull.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private Optional<Long> method() {
        return Optional.fromNullable(null);
    }
    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }


    @Test
    public void testCheck() {
        int i = -1;
        int[] a = {1, 2};
//        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
//        checkNotNull(null,"s");
//        checkState(false);
        checkElementIndex(3, a.length);
    }

    @Test
    public void testObjects() {
        System.out.println(Objects.equal("a", "a"));
        Comp comp1 = new Comp();
        Comp comp2 = new Comp();
        comp1.setId("a");
        comp2.setId("a");
        comp1.setSs("a");
        comp2.setSs("b");
        System.out.println(comp1.compareTo(comp2));
    }

    class Comp {
        private String id;
        private String ss;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }

        public int compareTo(Comp a) {
            return ComparisonChain.start().compare(this.id, a.id)
                    .compare(this.ss, a.ss).result();
        }
    }

}
