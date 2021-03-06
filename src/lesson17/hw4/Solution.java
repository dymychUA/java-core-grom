package lesson17.hw4;

public class Solution {
    public static void main(String[] args) {

        //4
        System.out.println(validate("https://ukr.net"));
        System.out.println(validate("www.spb.ru"));
    }


    //4
    public static boolean validate(String address) {

        String[] protocols = {"http://www.", "https://www.", "http://", "https://"};
        String[] domains = {".com", ".org", ".net"};

        String domainName = address;
        for (String protocol : protocols) {
            domainName = domainName.replaceFirst(protocol, "");
            if (!domainName.equals(address))
                break;
        }

        String addressWithDomain = domainName;
        for (String domain : domains) {
            domainName = domainName.replaceFirst(domain, "");
            if (!domainName.equals(addressWithDomain))
                break;
        }

        return validateProtocol(address, protocols) && validateDomains(address, domains) && validateSymbolsWithDigits(domainName);
    }


    public static boolean validateProtocol(String address, String[] protocols) {

        for (String protocol : protocols) {
            if (address.startsWith(protocol))
                return true;
        }

        return false;
    }

    public static boolean validateDomains(String address, String[] domains) {

        for (String domain : domains) {
            if (address.endsWith(domain))
                return true;
        }

        return false;
    }

    public static boolean validateSymbolsWithDigits(String input) {

        for (char symbol : input.toCharArray()) {
            if(!Character.isLetterOrDigit(symbol))
                return false;
        }

        return !input.isEmpty();
    }

}
