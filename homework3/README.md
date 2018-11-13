### Localized Strings using Java Annotations and BeanPostProcessor

Create and implement BeanPostProcessor
which looks for `@LocalizedString`
annotation on fields of type `String`,
reads `key` and assigns localized string
according to user locale

 - Translated string should be stored in
property files, look at Java
ResourceBundle as an example
 - [Understanding Locale in the Java Platform](https://www.oracle.com/technetwork/articles/java/locale-140624.html)
