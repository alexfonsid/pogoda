import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://myfin.by/currency/minsk";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(getPage());
        Document page= getPage();
        Element currencyTable = page.select("tbody[class=sort_body]").first();
        Elements namesOfBank = currencyTable.select("tr[class=c-currency-table__main-row]");

//        System.out.println(currencyTable);

        for (Element nameOfBank : namesOfBank) {
            System.out.println(nameOfBank);
        }

        String date = "";
//        System.out.println(date + "\t явления\t температура\t скорость\t ветра\t влажность");
//        System.out.println("1\t        2\t        3\t        4\t        5\t        6");
    }
}
