package task2;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Вениамин on 7/14/2017.
 */
public class UserTest {


    Locale locale ;


    ResourceBundle bundleQest;


    ResourceBundle bundleAnsw;
    /*
    in this constructor your should chose you language
    @param int
    1-english
    2-russian
    in enother way the local will set like an english
     */

    UserTest(int countOfLang){
        switch (countOfLang){
            case 1:
                locale = new Locale("en","US");
                break;
            case 2:
                locale = new Locale("ru","RU");
                break;
            default:
                locale = new Locale("en","US");
                break;
        }

        try {
            bundleQest = ResourceBundle.getBundle("questions", locale);

            bundleAnsw = ResourceBundle.getBundle("answers", locale);
        }
        catch (MissingResourceException e){
            System.out.println("Exception thrown  :" + e);
        }

    }


    void showQuestions(){
        String q = "q";
        for (int i = 1; i <= 3;i++){
            System.out.println(i+"."+this.bundleQest.getString(q+i));
        }
    }
    // form one to three
    void showAnswer(int quesNumber){
        String a = "a";
        try {
            System.out.println("The answer on "+quesNumber +" question is:"+ " - " + this.bundleAnsw.getString(a + quesNumber));
        }
        catch (MissingResourceException e){
            System.out.println("the question with this number don't exist "+e);
        }
    }
}
