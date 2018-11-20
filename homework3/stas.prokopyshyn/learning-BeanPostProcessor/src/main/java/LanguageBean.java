import java.util.Locale;

public class LanguageBean {

    @LocalizedString(key = "greetings")
    private String greetings;

    @LocalizedString(key = "dinnerWelcoming")
    private String dinnerWelcoming;

    @LocalizedString(key = "toastProposal")
    private String toastProposal;

    @LocalizedString(key = "greetings")
    private String greetings2;


    private void init(){
        System.out.println("LanguageBean is initializing..........");
        System.out.println("Dinner Welcoming in " + Locale.getDefault().getDisplayLanguage() + " - " + dinnerWelcoming);
        System.out.println("That's how we say Hello in " + Locale.getDefault().getDisplayLanguage() + " - " + greetings);
        System.out.printf("Let's say a toast in %s - %s", Locale.getDefault().getDisplayLanguage(), toastProposal);

    }
}
