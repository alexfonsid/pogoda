import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://myfin.by/currency/minsk";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

//  \

    private static Pattern pattern = Pattern.compile(".*\s" + "alt=" + "\\w*\\s.*");

    private static String getBankFromString(String string) throws Exception {
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can't find name of bank!");
    }

    public static void main(String[] args) throws Exception {

        Document page = getPage();
        Element currencyTable = page.select("tbody[class=sort_body]").first();
        Elements namesOfBank = currencyTable.select("tr[class*=c-currency-table__main-row]");

        for (Element bank : namesOfBank) {
            String nameBank = bank.getElementsByAttribute("alt").toString();
//
//            nameBank = bank.text();
//            System.out.println(bank);
//            System.out.println(nameBank);
//            System.out.println(bank.getElementsByAttribute("alt"));

            String name = nameBank.substring(74);
            name = name.replaceAll("\"\s.*", "");
            System.out.println(name);
            String curse = bank.select("td").text();
            System.out.println(curse);
        }


    }
}
