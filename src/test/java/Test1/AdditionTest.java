package Test1;

import static org.mockito.Mockito.mock;

import Test1.RandomStuff.Addition;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.*;

import static com.google.common.truth.Truth.assertThat;

@RunWith(Enclosed.class)
public class AdditionTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @RunWith(Parameterized.class)
    public static class AdditionParameterizedTest{
        private final Iterable<Integer> values;
        private final int result;

        @Parameters
        public static Collection<Object[]> getTestParameters() {
            Object[][] data = new Object[][] {
                    {Arrays.asList(1,2,3,4), 10},
                    {Arrays.asList(1,2,3,5), 11},
                    {Arrays.asList(-1,2,3,5), 9},
                    {List.of(0), 0},
                    {Collections.emptyList(), 0}
            };
            return Arrays.asList(data);
        }

        public AdditionParameterizedTest(Iterable<Integer> v, int res) {
            this.values = v;
            this.result = res;
        }

        @Test
        public void sum() {
            assertThat(Addition.sum(values)).isEqualTo(result);
        }
    }

    public static class AdditionWithoutParametersTest {
        @Test
        public void addTest() {
            assertThat(Addition.add(0,0)).isEqualTo(0);
        }
        @Test
        public void addTest2() {
            assertThat(Addition.add(1,1)).isEqualTo(2);
        }
    }
}