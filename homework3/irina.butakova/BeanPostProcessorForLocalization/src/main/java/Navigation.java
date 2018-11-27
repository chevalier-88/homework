public class Navigation {

    @Localized(key = "navigation.item.home")
    private String home;

    @Localized(key = "navigation.item.blog")
    private String blog;

    @Localized(key = "navigation.item.about")
    private String about;

    @Localized(key = "navigation.item.contact")
    private String contact;

    public String getHomeItemName() {
        return home;
    }

    public String getBlogItemName() {
        return blog;
    }

    public String getAboutItemName() {
        return about;
    }

    public String getContactItemName() {
        return contact;
    }

    @Override
    public String toString() {
        return "Navigation { " + home + " " + blog + " " + about + " " + contact + " }";
    }
}
