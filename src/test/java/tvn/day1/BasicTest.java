package tvn.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
    @Test
    void aIsVowels(){
        Assert.assertTrue(Basic.checkNguyenAm("a"));
    }
    @Test
    void numberIsNotVowels(){
        Assert.assertFalse(Basic.checkNguyenAm("b"));
    }
    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Please input letter only!")
    void doubleLetterIsNotVowels() {
        Assert.assertFalse(Basic.checkNguyenAm("aA"));
    }
    @Test
    void tc01(){
        Assert.assertFalse(Basic.isPalindrome("adfds"));
    }
    @Test
    void tc02(){
        Assert.assertTrue(Basic.isPalindrome("adfda"));
    }
    @Test
    void tc03(){
        Assert.assertTrue(Basic.isPalindrome("abcdcba"));
    }

}
