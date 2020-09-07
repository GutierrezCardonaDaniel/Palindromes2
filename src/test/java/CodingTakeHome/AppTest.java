package CodingTakeHome;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    SoftAssertions softly = new SoftAssertions();
    @Test
    public void VerifyWithOneParenthesis()
    {
        softly.assertThat(Parenthesis.finalLogic("(Demo)"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("omed");
        softly.assertThat(Parenthesis.finalLogic("foo(bar)baz"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("foorabbaz");
        softly.assertAll();
    }
    @Test
    public void VerifyWithTwoIndependentParenthesis()
    {
        softly.assertThat(Parenthesis.finalLogic("foo(bar)baz(blim)"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("foorabbazmilb");
        softly.assertAll();
    }
    @Test
    public void VerifyWithMultipleIndependentParenthesis()
    {
        softly.assertThat(Parenthesis.finalLogic("(foo)(bar)(baz)(blim)"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("oofrabzabmilb");
        softly.assertAll();
    }
    @Test
    public void VerifyWithOneDependentParenthesis()
    {
        softly.assertThat(Parenthesis.finalLogic("foo(bar(baz))blim"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("foobazrabblim");
        softly.assertAll();
    }
    @Test
    public void VerifyWithMultipleDependentParenthesis()
    {
        softly.assertThat(Parenthesis.finalLogic("(foo(bar((baz)(zam))))blim"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("barzambazoofblim");
        softly.assertAll();
    }
    @Test
    public void VerifyWithHighDependencyParenthesis()
    {
        softly.assertThat(Parenthesis.finalLogic("((foo(((bar))((baz)(zam)))blim)(jol(zet)))"))
                .as("Parenthesis Palindrome" )
                .isEqualTo("joltezfoozabmazrabblim");
        softly.assertAll();
    }
}
