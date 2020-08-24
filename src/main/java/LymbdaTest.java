import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

interface Operation<T>{
    T oper(T  val1, T val2);
}
public class LymbdaTest {
    public static void main(String[] args) {
//        Operation<Integer> sum = (Integer a,Integer w)-> a+w;
//
//        System.out.println(sum.oper(5,6));
//        sum = (s,d)->{return s-d;};
//        System.out.println(sum.oper(5,3));
//        Operation<Double> sum1 = (a,s)->a+s;
//
//        Predicate<Integer> qwerty =(q)->q>4;
//        System.out.println(qwerty.test(3));
//
//        Consumer<Double> print = System.out::println;
//        print.accept(2.3445);
//
//        Function<Integer,Double> convert = (a)-> Double.valueOf(a);
//        System.out.println(convert.apply(45));

        Stream.of(1,2,3,4,5,6,7,8,9,0).sorted((val1,val2)->{if(val1>val2)return -1;else if(val1<val2)return 1;else return 0;}).limit(1).forEach(System.out::println);
        Stream.of(1,2,3,4,5,6,7,8,9,0).map(x->x*x).forEach(x->System.out.println(x));
    }
}