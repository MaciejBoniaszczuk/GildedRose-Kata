Maciej Boniaszczuk

****

**Zaawansowane języki programowania**

****

Gilded Rose Kata – Sprawozdanie

**1. Wstęp**

Praca została wykonana w języku Java. Celem projektu było zrefaktoryzowanie kodu sklepu. Należało tego dokonać wykorzystując metodę małych kroków, opierając się na zasadach SOLID, z głównym naciskiem na zasadę Open/Closed, która mówi o tym aby kod był „możliwy do rozszerzenia i zamknięty na modyfikacje”.

**2. Przebieg pracy nad projektem**

****

**Napisanie testu:**

****

Na samym początku warto zmodyfikować istniejący już w klasie „GildedRoseTest” test, tak aby sprawdzał, czy zmiany wprowadzane podczas refaktoryzacji, nie powodują błędnych wyników. Do testowania skorzystano z metody „Approvals.verify”, która dokonuje zapisu wyników, a następnie porównuje go do kolejnego testu, sprawdzając czy wyniki nie uległy zmianie. Poniższy rysunek przedstawia kod testu „update Quality()”.

****

****

****

Rys1. Test: update Quality()

Refaktoryzacja:

Refaktoryzację zacząłem od „extract method”. W głównej metodzie programu „updateQuality” zostawiłem tylko pętlę for (zmieniłem ją na for each), która iteruje po każdym z istniejących itemów. Poniższy rysunek przedstawia wyżej wspomnianą metodę.




Następnie metoda „updateQuality” przenosi nas do „wyjętej” metody doUpdateQuality, w której odbywa się główne działanie programu. Początkowo zawartość tej pętli była bardzo skomplikowana i trudna do zrozumienia ponieważ powtarzało się tam wiele if-ów oraz else-ów. Poniżej metoda doUpdateQuality przed refaktoryzacją.




Następnie kod został poddany testowi w CodeClimate. Otrzymany wynik maintainability to F.




Uwzględniając podpowiedzi jakie wygenerował CodeClimate postanowiłem kontynuować refaktoryzację kodu. W metodzie doUpdateQuality zastosowałem instrukcję switch, która w zależności od nazwy itemu wykonuje określoną metodę. Poniżej zrefaktoryzowana metoda doUpdateQuality.




Jak widać na powyższym rysunku powstały 4 kolejne metody, w których znajdował się  kod odpowiadający za zmienianie wartości „sellIn” oraz „quality” dla każdego z itemów. Ponownie przetestowano kod w CodeClimate, jednak wynik nadal nie był zadowalający. Powtarzające się fragmenty kodu ponownie „wyekstraktowano” na zewnątrz”. Finalnie CodeClimat ocenił kod na najlepszą ocenę – A.




Na końcu przetestowano działanie sklepu w okresie 120 dni. Test nie wykrył żadnych błędów.



*Rysunki dostepne w pdfie załączonym do repozytorium*